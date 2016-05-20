package pages;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import dao.ClientTableManipulation;
import dao.LoadEducationLevel;
import dao.LoadEmploymentStatus;
import dao.LoadEthinicity;
import dao.LoadGender;
import dao.LoadLivingArrangement;
import dao.LoadMaritalStatus;
import daoBean.ClientBean;
import daoBean.EducationLevelBean;
import daoBean.EmploymentStatusBean;
import daoBean.EthinicityBean;
import daoBean.GenderBean;
import daoBean.LivingArrangementBean;
import daoBean.MaritaStatusBean;
import uiUtil.ComboBoxWithCategory;

public class ClientPage extends JPanel {
	
	private int clinetId;
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
	private JTextField textField_5;
	
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	private JComboBox<String> comboBox_4;
	private JComboBox<String> comboBox_5;
	private JSpinner spinner;
	private JDateChooser dateChooser ;
	private JTextArea textArea;
	
	private boolean istoUpdate = false;

	/**
	 * Create the panel.
	 */
	public ClientPage(int id) {
		this.clinetId = id;
		setBounds(0, 11, 963, 609);

		JLabel lblClientsLastName = new JLabel("Last Name");

		JLabel lblFirstName = new JLabel("First Name ");

		JLabel lblClientId = new JLabel("Client ID #");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		lblFirstName.setLabelFor(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_2.setColumns(10);

		JLabel lblGender = new JLabel("Gender");

		JLabel lblMaritalStatus = new JLabel("Marital Status");

		JLabel lblDateOfBirth = new JLabel("Date of Birth");

		JLabel lblOccupation = new JLabel("Occupation");

		LoadGender gender = new LoadGender();
		comboBox = new JComboBox<String>(new ComboBoxWithCategory());
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		comboBox.addItem("Select");
		//comboBox.addItem("--haushd");
		for (GenderBean item : gender.getAllGenders()) {
			comboBox.addItem(item.getItems());
		}

		comboBox_1 = new JComboBox<String>();
		comboBox_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		comboBox_1.addItem("Select");
		LoadMaritalStatus load = new LoadMaritalStatus();
		for (MaritaStatusBean item : load.getAllMaritalStatus()) {
			comboBox_1.addItem(item.getItems());
		}

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_4.setColumns(10);

		JLabel lblClientsStreetAddress = new JLabel("Street ");

		JLabel lblCity = new JLabel("City");

		JLabel lblState = new JLabel("State");

		JLabel lblPostalCode = new JLabel("Postal Code");

		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		lblState.setLabelFor(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_10.setColumns(10);

		comboBox_2 = new JComboBox<String>();
		comboBox_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		comboBox_2.addItem("Select");
		LoadEthinicity loadethin = new LoadEthinicity();
		for (EthinicityBean item : loadethin.getAllEthinicity()) {
			comboBox_2.addItem(item.getItems());
		}

		JLabel lblClientReferredBy = new JLabel("Referred By");

		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_11.setColumns(10);

		JLabel lblAdditionalNotes = new JLabel("Additional Notes");

		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});

		dateChooser = new JDateChooser(new Date(), "MM/dd/YYYY");
		dateChooser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});

		comboBox_3 = new JComboBox<String>();
		comboBox_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		comboBox_3.addItem("Select");
		LoadEducationLevel loadEducation = new LoadEducationLevel();
		for (EducationLevelBean item : loadEducation.getAllEducationLevels()) {
			comboBox_3.addItem(item.getItems());
		}

		comboBox_4 = new JComboBox<String>();
		comboBox_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		comboBox_4.addItem("Select");
		LoadEmploymentStatus loadEmployment = new LoadEmploymentStatus();
		for (EmploymentStatusBean item : loadEmployment.getAllEmploymentStatus()) {
			comboBox_4.addItem(item.getItems());
		}

		comboBox_5 = new JComboBox<String>();
		comboBox_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		comboBox_5.addItem("Select");
		LoadLivingArrangement loadLiving = new LoadLivingArrangement();
		for (LivingArrangementBean item : loadLiving.getAllLivingArrangement()) {
			comboBox_5.addItem(item.getItems());
		}

		JLabel lblHighestLevelOf = new JLabel("Highest Level Of Education");

		JLabel lblEmploymentStatus = new JLabel("Employment Status");

		JLabel lblLivingArrangement = new JLabel("Living Arrangement");

		JLabel lblNoOfChildren = new JLabel("No Of Children Under Care");
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Middle Name");
		
		JLabel lblEthinicity = new JLabel("Ethinicity");
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		
		spinner = new JSpinner();
		spinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				setIstoUpdate(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClientsLastName, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
							.addGap(164)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
							.addGap(65)
							.addComponent(lblFirstName, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
							.addGap(36)
							.addComponent(lblClientId, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
							.addGap(258))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addGap(22)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClientsStreetAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(192)
							.addComponent(lblCity, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addGap(158)
							.addComponent(lblState, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(146)
							.addComponent(lblPostalCode, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGap(132)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(127))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addGap(22)
							.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
							.addGap(22)
							.addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
							.addGap(22)
							.addComponent(textField_10, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGender, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addGap(98)
							.addComponent(lblDateOfBirth, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
							.addGap(27)
							.addComponent(lblMaritalStatus, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
							.addGap(41)
							.addComponent(lblNoOfChildren, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
							.addGap(19)
							.addComponent(lblOccupation, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
							.addGap(127)
							.addComponent(lblEthinicity, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addGap(159))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, 0, 125, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(comboBox_1, 0, 118, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(comboBox_2, 0, 196, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHighestLevelOf, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(187)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEmploymentStatus, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
									.addGap(81))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(283)
									.addComponent(lblLivingArrangement, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
							.addGap(223))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox_3, 0, 297, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(comboBox_4, 0, 276, Short.MAX_VALUE)
							.addGap(25)
							.addComponent(comboBox_5, 0, 322, Short.MAX_VALUE)
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblClientReferredBy, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
							.addGap(542))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_11, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
							.addGap(502))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAdditionalNotes, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
							.addGap(371))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
							.addGap(6)))
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClientsLastName)
						.addComponent(lblNewLabel)
						.addComponent(lblFirstName)
						.addComponent(lblClientId))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClientsStreetAddress)
						.addComponent(lblCity)
						.addComponent(lblState)
						.addComponent(lblPostalCode)
						.addComponent(lblNewLabel_1))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGender)
						.addComponent(lblDateOfBirth)
						.addComponent(lblMaritalStatus)
						.addComponent(lblNoOfChildren)
						.addComponent(lblOccupation)
						.addComponent(lblEthinicity))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHighestLevelOf)
						.addComponent(lblEmploymentStatus)
						.addComponent(lblLivingArrangement))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblClientReferredBy)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdditionalNotes)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
					.addGap(11))
		);
		setLayout(groupLayout);
		populateData(id);
	}
	
	public void populateData(int id){
		
		if(id != 0){
			ClientTableManipulation manip = new ClientTableManipulation();
			ClientBean cb = manip.getClientInfo(""+id);
			textField.setText(cb.getLastname());
			textField_5.setText(cb.getMiddleName());
			textField_1.setText(cb.getFirstname());
			textField_2.setText(cb.getClientId());
			textField_6.setText(cb.getStreet());
			textField_7.setText(cb.getCity());
			textField_8.setText(cb.getStateName());
			textField_9.setText(cb.getPhone());
			textField_10.setText(cb.getZipcode());
			comboBox.setSelectedItem(cb.getGender());
			textArea.setText(cb.getAdditional());
			dateChooser.setDate(convertFromSQLDateToJAVADate(cb.getDob()));
			comboBox_4.setSelectedItem(cb.getEmploymentStatus());
			comboBox_2.setSelectedItem(cb.getEthnicity());
			comboBox_3.setSelectedItem(cb.getHighestLevelOfEducation());
			comboBox_5.setSelectedItem(cb.getLivingArrangement());
			comboBox_1.setSelectedItem(cb.getMaritalStatus());
			textField_11.setText(cb.getReferredBy());
			textField_4.setText(cb.getOccupatiion());
			spinner.setValue(cb.getNoOfChildrenInCare());
		}else{
			dateChooser.setDate(new Date());
			textField.setText("");
			textField_5.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_6.setText("");
			textField_7.setText("");
			textField_8.setText("");
			textField_9.setText("");
			textField_10.setText("");
			comboBox.setSelectedItem("");
			textArea.setText("");
			textField_11.setText("");
			textField_4.setText("");
			spinner.setValue(0);
		}
		
	}
	
	public ClientBean getClientInformation(){
		ClientBean cb = new ClientBean();
		cb.setLastname(textField.getText());
		cb.setMiddleName(textField_5.getText());
		cb.setFirstname(textField_1.getText());
		cb.setClientId(textField_2.getText());
		cb.setStreet(textField_6.getText());
		cb.setCity(textField_7.getText());
		cb.setStateName(textField_8.getText());
		cb.setPhone(textField_9.getText());
		cb.setZipcode(textField_10.getText());
		cb.setGender(comboBox.getSelectedItem().toString());
		cb.setAdditional(textArea.getText());
		cb.setDob((SQLDateTime(new Date(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText()))));
		cb.setEmploymentStatus(comboBox_4.getSelectedItem().toString());
		cb.setEthnicity(comboBox_2.getSelectedItem().toString());
		cb.setHighestLevelOfEducation(comboBox_3.getSelectedItem().toString());
		cb.setId(this.clinetId);
		cb.setLivingArrangement(comboBox_5.getSelectedItem().toString());
		cb.setMaritalStatus(comboBox_1.getSelectedItem().toString());
		cb.setReferredBy(textField_11.getText());
		cb.setOccupatiion(textField_4.getText());
		cb.setNoOfChildrenInCare((int)spinner.getValue());
		return cb;
	}
	static java.sql.Date SQLDateTime(Date utilDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= dateFormat.format(utilDate);
		java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
	    return sqlDate;
	}
	
	public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return sqlDate;
    }
	
	/**
	 * @return the clinetId
	 */
	public int getClinetId() {
		return clinetId;
	}

	/**
	 * @param clinetId the clinetId to set
	 */
	public void setClinetId(int clinetId) {
		this.clinetId = clinetId;
	}

	/**
	 * @return the istoUpdate
	 */
	public boolean isIstoUpdate() {
		return istoUpdate;
	}

	/**
	 * @param istoUpdate the istoUpdate to set
	 */
	public void setIstoUpdate(boolean istoUpdate) {
		this.istoUpdate = istoUpdate;
	}
}
