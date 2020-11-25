package application;

import java.util.ArrayList;
import data.DataLayerInterface;
import utilities.Hospital;
import utilities.MedicalRecord;
import utilities.Patient;

public class AppLayer implements AppLayerInterface {
	private DataLayerInterface dt;

	public AppLayer(DataLayerInterface newDt) {
		dt = newDt;
	}

	@Override
	public String addPatient(int id, String name, String address, String diagnosis) {
		boolean success = dt.addPatient(new Patient(id, name, address, diagnosis));
		if (success) {
			return "Patient was added succesfully";
		} else {
			return "Failed to add pattient";
		}
	}

	@Override
	public Patient findPatient(int id) {
		return dt.getPatient(id);

	}

	@Override
	public String updatePatient(int id, String name, String address, String diagnosis) {
		boolean success = dt.updatePatient(new Patient(id, name, address, diagnosis));
		if (success) {
			return "Patient successfully updated";
		} else {
			return "Patient update failed";
		}
	}

	@Override
	public String deletePatient(int id) {
		boolean success = dt.deletePatient(id);
		if (success) {
			return "Patient deleted";
		} else {
			return "Failed to remove patient";
		}
	}

	@Override
	public String addRecord(MedicalRecord rd) {
		boolean success = dt.addRecord(rd);
		if (success) {
			return "Record added successfully";
		} else {
			return "Failed to add Record";
		}
	}

	@Override
	public MedicalRecord findRecord(int id) {
		return dt.getRecord(id);
	}

	@Override
	public String getRecords(int id) {
		ArrayList<MedicalRecord> res = dt.getRecords(id);
		String result = "";
		if (res.size() > 0) {
			for (var v : res) {
				result = result + v.toString() + "\r\n";
			}
		}
		return result;
	}

	@Override
	public String updateRecord(MedicalRecord rd) {
		boolean success = dt.updateRecord(rd);
		if (success) {
			return "Record updated successfully";
		} else {
			return "Record update failed";
		}
	}

	@Override
	public String deleteRecord(int id) {
		boolean success = dt.deleteRecord(id);
		if (success) {
			return "Record removed successfully";
		} else {
			return "Failed to remove Record";
		}
	}

	@Override
	public String getSimilarDiagnosis(String diagnosis) {
		ArrayList<MedicalRecord> res = dt.getSimilarDiagnosis(diagnosis);
		String result = "";
		if (res.size() > 0) {
			for (var v : res) {
				result = result + "Diagnosis: " + v.getDiagnosis() + " Treatment: " + v.getTreatment() + "\r\n";
			}
		} else {
			result = "No similar diagnosis found";
		}
		return result;
	}

	@Override
	public Hospital getClosestHospital(double x, double y) {
		ArrayList<Hospital> hospitals = dt.getHospitals();
		hospitals.forEach(hospital -> hospital.setDistance(x, y));
		Hospital temp = hospitals.get(0);
		for (Hospital h : hospitals) {
			if (h.getDistance() < temp.getDistance()) {
				temp = h;
			}
		}
		return temp;
	}
}
