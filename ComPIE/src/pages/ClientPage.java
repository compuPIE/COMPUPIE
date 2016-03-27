package pages;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ClientPage extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Create the panel.
	 */
	public ClientPage() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		
		JLabel lblClientsLastName = new JLabel("Client's Last Name");
		lblClientsLastName.setBounds(21, 23, 223, 14);
		add(lblClientsLastName);
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(351, 23, 217, 14);
		add(lblFirstName);
		
		JLabel lblClientId = new JLabel("Client ID #");
		lblClientId.setBounds(680, 23, 208, 14);
		add(lblClientId);
		
		textField = new JTextField();
		textField.setBounds(21, 48, 247, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(351, 48, 283, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(680, 48, 247, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(21, 87, 86, 14);
		add(lblGender);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setBounds(173, 87, 129, 14);
		add(lblMaritalStatus);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(329, 87, 114, 14);
		add(lblDateOfBirth);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(477, 87, 106, 14);
		add(lblOccupation);
		
		JLabel lblAliasName = new JLabel("Alias Name");
		lblAliasName.setBounds(698, 87, 159, 14);
		add(lblAliasName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 112, 129, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(173, 112, 129, 20);
		add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(477, 112, 208, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(698, 112, 229, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblClientsStreetAddress = new JLabel("Client's Street Address");
		lblClientsStreetAddress.setBounds(21, 160, 191, 14);
		add(lblClientsStreetAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(222, 160, 46, 14);
		add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(329, 160, 46, 14);
		add(lblState);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setBounds(439, 160, 129, 14);
		add(lblPostalCode);
		
		JLabel lblClientsPhone = new JLabel("Client's Phone");
		lblClientsPhone.setBounds(588, 160, 129, 14);
		add(lblClientsPhone);
		
		JLabel lblEthnicity = new JLabel("Ethnicity");
		lblEthnicity.setBounds(740, 160, 176, 14);
		add(lblEthnicity);
		
		textField_6 = new JTextField();
		textField_6.setBounds(21, 186, 191, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(216, 185, 106, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		lblState.setLabelFor(textField_8);
		textField_8.setBounds(329, 185, 102, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(439, 185, 129, 20);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(588, 185, 129, 20);
		add(textField_10);
		textField_10.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(740, 185, 187, 20);
		add(comboBox_2);
		
		JLabel lblClientReferredBy = new JLabel("Client Referred By");
		lblClientReferredBy.setBounds(21, 236, 223, 14);
		add(lblClientReferredBy);
		
		JLabel lblAssessmentDate = new JLabel("Assessment Date");
		lblAssessmentDate.setBounds(413, 236, 122, 14);
		add(lblAssessmentDate);
		
		JLabel lblAssessedBy = new JLabel("Assessed By");
		lblAssessedBy.setBounds(545, 236, 172, 14);
		add(lblAssessedBy);
		
		textField_11 = new JTextField();
		textField_11.setBounds(21, 261, 301, 20);
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(413, 261, 86, 20);
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(545, 261, 382, 20);
		add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblAdditionalNotes = new JLabel("Additional Notes");
		lblAdditionalNotes.setBounds(21, 300, 223, 14);
		add(lblAdditionalNotes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 337, 909, 261);
		add(textArea);
		
		JDateChooser dateChooser = new JDateChooser(new Date(),"mm/dd/YYYY");
		dateChooser.setBounds(329, 112, 129, 20);
		add(dateChooser);
	}
}
