package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.AppLayerInterface;

public class SelectorGUI extends JFrame {
	private AppLayerInterface appLayer;
	private JPanel panel;
	private JButton btnOpenHospital;
	private JButton btnOpenMedCentre;

	public SelectorGUI(AppLayerInterface app) {
		this.appLayer = app;
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 10, 60));
		panel.setLayout(new GridLayout(1, 2));
		setSize(640,200);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		btnOpenHospital = new JButton("HOSPITAL");
		btnOpenHospital.setBounds(325, 45, 147, 21);
		btnOpenHospital.addActionListener(e->{
			new HospitalGUI(this.appLayer);
		});
		panel.setLayout(null);
		panel.add(btnOpenHospital);
		
		btnOpenMedCentre = new JButton("MEDICAL CENTRE");
		btnOpenMedCentre.setBounds(79, 45, 165, 21);
		btnOpenMedCentre.addActionListener(e -> {
			new KwikMedicalGUI(this.appLayer);
		});
		panel.add(btnOpenMedCentre);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kwik Medical");
		setVisible(true);
	}
}
