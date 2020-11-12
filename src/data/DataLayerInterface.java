package data;

import utilities.Patient;

public interface DataLayerInterface {
	public boolean addPatient(Patient pt);
	public Patient getPatient(int id);
}
