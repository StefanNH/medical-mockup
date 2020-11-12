package main;

import application.AppLayer;
import data.DataLayer;
import utilities.Patient;

public class App {
	public static void main(String[] args) {
		DataLayer dl = DataLayer.getInstance();
		Patient pt = dl.getPatient(1);
		Patient pt2 = dl.getPatient(2);
		Patient pt3 = dl.getPatient(3);
		boolean success = dl.addPatient(new Patient(3,"Henry Smith","23 North lane","Boroken foot"));
		AppLayer app = new AppLayer(dl);
		System.out.println(pt.toString());
		System.out.println(pt2.toString());
		System.out.println(pt3.toString());
		System.out.println(success);
	}
}
