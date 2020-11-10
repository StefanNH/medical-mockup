package data;

import business.Patient;
import java.sql.*;

public class DataLayer implements DataLayerInterface {
	private static DataLayer dataLayerInstance = null;
	private static Connection conn;

	// Singleton design pattern to ensure single connection is used
	private DataLayer() {
		try {
			// connection string
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/kwikmedical?user=root&password=Secret123&serverTimezone=UTC");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataLayer getInstance() {
		if (dataLayerInstance == null) {
			dataLayerInstance = new DataLayer();
		}
		return dataLayerInstance;
	}

	@Override
	public Patient getPatient(int id) {
		Patient patient = new Patient();
		try {
			
			Statement stmt = conn.createStatement();
			String query = "SELECT patient_id, p_name, address, diagnosis FROM patients WHERE patient_id ="
					+ id + ";";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int patientID = rs.getInt("patient_id");
				String patientName = rs.getString("p_name");
				String patientAddress = rs.getString("address");
				String patientDiagnosis = rs.getString("diagnosis");
				patient.setId(patientID);
				patient.setName(patientName);
				patient.setAddress(patientAddress);
				patient.setDiagnosis(patientDiagnosis);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

}
