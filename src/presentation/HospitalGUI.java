package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.AppLayerInterface;
import utilities.MedicalRecord;

public class HospitalGUI extends JFrame {
	private AppLayerInterface appLayer;
	private JPanel panel;
	private JButton btnAddRecord;
	private JButton btnUpdate;
	private JButton btnSearch;
	private JButton btnDelete;
	private JTextField txtRecordID;
	private JTextField txtPatientID;
	private JTextField txtDiagnosis;
	private JTextField txtTreatment;
	private JTextField txtLocation;
	private JTextField txtCallDuration;
	private JLabel lblResult;

	public HospitalGUI(AppLayerInterface app) {
		this.appLayer = app;
		panel = new JPanel();
		panel.setLayout(null);
		setSize(320, 240);
		getContentPane().add(panel, BorderLayout.CENTER);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(196, 30, 85, 21);
		btnUpdate.addActionListener(e -> {
			int recordID = Integer.parseInt(txtRecordID.getText());
			int patientID = Integer.parseInt(txtPatientID.getText());
			String diagnosis = txtDiagnosis.getText();
			String treatment = txtTreatment.getText();
			String location = txtLocation.getText();
			String timeDetails = txtCallDuration.getText();
			String result = appLayer
					.updateRecord(new MedicalRecord(recordID, patientID, diagnosis, treatment, location, timeDetails));
			lblResult.setText(result);
		});
		panel.add(btnUpdate);

		btnAddRecord = new JButton("ADD");
		btnAddRecord.addActionListener(e -> {
			int recordID = Integer.parseInt(txtRecordID.getText());
			int patientID = Integer.parseInt(txtPatientID.getText());
			String diagnosis = txtDiagnosis.getText();
			String treatment = txtTreatment.getText();
			String location = txtLocation.getText();
			String timeDetails = txtCallDuration.getText();
			String result = appLayer
					.addRecord(new MedicalRecord(recordID, patientID, diagnosis, treatment, location, timeDetails));
			lblResult.setText(result);
		});
		btnAddRecord.setBounds(196, 6, 85, 21);
		panel.add(btnAddRecord);

		btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(196, 53, 85, 37);
		btnSearch.addActionListener(e -> {
			int recordID = Integer.parseInt(txtRecordID.getText());
			MedicalRecord record = appLayer.findRecord(recordID);
			if (record.getId() == 0 && record.getDiagnosis() == null) {
				lblResult.setText("Record not found");
				txtPatientID.setText("");
				txtDiagnosis.setText("");
				txtTreatment.setText("");
				txtLocation.setText("");
				txtCallDuration.setText("");
			} else {
				txtPatientID.setText(String.valueOf(record.getPatient_id()));
				txtDiagnosis.setText(record.getDiagnosis());
				txtTreatment.setText(record.getTreatment());
				txtLocation.setText(record.getLocation());
				txtCallDuration.setText(record.getTime_details());
				lblResult.setText("Record found");
			}
		});
		panel.add(btnSearch);

		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(e -> {
			int response = JOptionPane.showConfirmDialog(null, "Press YES if you to continue?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				int patientID = Integer.parseInt(txtRecordID.getText());
				String result = appLayer.deleteRecord(patientID);
				lblResult.setText(result);
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(196, 130, 85, 21);
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

		JLabel lblNewLabel_4 = new JLabel("Location");
		lblNewLabel_4.setBounds(10, 111, 68, 13);
		panel.add(lblNewLabel_4);

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

		txtLocation = new JTextField();
		txtLocation.setBounds(90, 108, 96, 19);
		panel.add(txtLocation);
		txtLocation.setColumns(10);

		lblResult = new JLabel("");
		lblResult.setBounds(10, 172, 286, 21);
		panel.add(lblResult);

		JLabel lblNewLabel_7 = new JLabel("call duration");
		lblNewLabel_7.setBounds(10, 134, 70, 13);
		panel.add(lblNewLabel_7);

		txtCallDuration = new JTextField();
		txtCallDuration.setBounds(90, 131, 96, 19);
		panel.add(txtCallDuration);
		txtCallDuration.setColumns(10);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Records");
		setVisible(true);
	}
}
