package presentation;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import application.AppLayerInterface;

import javax.swing.BorderFactory;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KwikMedicalGUI extends JFrame {
	private AppLayerInterface appLayer;
	private JPanel panel;
	private JTextField txtNHSnum;
	private JTextField txtName;
	private JTextField txtMedCondition;
	private JTextField txtAddress;
	private JTextArea txtAreaInfo;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnSearch;
	private JButton btnDelete;
	private JLabel lblDisplayInfo;
	private JLabel lblMetaInfo;

	public KwikMedicalGUI(AppLayerInterface appLayer) {
		this.appLayer = appLayer;
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));

		panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 10, 60));
		panel.setLayout(new GridLayout(3, 2));
		setSize(600, 400);
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
			txtAreaInfo.setText(result);
			lblDisplayInfo.setText(result);
		});
		btnAdd.setBounds(462, 6, 114, 21);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(462, 29, 114, 21);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(462, 134, 114, 21);
		getContentPane().add(btnDelete);

		btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(462, 56, 114, 43);
		getContentPane().add(btnSearch);

		txtAreaInfo = new JTextArea();
		txtAreaInfo.setBounds(10, 184, 566, 169);
		getContentPane().add(txtAreaInfo);

		lblDisplayInfo = new JLabel("");
		lblDisplayInfo.setBounds(17, 134, 435, 17);
		getContentPane().add(lblDisplayInfo);
		
		lblMetaInfo = new JLabel("Medical History");
		lblMetaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMetaInfo.setBounds(10, 161, 566, 13);
		getContentPane().add(lblMetaInfo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kwik Medical");
		setVisible(true);
	}
}
