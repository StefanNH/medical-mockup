package application;

import utilities.Patient;

public interface AppLayerInterface {
	public String addPatient(int id, String name, String address, String diagnosis);
	public Patient findPatient(int id);

}
