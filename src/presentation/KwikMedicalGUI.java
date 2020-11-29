package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import application.AppLayerInterface;
import utilities.Hospital;
import utilities.Patient;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.Box;

public class KwikMedicalGUI extends JFrame {
	private AppLayerInterface appLayer;
	private JPanel panel;
	private JTextField txtNHSnum;
	private JTextField txtName;
	private JTextField txtMedCondition;
	private JTextField txtAddress;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnSearch;
	private JButton btnDelete;
	private JButton btnUpdateRecords;
	private JButton btnShowRecords;
	private JButton btnSendDetails;
	private JButton btnMobile;
	private JLabel lblDisplayInfo;
	private JLabel lblMetaInfo;
	private JScrollPane scrollPane;
	private JTextArea txtAreaInfo;
	private JTextField txtCoordX;
	private JTextField txtCoordY;

	public KwikMedicalGUI(AppLayerInterface appLayer) {
		this.appLayer = appLayer;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));

		panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 10, 60));
		panel.setLayout(new GridLayout(3, 2));
		setSize(600, 450);
		getContentPane().setLayout(null);

		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("NHS number");
		lblNewLabel.setBounds(10, 10, 185, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 33, 185, 13);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Medical condition");
		lblNewLabel_2.setBounds(10, 56, 185, 13);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(10, 82, 185, 13);
		getContentPane().add(lblNewLabel_3);

		txtNHSnum = new JTextField();
		txtNHSnum.setBounds(205, 7, 247, 19);
		getContentPane().add(txtNHSnum);
		txtNHSnum.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(205, 30, 247, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtMedCondition = new JTextField();
		txtMedCondition.setBounds(205, 53, 247, 19);
		getContentPane().add(txtMedCondition);
		txtMedCondition.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(205, 79, 247, 19);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(e -> {
			int patientID = Integer.parseInt(txtNHSnum.getText());
			String name = txtName.getText();
			String address = txtAddress.getText();
			String diagnosis = txtMedCondition.getText();
			String result = appLayer.addPatient(patientID, name, address, diagnosis);
			lblDisplayInfo.setText(result);
		});
		btnAdd.setBounds(462, 6, 114, 21);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(462, 29, 114, 21);
		btnUpdate.addActionListener(e -> {
			int patientID = Integer.parseInt(txtNHSnum.getText());
			String name = txtName.getText();
			String address = txtAddress.getText();
			String diagnosis = txtMedCondition.getText();
			String result = appLayer.updatePatient(patientID, name, address, diagnosis);
			lblDisplayInfo.setText(result);
		});
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(462, 134, 114, 21);
		btnDelete.addActionListener(e -> {
			int response = JOptionPane.showConfirmDialog(null, "Press YES if you to continue?", "Warning",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				int patientID = Integer.parseInt(txtNHSnum.getText());
				String result = appLayer.deletePatient(patientID);
				lblDisplayInfo.setText(result);
			}
		});
		getContentPane().add(btnDelete);

		btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(e -> {
			int patientID = Integer.parseInt(txtNHSnum.getText());
			Patient pt = appLayer.findPatient(patientID);
			if (pt.getId() == 0 && pt.getName() == null) {
				lblDisplayInfo.setText("Patient not found");
				txtName.setText("");
				txtAddress.setText("");
				txtMedCondition.setText("");
			} else {
				txtName.setText(pt.getName());
				txtAddress.setText(pt.getAddress());
				txtMedCondition.setText(pt.getDiagnosis());
				lblDisplayInfo.setText("Patient found");
			}

		});
		btnSearch.setBounds(462, 56, 114, 43);
		getContentPane().add(btnSearch);

		lblDisplayInfo = new JLabel("");
		lblDisplayInfo.setBounds(17, 134, 435, 17);
		getContentPane().add(lblDisplayInfo);

		lblMetaInfo = new JLabel("Medical Records");
		lblMetaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetaInfo.setBounds(10, 161, 566, 13);
		getContentPane().add(lblMetaInfo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 566, 154);
		getContentPane().add(scrollPane);

		txtAreaInfo = new JTextArea();
		scrollPane.setViewportView(txtAreaInfo);

		btnShowRecords = new JButton("SHOW RECORDS");
		btnShowRecords.setBounds(17, 348, 140, 21);
		btnShowRecords.addActionListener(e -> {
			int patientID = Integer.parseInt(txtNHSnum.getText());
			String result = appLayer.getRecords(patientID);
			if (result.equals("")) {
				txtAreaInfo.setText("No Records Found");
			} else {
				txtAreaInfo.setText(result);
			}
		});
		getContentPane().add(btnShowRecords);

		btnUpdateRecords = new JButton("UPDATE RECORDS");
		btnUpdateRecords.setBounds(424, 348, 152, 21);
		btnUpdateRecords.addActionListener(e -> {
			new HospitalGUI(this.appLayer);
		});
		getContentPane().add(btnUpdateRecords);

		txtCoordX = new JTextField();
		txtCoordX.setBounds(97, 383, 96, 19);
		getContentPane().add(txtCoordX);
		txtCoordX.setColumns(10);

		txtCoordY = new JTextField();
		txtCoordY.setBounds(199, 383, 96, 19);
		getContentPane().add(txtCoordY);
		txtCoordY.setColumns(10);

		btnSendDetails = new JButton("HOSPITAL");
		btnSendDetails.setBounds(374, 383, 99, 19);
		btnSendDetails.addActionListener(e -> {
			double x = Double.parseDouble(txtCoordX.getText());
			double y = Double.parseDouble(txtCoordY.getText());
			Hospital hospital = appLayer.getClosestHospital(x, y);
			int patientId = Integer.parseInt(txtNHSnum.getText());
			String result = appLayer.getRecords(patientId);
			JOptionPane.showMessageDialog(this,
					"Sending details to " + hospital.toString() + "\r\nPatient records\r\n" + result);
		});
		getContentPane().add(btnSendDetails);

		JLabel lblNewLabel_4 = new JLabel("Coordinates");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(9, 386, 94, 13);
		getContentPane().add(lblNewLabel_4);
		
		btnMobile = new JButton("MOBILE");
		btnMobile.setBounds(477, 383, 99, 19);
		btnMobile.addActionListener(e->{
			double x = Double.parseDouble(txtCoordX.getText());
			double y = Double.parseDouble(txtCoordY.getText());
			Hospital hospital = appLayer.getClosestHospital(x, y);
			String diagnosis = txtMedCondition.getText();
			String result = appLayer.getSimilarDiagnosis(diagnosis);
			JOptionPane.showMessageDialog(this,
					"Sending details to " + hospital.toString() + "\r\nSimilar diagnosis\r\n" + result);
		});
		getContentPane().add(btnMobile);
		
		JLabel lblNewLabel_5 = new JLabel("Send to");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(306, 386, 58, 13);
		getContentPane().add(lblNewLabel_5);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kwik Medical");
		setVisible(true);
	}
}
