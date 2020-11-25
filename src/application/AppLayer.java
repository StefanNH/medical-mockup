package application;

import java.util.ArrayList;
import java.util.Collections;

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
