package pages;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import dao.LoadEducationLevel;
import dao.LoadEmploymentStatus;
import dao.LoadEthinicity;
import dao.LoadGender;
import dao.LoadLivingArrangement;
import dao.LoadMaritalStatus;
import daoBean.EducationLevelBean;
import daoBean.EmploymentStatusBean;
import daoBean.EthinicityBean;
import daoBean.GenderBean;
import daoBean.LivingArrangementBean;
import daoBean.MaritaStatusBean;

public class ClientPage extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_13;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public ClientPage() {
		setBounds(0, 11, 963, 609);
		setLayout(null);

		JLabel lblClientsLastName = new JLabel("Last Name");
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
		lblGender.setBounds(21, 98, 86, 14);
		add(lblGender);

		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setBounds(173, 98, 129, 14);
		add(lblMaritalStatus);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(329, 98, 114, 14);
		add(lblDateOfBirth);

		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(477, 98, 106, 14);
		add(lblOccupation);

		LoadGender gender = new LoadGender();
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 112, 129, 20);
		comboBox.addItem("Select");
		for (GenderBean item : gender.getAllGenders()) {
			comboBox.addItem(item.getItems());
		}
		add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(173, 112, 129, 20);
		comboBox_1.addItem("Select");
		LoadMaritalStatus load = new LoadMaritalStatus();
		for (MaritaStatusBean item : load.getAllMaritalStatus()) {
			comboBox_1.addItem(item.getItems());
		}
		add(comboBox_1);

		textField_4 = new JTextField();
		textField_4.setBounds(477, 112, 208, 20);
		add(textField_4);
		textField_4.setColumns(10);

		JLabel lblClientsStreetAddress = new JLabel("Street ");
		lblClientsStreetAddress.setBounds(21, 171, 191, 14);
		add(lblClientsStreetAddress);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(222, 171, 46, 14);
		add(lblCity);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(329, 171, 46, 14);
		add(lblState);

		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setBounds(439, 171, 129, 14);
		add(lblPostalCode);

		JLabel lblClientsPhone = new JLabel("Phone");
		lblClientsPhone.setBounds(588, 171, 129, 14);
		add(lblClientsPhone);

		JLabel lblEthnicity = new JLabel("Ethnicity");
		lblEthnicity.setBounds(740, 171, 176, 14);
		add(lblEthnicity);

		textField_6 = new JTextField();
		textField_6.setBounds(21, 186, 191, 20);
		add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(222, 185, 100, 20);
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
		comboBox_2.addItem("Select");
		LoadEthinicity loadethin = new LoadEthinicity();
		for (EthinicityBean item : loadethin.getAllEthinicity()) {
			comboBox_2.addItem(item.getItems());
		}
		add(comboBox_2);

		JLabel lblClientReferredBy = new JLabel("Referred By");
		lblClientReferredBy.setBounds(21, 316, 223, 14);
		add(lblClientReferredBy);

		JLabel lblAssessedBy = new JLabel("Assessed By");
		lblAssessedBy.setBounds(361, 316, 172, 14);
		add(lblAssessedBy);

		textField_11 = new JTextField();
		textField_11.setBounds(21, 329, 263, 20);
		add(textField_11);
		textField_11.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(361, 329, 273, 20);
		add(textField_13);
		textField_13.setColumns(10);

		JLabel lblAdditionalNotes = new JLabel("Additional Notes");
		lblAdditionalNotes.setBounds(21, 381, 223, 14);
		add(lblAdditionalNotes);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 393, 909, 205);
		add(textArea);

		JDateChooser dateChooser = new JDateChooser(new Date(), "MM/dd/YYYY");
		dateChooser.setBounds(329, 112, 129, 20);
		add(dateChooser);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(21, 249, 263, 26);
		comboBox_3.addItem("Select");
		LoadEducationLevel loadEducation = new LoadEducationLevel();
		for (EducationLevelBean item : loadEducation.getAllEducationLevels()) {
			comboBox_3.addItem(item.getItems());
		}
		add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(305, 249, 263, 26);
		comboBox_4.addItem("Select");
		LoadEmploymentStatus loadEmployment = new LoadEmploymentStatus();
		for (EmploymentStatusBean item : loadEmployment.getAllEmploymentStatus()) {
			comboBox_4.addItem(item.getItems());
		}
		add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(588, 249, 263, 26);
		comboBox_5.addItem("Select");
		LoadLivingArrangement loadLiving = new LoadLivingArrangement();
		for (LivingArrangementBean item : loadLiving.getAllLivingArrangement()) {
			comboBox_5.addItem(item.getItems());
		}
		add(comboBox_5);

		JLabel lblHighestLevelOf = new JLabel("Highest Level Of Education");
		lblHighestLevelOf.setBounds(21, 235, 263, 14);
		add(lblHighestLevelOf);

		JLabel lblEmploymentStatus = new JLabel("Employment Status");
		lblEmploymentStatus.setBounds(305, 235, 263, 14);
		add(lblEmploymentStatus);

		JLabel lblLivingArrangement = new JLabel("Living Arrangement");
		lblLivingArrangement.setBounds(588, 235, 263, 14);
		add(lblLivingArrangement);

		textField_3 = new JTextField();
		textField_3.setBounds(711, 112, 140, 20);
		add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNoOfChildren = new JLabel("No Of Children Under Care");
		lblNoOfChildren.setBounds(711, 98, 216, 14);
		add(lblNoOfChildren);
	}
}
