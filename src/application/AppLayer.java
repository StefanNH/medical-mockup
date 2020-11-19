package application;

import data.DataLayerInterface;
import utilities.Patient;

public class AppLayer implements AppLayerInterface {
	private DataLayerInterface dt;
	
	public AppLayer(DataLayerInterface newDt) {
		dt = newDt;
	}
	
	@Override
	public String addPatient(int id, String name, String address, String diagnosis) {
		boolean success = dt.addPatient(new Patient(id,name,address,diagnosis));
		if(success) {
			return "Patient was added succesfully";
		}else {
			return "Failed to add pattient";
		}
	}

	@Override
	public Patient findPatient(int id) {
		return dt.getPatient(id);
		
	}
}
