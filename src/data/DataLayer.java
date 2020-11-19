package data;

import java.sql.*;

import utilities.Patient;

public class DataLayer implements DataLayerInterface {
	private static DataLayer dataLayerInstance = null;
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;

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
	public boolean addPatient(Patient pt) {
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM patients WHERE patient_id =" + pt.getId() + " OR p_name LIKE '" + pt.getName()
					+ "';";
			String update = "INSERT INTO patients (patient_id, p_name, address, diagnosis) " + "VALUES (" + pt.getId()
					+ ", '" + pt.getName() + "', '" + pt.getAddress() + "','" + pt.getDiagnosis() + "');";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				return false;
			} else {
				stmt.executeUpdate(update);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;

	}

	@Override
	public Patient getPatient(int id) {
		Patient patient = new Patient();
		try {

			stmt = conn.createStatement();
			String query = "SELECT patient_id, p_name, address, diagnosis FROM patients WHERE patient_id =" + id + ";";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
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
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return patient;
	}


}
