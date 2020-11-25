package data;

import java.util.ArrayList;

import utilities.Hospital;
import utilities.MedicalRecord;
import utilities.Patient;

public interface DataLayerInterface {
	public boolean addPatient(Patient pt);

	public Patient getPatient(int id);

	public boolean updatePatient(Patient pt);

	public boolean deletePatient(int id);
	
	public ArrayList<MedicalRecord> getRecords(int id);
	
	public ArrayList<MedicalRecord> getSimilarDiagnosis(String diagnosis);
	
	public ArrayList<Hospital> getHospitals();
}
