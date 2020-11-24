package application;

import utilities.Patient;

public interface AppLayerInterface {
	public String addPatient(int id, String name, String address, String diagnosis);

	public Patient findPatient(int id);

	public String updatePatient(int id, String name, String address, String diagnosis);

	public String deletePatient(int id);
	
	public String getRecords(int id);

}
