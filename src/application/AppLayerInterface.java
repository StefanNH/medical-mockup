package application;

import utilities.Hospital;
import utilities.MedicalRecord;
import utilities.Patient;

public interface AppLayerInterface {
	public String addPatient(int id, String name, String address, String diagnosis);

	public Patient findPatient(int id);

	public String updatePatient(int id, String name, String address, String diagnosis);

	public String deletePatient(int id);

	public String addRecord(MedicalRecord rd);

	public MedicalRecord findRecord(int id);

	public String updateRecord(MedicalRecord rd);

	public String deleteRecord(int id);

	public String getRecords(int id);

	public String getSimilarDiagnosis(String diagnosis);

	public Hospital getClosestHospital(double x, double y);

}
