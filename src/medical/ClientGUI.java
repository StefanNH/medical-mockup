package medical;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.Font;

public class ClientGUI extends JFrame {
	private JTextField txtNHSnum;
	private JTextField txtName;
	private JTextField txtMedCondition;
	private JTextField txtAddress;

	public ClientGUI() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));

		JPanel panel = new JPanel();
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
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(462, 6, 114, 21);
		getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(462, 29, 114, 21);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(462, 52, 114, 21);
		getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBounds(462, 109, 114, 43);
		getContentPane().add(btnSearch);
		
		JTextArea txtAreaInfo = new JTextArea();
		txtAreaInfo.setBounds(10, 162, 566, 191);
		getContentPane().add(txtAreaInfo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Kwik Medical");
		setVisible(true);
	}
	public static void main(String[] args) {
		new ClientGUI();
	}
}
