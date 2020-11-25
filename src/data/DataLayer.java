package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import utilities.Hospital;
import utilities.MedicalRecord;
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

	@Override
	public boolean updatePatient(Patient pt) {
		try {
			stmt = conn.createStatement();
			String query = "SELECT patient_id, p_name, address, diagnosis FROM patients WHERE patient_id =" + pt.getId()
					+ ";";
			String update = "UPDATE patients SET p_name='" + pt.getName() + "', address='" + pt.getAddress()
					+ "', diagnosis='" + pt.getDiagnosis() + "' WHERE patient_id=" + pt.getId() + ";";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				stmt.executeUpdate(update);
				return true;
			} else {
				return false;
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
		return false;
	}

	@Override
	public boolean deletePatient(int id) {
		try {
			stmt = conn.createStatement();
			String query = "SELECT patient_id, p_name, address, diagnosis FROM patients WHERE patient_id =" + id + ";";
			String delete = "DELETE FROM patients WHERE patient_id=" + id + ";";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				stmt.executeUpdate(delete);
				return true;
			} else {
				return false;
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
		return false;

	}

	@Override
	public boolean addRecord(MedicalRecord rd) {
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM records WHERE med_id =" + rd.getId() + ";";
			String update = "INSERT INTO records (med_id,patient_id,diagnosis,treatment,location,time_details) "
					+ "VALUES (" + rd.getId() + ", " + rd.getPatient_id() + ", '" + rd.getDiagnosis() + "', '"
					+ rd.getTreatment() + "', '" + rd.getLocation() + "','" + rd.getTime_details() + "');";
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
	public MedicalRecord getRecord(int id) {
		MedicalRecord record = new MedicalRecord();
		try {

			stmt = conn.createStatement();
			String query = "SELECT med_id, patient_id, diagnosis, treatment, location, time_details FROM records WHERE med_id ="
					+ id + ";";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int recordID = rs.getInt("med_id");
				int patientID = rs.getInt("patient_id");
				String diagnosis = rs.getString("diagnosis");
				String treatment = rs.getString("treatment");
				String location = rs.getString("location");
				String time = rs.getString("time_details");
				record.setId(recordID);
				record.setPatient_id(patientID);
				record.setDiagnosis(diagnosis);
				record.setTreatment(treatment);
				record.setLocation(location);
				record.setTime_details(time);
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
		return record;
	}

	@Override
	public boolean updateRecord(MedicalRecord rd) {
		try {
			stmt = conn.createStatement();
			String query = "SELECT med_id, patient_id, diagnosis, treatment, location, time_details FROM records WHERE med_id ="
					+ rd.getId() + ";";
			String update = "UPDATE records SET patient_id =" + rd.getPatient_id() + ", diagnosis='" + rd.getDiagnosis()
					+ "', treatment='" + rd.getTreatment() + "', location='" + rd.getLocation() + "', time_details='"
					+ rd.getTime_details() + "' WHERE med_id=" + rd.getId() + ";";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				stmt.executeUpdate(update);
				return true;
			} else {
				return false;
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
		return false;
	}

	@Override
	public boolean deleteRecord(int id) {
		try {
			stmt = conn.createStatement();
			String query = "SELECT med_id, patient_id, diagnosis, treatment, location, time_details FROM records WHERE med_id="
					+ id + ";";
			String delete = "DELETE FROM records WHERE med_id=" + id + ";";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				stmt.executeUpdate(delete);
				return true;
			} else {
				return false;
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
		return false;
	}

	@Override
	public ArrayList<MedicalRecord> getRecords(int id) {
		ArrayList<MedicalRecord> res = new ArrayList<>();
		try {

			stmt = conn.createStatement();
			String query = "SELECT med_id, patient_id, diagnosis, treatment, location, time_details FROM records WHERE patient_id ="
					+ id + ";";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int medID = rs.getInt("med_id");
				int patientID = rs.getInt("patient_id");
				String diagnosis = rs.getString("diagnosis");
				String treatment = rs.getString("treatment");
				String location = rs.getString("location");
				String timeDetails = rs.getString("time_details");
				res.add(new MedicalRecord(medID, patientID, diagnosis, treatment, location, timeDetails));
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
		return res;
	}

	@Override
	public ArrayList<MedicalRecord> getSimilarDiagnosis(String diagnosis) {
		ArrayList<MedicalRecord> res = new ArrayList<>();
		try {

			stmt = conn.createStatement();
			String query = "SELECT med_id, patient_id, diagnosis, treatment, location, time_details FROM records WHERE diagnosis LIKE '%"
					+ diagnosis + "%';";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int medID = rs.getInt("med_id");
				int patientID = rs.getInt("patient_id");
				String diagnosisGET = rs.getString("diagnosis");
				String treatment = rs.getString("treatment");
				String location = rs.getString("location");
				String timeDetails = rs.getString("time_details");
				res.add(new MedicalRecord(medID, patientID, diagnosisGET, treatment, location, timeDetails));
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
		return res;
	}

	@Override
	public ArrayList<Hospital> getHospitals() {
		ArrayList<Hospital> res = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String query = "SELECT h_id, h_name, lat, lon FROM hospitals";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("h_id");
				String name = rs.getString("h_name");
				double lat = rs.getDouble("lat");
				double lon = rs.getDouble("lon");
				res.add(new Hospital(id, name, lat, lon));
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
		return res;
	}

}
