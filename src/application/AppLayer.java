package application;

import data.DataLayerInterface;
import utilities.Patient;

public class AppLayer implements AppLayerInterface {
	private DataLayerInterface dt;
	
	public AppLayer(DataLayerInterface newDt) {
		dt = newDt;
	}
	
	public String addPatient() {
		dt.addPatient(new Patient());
		return"";
	}
}
