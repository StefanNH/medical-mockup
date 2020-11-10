package main;

import business.Patient;
import data.DataLayer;

public class App {
	public static void main(String[] args) {
		DataLayer dl = DataLayer.getInstance();
		Patient pt = dl.getPatient(1);
		System.out.println(pt.toString());
	}
}
