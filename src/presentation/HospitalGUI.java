package presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.AppLayerInterface;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospitalGUI extends JFrame{
		private AppLayerInterface appLayer;
		private JPanel panel;
		private JButton btnUpdate;
		private JTextField txtRecordID;
		private JTextField txtPatientID;
		private JTextField txtDiagnosis;
		private JTextField txtTreatment;
		private JTextField txtLat;
		private JTextField txtLong;
		private JTextField txtCallDuration;
	public HospitalGUI(AppLayerInterface app) {
		this.appLayer = app;
		panel = new JPanel();
		panel.setLayout(null);
		setSize(320,240);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(196, 37, 85, 21);
		panel.add(btnUpdate);
		
		JButton btnAddRecord = new JButton("ADD");
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddRecord.setBounds(196, 6, 85, 21);
		panel.add(btnAddRecord);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(196, 149, 85, 21);
		panel.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Record ID");
		lblNewLabel.setBounds(10, 10, 68, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		lblNewLabel_1.setBounds(10, 34, 68, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Diagnosis");
		lblNewLabel_2.setBounds(10, 61, 68, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Treatment");
		lblNewLabel_3.setBounds(10, 88, 68, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("latitude");
		lblNewLabel_4.setBounds(10, 111, 68, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("longitude");
		lblNewLabel_5.setBounds(10, 134, 68, 13);
		panel.add(lblNewLabel_5);
		
		txtRecordID = new JTextField();
		txtRecordID.setBounds(90, 7, 96, 19);
		panel.add(txtRecordID);
		txtRecordID.setColumns(10);
		
		txtPatientID = new JTextField();
		txtPatientID.setBounds(90, 31, 96, 19);
		panel.add(txtPatientID);
		txtPatientID.setColumns(10);
		
		txtDiagnosis = new JTextField();
		txtDiagnosis.setBounds(90, 58, 96, 19);
		panel.add(txtDiagnosis);
		txtDiagnosis.setColumns(10);
		
		txtTreatment = new JTextField();
		txtTreatment.setBounds(90, 85, 96, 19);
		panel.add(txtTreatment);
		txtTreatment.setColumns(10);
		
		txtLat = new JTextField();
		txtLat.setBounds(90, 108, 96, 19);
		panel.add(txtLat);
		txtLat.setColumns(10);
		
		txtLong = new JTextField();
		txtLong.setBounds(90, 131, 96, 19);
		panel.add(txtLong);
		txtLong.setColumns(10);
		
		JLabel lblResult = new JLabel("");
		lblResult.setBounds(10, 180, 286, 13);
		panel.add(lblResult);
		
		JLabel lblNewLabel_7 = new JLabel("call duration");
		lblNewLabel_7.setBounds(10, 157, 70, 13);
		panel.add(lblNewLabel_7);
		
		txtCallDuration = new JTextField();
		txtCallDuration.setBounds(90, 154, 96, 19);
		panel.add(txtCallDuration);
		txtCallDuration.setColumns(10);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Kwik Medical");
		setVisible(true);
	}
}
