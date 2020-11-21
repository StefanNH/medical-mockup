package presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.AppLayerInterface;

public class HospitalGUI extends JFrame{
		private AppLayerInterface appLayer;
		private JPanel panel;
		private JButton btnUpdate;
	public HospitalGUI(AppLayerInterface app) {
		this.appLayer = app;
		panel = new JPanel();
		panel.setLayout(null);
		setSize(640,320);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(239, 71, 85, 21);
		panel.add(btnUpdate);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kwik Medical");
		setVisible(true);
	}

}
