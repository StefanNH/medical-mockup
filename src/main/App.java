package main;

import application.AppLayer;
import data.DataLayer;
import presentation.SelectorGUI;

public class App {
	public static void main(String[] args) {
		DataLayer dl = DataLayer.getInstance();
		AppLayer app = new AppLayer(dl);
		//KwikMedicalGUI gui = new KwikMedicalGUI(app);
		SelectorGUI gui2 = new SelectorGUI(app);
	}
}
