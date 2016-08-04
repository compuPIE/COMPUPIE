package pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.Factor3TableManipulation;
import dao.FollowUpTableManipulation;
import dao.Load_Coping_Ability;
import dao.Load_DSM_AXIS_5;
import dao.Load_Duration;
import dao.Load_Priority;
import dao.Load_Severity;
import daoBean.Coping_Ability;
import daoBean.DSM_AXIS_5;
import daoBean.Duration;
import daoBean.Factor3Bean;
import daoBean.Factor3Bean;
import daoBean.Priority;
import daoBean.Severity;
import pages.helper.AutoCompletion;
import javax.swing.JCheckBox;

public class FactorIII extends JPanel {

	private JButton btnAddNewProblem;

	private JTable table;

	private JComboBox comboBox;

	private JComboBox comboBox_1;

	private JComboBox comboBox_2;

	private JComboBox comboBox_3;

	private JComboBox comboBox_4;

	private TextArea textArea;

	private TextArea textArea_1;

	private TextArea textArea_2;

	private JComboBox comboBox_6;

	private JScrollPane scrollPane;

	private JButton btnEditProblem;

	private JDesktopPane desktopPane;

	private Component lblCopingAbility;

	private javax.swing.JLabel lblDuration;

	private Component lblDiagnosisSource;

	private javax.swing.JLabel lblDsmAxisDiagnosis;

	private javax.swing.JLabel lblFactorISocial;

	private Component label_6;

	private javax.swing.JLabel label_7;

	private Component label_8;

	private Component lblPriority;

	private boolean hasToUpdate;

	private int currentId;
	
	private JTextField comboBox_5;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int clientId;

	private JCheckBox chckbxNoMentalHealth;

	private JCheckBox chckbxPossibleMhProblem;

	private JCheckBox chckbxClientDeniedMh;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FactorIII(int clientID) {
		setBounds(0, 11, 963, 609);
		comboBox_5 = new JTextField();
		lblFactorISocial = new JLabel("Factor III: Mental Health Functioning", SwingConstants.CENTER);
		lblFactorISocial.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);

		lblDsmAxisDiagnosis = new JLabel("DSM 5 DX");
		lblDsmAxisDiagnosis.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		lblDiagnosisSource = new JLabel("Diagnosis Source");
		lblDiagnosisSource.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		Load_DSM_AXIS_5 roles = new Load_DSM_AXIS_5();
		List<DSM_AXIS_5> categ = roles.getAllDSM_AXIS_5();

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().split("--").length > 1){
					comboBox_5.setText(comboBox.getSelectedItem().toString().split("--")[1]);
				}else{
					System.out.println();
					comboBox_5.setText("");
				}
			}
		});
		comboBox_1 = new JComboBox();

		comboBox.addItem("");
		for (DSM_AXIS_5 category : categ) {
			
			comboBox.addItem(category.getCategory() +""+((!category.getId().equalsIgnoreCase(""))?"   -- "+category.getId():""));
		}

		comboBox_1.addItem("Select");
		comboBox_1.addItem("Professional DX");
		comboBox_1.addItem("Client Report");

		Load_Severity severity = new Load_Severity();

		comboBox_2 = new JComboBox();
		comboBox_2.addItem("Select");
		for (Severity sev : severity.getAllSeverity()) {
			comboBox_2.addItem(sev.getCategory());
		}

		lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		lblCopingAbility = new JLabel("Coping Ability");
		lblCopingAbility.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		Load_Duration duration = new Load_Duration();
		comboBox_3 = new JComboBox();
		comboBox_3.addItem("Select");
		for (Duration sev : duration.getAllDuration()) {
			comboBox_3.addItem(sev.getCategory());
		}

		Load_Coping_Ability coping = new Load_Coping_Ability();
		comboBox_4 = new JComboBox();
		comboBox_4.addItem("Select");
		for (Coping_Ability sev : coping.getAllCoping_Ability()) {
			comboBox_4.addItem(sev.getCategory());
		}

		textArea = new TextArea();

		textArea_1 = new TextArea();

		textArea_2 = new TextArea();

		label_6 = new JLabel("Goal");
		label_6.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		label_7 = new JLabel("Recommended Intervention");
		label_7.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		label_8 = new JLabel("Expected Outcome");
		label_8.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));
		desktopPane.setVisible(false);

		lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));

		Load_Priority priority = new Load_Priority();
		comboBox_6 = new JComboBox();
		comboBox_6.addItem("Select");
		for (Priority sev : priority.getAllPriority()) {
			comboBox_6.addItem(sev.getCategory());
		}

		btnAddNewProblem = new JButton("Add new Problem");
		btnAddNewProblem.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setHasToUpdate(true);
				resetValues();
				desktopPane.setVisible(true);
				enableDisableValues(true);
			}
		});

		DefaultTableModel model = tablePopulate(clientID);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addTableListener(clientID);
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				addTableListener(clientID);
			}
		});
		scrollPane = new JScrollPane(table);

		btnEditProblem = new JButton("Edit Problem");
		btnEditProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enableDisableValues(true);
				setHasToUpdate(true);
			}
		});

		AutoCompletion.enable(comboBox);

		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHasToUpdate(false);
				desktopPane.setVisible(false);
			}
		});

		JLabel lblSeverity = new JLabel("Severity");
		lblSeverity.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));
		
		comboBox_5.setEnabled(false);
		JLabel lblDsmCode = new JLabel("DSM Code");
		lblDsmCode.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));
		
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addGap(176)
					.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addGap(145))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(30))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblDsmAxisDiagnosis, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(261))
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(24)
							.addComponent(comboBox, 0, 415, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_1, 0, 268, Short.MAX_VALUE)
						.addComponent(lblDiagnosisSource, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_5, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(lblDsmCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(79)))
					.addGap(41))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_2, 0, 197, Short.MAX_VALUE)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addComponent(lblSeverity, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(132)))
							.addGap(50)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_3, 0, 186, Short.MAX_VALUE)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addComponent(lblDuration, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
									.addGap(42)))
							.addGap(53)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_4, 0, 178, Short.MAX_VALUE)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addComponent(lblCopingAbility, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
									.addGap(57)))
							.addGap(37)
							.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPane.createSequentialGroup()
									.addComponent(lblPriority, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
									.addGap(52))
								.addComponent(comboBox_6, 0, 173, Short.MAX_VALUE)))
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
							.addGap(732)))
					.addGap(30))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDsmAxisDiagnosis)
						.addComponent(lblDiagnosisSource)
						.addComponent(lblDsmCode))
					.addGap(1)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCopingAbility)
						.addComponent(lblPriority)
						.addComponent(lblDuration)
						.addComponent(lblSeverity))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addComponent(label_6)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7)
						.addComponent(label_8))
					.addGap(1)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(106))
		);
		desktopPane.setLayout(gl_desktopPane);
		
		chckbxNoMentalHealth = new JCheckBox("No Mental Health Problem");
		
		chckbxPossibleMhProblem = new JCheckBox("Possible MH problem, no professional dx");
		
		chckbxClientDeniedMh = new JCheckBox("Client denies MH problem");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(539)
					.addComponent(btnAddNewProblem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnEditProblem, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addGap(69))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(209)
					.addComponent(lblFactorISocial, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addGap(228))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(192)
					.addComponent(chckbxNoMentalHealth, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(chckbxPossibleMhProblem, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(51)
					.addComponent(chckbxClientDeniedMh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(166))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFactorISocial, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxNoMentalHealth)
						.addComponent(chckbxPossibleMhProblem)
						.addComponent(chckbxClientDeniedMh))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddNewProblem)
						.addComponent(btnEditProblem)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addGap(16))
		);
		setLayout(groupLayout);
		table.removeColumn(table.getColumnModel().getColumn(0));
	}

	private void resetValues() {
		enableDisableValues(true);
		comboBox.setSelectedItem("Select");
		comboBox_1.setSelectedItem("");
		comboBox_2.setSelectedItem("Select");
		comboBox_3.setSelectedItem("Select");
		comboBox_4.setSelectedItem("Select");
		comboBox_6.setSelectedItem("Select");
		textArea.setText("");
		textArea_1.setText("");
		textArea_2.setText("");
	}

	/**
	 * @param clientID
	 * @param comboBox
	 * @param comboBox_1
	 * @param comboBox_2
	 * @param comboBox_3
	 * @param comboBox_4
	 * @param textArea
	 * @param textArea_1
	 * @param textArea_2
	 * @param comboBox_6
	 * @param table
	 */
	private void addTableListener(int clientID) {
		setHasToUpdate(false);
		desktopPane.setVisible(true);
		enableDisableValues(false);
		Factor3TableManipulation fac1Dao = new Factor3TableManipulation();
		if (table.getModel().getValueAt(table.getSelectedRow(), 0) != null && !table.getModel()
				.getValueAt(table.getSelectedRow(), 0).toString().equalsIgnoreCase("No Problems.")) {
			List<Factor3Bean> list = fac1Dao.getFactorInfo(
					Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()), clientID);
			if (list.size() != 0) {
				setCurrentId(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
				comboBox.setSelectedItem(list.get(0).getdsmDiagnosis());
				if(list.get(0).getdiagnosisSource().split("--").length>1){
					comboBox_1.setSelectedItem(list.get(0).getdiagnosisSource());	
					comboBox_5.setText(list.get(0).getdiagnosisSource().split("--")[1]);
				}else{
					comboBox_1.setSelectedItem(list.get(0).getdiagnosisSource());	
				}
				comboBox_2.setSelectedItem(list.get(0).getServerity());
				comboBox_3.setSelectedItem(list.get(0).getDuration());
				comboBox_4.setSelectedItem(list.get(0).getCopingAbitity());
				comboBox_6.setSelectedItem(list.get(0).getPriority());
				textArea.setText(list.get(0).getGoal());
				textArea_1.setText(list.get(0).getRecommendedInter());
				textArea_2.setText(list.get(0).getExpectedOutcome());
			}
		}
	}

	private void enableDisableValues(boolean value) {
		comboBox.setEnabled(value);
		comboBox_1.setEnabled(value);
		comboBox_2.setEnabled(value);
		comboBox_3.setEnabled(value);
		comboBox_4.setEnabled(value);
		comboBox_6.setEnabled(value);
		textArea.setEnabled(value);
		textArea_1.setEnabled(value);
		textArea_2.setEnabled(value);
	}

	/**
	 * @param clientID
	 * @return
	 */
	public DefaultTableModel tablePopulate(int clientID) {
		
		enableDisableValues(false);

		setCurrentId(0);
		String[] columns = new String[] { "Id", "Assessed Date", "DSM AXIS Diagnosis", "Diagnosis Source", "Severity",
				"Duration", "Coping Ability", "Priority" };
		FollowUpTableManipulation follow = new FollowUpTableManipulation();
		Factor3TableManipulation fac1Dao = new Factor3TableManipulation();
		List<Factor3Bean> list = fac1Dao.getFactorInfo(clientID);

		// actual data for the table in a 2d array
		Object[][] data = new Object[list.size()][8];
		int i = 0;
		for (Factor3Bean bean : list) {
			if(bean.getMHP().equalsIgnoreCase("true")){
				chckbxNoMentalHealth.setSelected(true);
			}
			
			if(bean.getNoDx().equalsIgnoreCase("true")){
				chckbxPossibleMhProblem.setSelected(true);			
			}
			if(bean.getDenies().equalsIgnoreCase("true")){
				chckbxClientDeniedMh.setSelected(true);
			}
			
			data[i][0] = bean.getId();
			data[i][1] = follow.getFollowUpInfo( bean.getFollowup(),clientID).get(0).getDate();
			data[i][2] = bean.getdsmDiagnosis();
			data[i][3] = bean.getdiagnosisSource();
			data[i][4] = bean.getServerity();
			data[i][5] = bean.getDuration();
			data[i][6] = bean.getCopingAbitity();
			data[i][7] = bean.getPriority();
			i++;
		}
		if (list.size() == 0) {
			data = new Object[1][8];
			data[i][1] = "No Problems.";
			data[i][2] = "";
			data[i][3] = "";
			data[i][4] = "";
			data[i][5] = "";
			data[i][6] = "";
		}

		final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class };

		// create table model with data
		DefaultTableModel model = new DefaultTableModel(data, columns) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return columnClass[columnIndex];
			}
		};
		return model;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table
	 *            the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	public Factor3Bean getCurrentValues() {
		Factor3Bean bean = new Factor3Bean();
		bean.setdsmDiagnosis(comboBox.getSelectedItem().toString());
		bean.setdiagnosisSource(comboBox_1.getSelectedItem().toString());
		bean.setServerity(comboBox_2.getSelectedItem().toString());
		bean.setDuration(comboBox_3.getSelectedItem().toString());
		bean.setCopingAbitity(comboBox_4.getSelectedItem().toString());
		bean.setPriority(comboBox_6.getSelectedItem().toString());
		bean.setGoal(textArea.getText());
		bean.setRecommendedInter(textArea_1.getText());
		bean.setExpectedOutcome(textArea_2.getText());
		bean.setMHP(chckbxNoMentalHealth.isSelected()+"");
		bean.setNoDx(chckbxPossibleMhProblem.isSelected()+"");
		bean.setDenies(chckbxClientDeniedMh.isSelected()+"");
		bean.setId(currentId);
		return bean;
	}

	/**
	 * @return the hasToUpdate
	 */
	public boolean isHasToUpdate() {
		return hasToUpdate;
	}

	/**
	 * @param hasToUpdate
	 *            the hasToUpdate to set
	 */
	public void setHasToUpdate(boolean hasToUpdate) {
		this.hasToUpdate = hasToUpdate;
	}

	/**
	 * @return the currentId
	 */
	public int getCurrentId() {
		return currentId;
	}

	/**
	 * @param currentId
	 *            the currentId to set
	 */
	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}
}
