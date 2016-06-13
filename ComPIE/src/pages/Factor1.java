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
import java.sql.Date;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.Factor1TableManipulation;
import dao.FollowUpTableManipulation;
import dao.Load_Coping_Ability;
import dao.Load_Duration;
import dao.Load_Priority;
import dao.Load_Severity;
import dao.Load_SocialRoleProblemType;
import dao.Load_SocialRoles;
import daoBean.Coping_Ability;
import daoBean.Duration;
import daoBean.Factor1Bean;
import daoBean.Priority;
import daoBean.Severity;
import daoBean.SocialRoleCategory;
import daoBean.SocialRoleProblemType;
import daoBean.SocialRoleProblems;

public class Factor1 extends JPanel {

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

	private javax.swing.JLabel lblProblem;

	private Component lblProblemType;

	private javax.swing.JLabel lblSocialRoleDescription;

	private javax.swing.JLabel lblFactorISocial;

	private Component label_6;

	private javax.swing.JLabel label_7;

	private Component label_8;

	private Component lblPriority;

	private boolean hasToUpdate;

	private int currentId;

	private JComboBox comboBox_5;

	public int clint;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Factor1(int clientID) {
		clint = clientID;
		setBounds(0, 11, 1016, 609);

		lblFactorISocial = new JLabel("Factor I: Social Role and Relationship Functioning", SwingConstants.CENTER);
		lblFactorISocial.setFont(new Font("Tahoma", Font.PLAIN, 20));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);

		lblSocialRoleDescription = new JLabel("Social Role Description(*)");

		lblProblemType = new JLabel("Problem Type(*)");

		lblProblem = new JLabel("Problem(*)");

		Load_SocialRoles roles = new Load_SocialRoles();
		List<SocialRoleCategory> categ = roles.getAllProblemsByCategory();

		comboBox = new JComboBox();
		comboBox_1 = new JComboBox();
		comboBox_1.addItem("Select");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.removeAllItems();
				comboBox_1.addItem("Select");
				for (SocialRoleCategory category : categ) {
					if (category.getCategory().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
						for (SocialRoleProblems problem : category.getItems()) {
							comboBox_1.addItem(problem.getItem());
						}
					}
				}
			}
		});
		comboBox.addItem("Select");
		for (SocialRoleCategory category : categ) {
			comboBox.addItem(category.getCategory());
		}

		Load_Severity severity = new Load_Severity();

		comboBox_2 = new JComboBox();
		comboBox_2.addItem("Select");
		for (Severity sev : severity.getAllSeverity()) {
			comboBox_2.addItem(sev.getCategory());
		}

		lblDuration = new JLabel("Duration(*)");

		lblCopingAbility = new JLabel("Coping Ability(*)");

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

		Load_SocialRoleProblemType type = new Load_SocialRoleProblemType();
		comboBox_5 = new JComboBox();
		comboBox_5.addItem("Select");
		for (SocialRoleProblemType sev : type.getAllProblemTypes()) {
			comboBox_5.addItem(sev.getProblemType());
		}

		textArea = new TextArea();

		textArea_1 = new TextArea();

		textArea_2 = new TextArea();

		label_6 = new JLabel("Goal");

		label_7 = new JLabel("Recommended Intervention");

		label_8 = new JLabel("Expected Outcome");
		desktopPane.setVisible(false);

		lblPriority = new JLabel("Priority(*)");

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

		JButton btnNewButton = new JButton("Remove Problem");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHasToUpdate(false);
				desktopPane.setVisible(false);
			}
		});

		lblNewLabel = new JLabel("Fields marked (*) are mandatory");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(272)
						.addComponent(lblFactorISocial, GroupLayout.PREFERRED_SIZE, 526, Short.MAX_VALUE).addGap(241))
				.addGroup(groupLayout.createSequentialGroup().addGap(24).addGroup(groupLayout
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(
								groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 332,
												GroupLayout.PREFERRED_SIZE)
										.addGap(282)
										.addComponent(btnAddNewProblem, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnEditProblem, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(27)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(10))
						.addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)).addGap(27)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(24)
				.addComponent(lblFactorISocial, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnAddNewProblem)
								.addComponent(btnEditProblem).addComponent(btnNewButton))
						.addComponent(lblNewLabel))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE).addGap(125)));

		JLabel lblSeverity = new JLabel("Severity(*)");
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_desktopPane.createSequentialGroup()
						.addGap(23).addComponent(label_7, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE).addGap(176)
						.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE).addGap(145))
				.addGroup(
						gl_desktopPane.createSequentialGroup().addGap(23)
								.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(61)
								.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(30))
				.addGroup(gl_desktopPane.createSequentialGroup()
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_desktopPane.createSequentialGroup().addGap(23)
										.addComponent(lblSocialRoleDescription, GroupLayout.DEFAULT_SIZE, 285,
												Short.MAX_VALUE)
										.addGap(26)
										.addComponent(lblProblemType, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
								.addGroup(gl_desktopPane.createSequentialGroup().addGap(24)
										.addComponent(comboBox, 0, 285, Short.MAX_VALUE).addGap(27)
										.addComponent(comboBox_1, 0, 276, Short.MAX_VALUE)))
						.addGap(24).addGroup(
								gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_desktopPane.createSequentialGroup()
												.addComponent(lblProblem, GroupLayout.DEFAULT_SIZE, 274,
														Short.MAX_VALUE)
												.addGap(100))
										.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 296,
												GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_desktopPane.createSequentialGroup().addGap(23).addGroup(gl_desktopPane
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_desktopPane.createSequentialGroup()
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 197,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSeverity))
								.addGap(50)
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 186,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDuration, GroupLayout.PREFERRED_SIZE, 144,
												GroupLayout.PREFERRED_SIZE))
								.addGap(53)
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 178,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCopingAbility, GroupLayout.PREFERRED_SIZE, 121,
												GroupLayout.PREFERRED_SIZE))
								.addGap(37)
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 121,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_6, 0, 256, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, gl_desktopPane.createSequentialGroup()
								.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE).addGap(732)))
						.addGap(30)));
		gl_desktopPane.setVerticalGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addGroup(gl_desktopPane
				.createSequentialGroup().addGap(11)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addComponent(lblSocialRoleDescription)
						.addComponent(lblProblemType).addComponent(lblProblem))
				.addGap(1)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(21)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCopingAbility)
						.addComponent(lblPriority).addComponent(lblDuration).addComponent(lblSeverity))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(11).addComponent(label_6)
				.addGroup(gl_desktopPane.createSequentialGroup()
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED))
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addComponent(label_7)
						.addComponent(label_8))
				.addGap(1)
				.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
				.addGap(106)));
		desktopPane.setLayout(gl_desktopPane);
		setLayout(groupLayout);
		table.removeColumn(table.getColumnModel().getColumn(0));
	}

	private void resetValues() {
		enableDisableValues(true);
		comboBox.setSelectedItem("Select");
		comboBox_1.setSelectedItem("Select");
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
		Factor1TableManipulation fac1Dao = new Factor1TableManipulation();
		if (table.getModel().getValueAt(table.getSelectedRow(), 0) != null && !table.getModel()
				.getValueAt(table.getSelectedRow(), 0).toString().equalsIgnoreCase("No Problems.")) {
			List<Factor1Bean> list = fac1Dao.getFactorInfo(
					Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()), clientID);

			if (list.size() != 0) {
				setCurrentId(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
				comboBox.setSelectedItem(list.get(0).getSocialRoleDescription());
				comboBox_1.setSelectedItem(list.get(0).getProblemType());
				comboBox_2.setSelectedItem(list.get(0).getServerity());
				comboBox_3.setSelectedItem(list.get(0).getDuration());
				comboBox_4.setSelectedItem(list.get(0).getCopingAbitity());
				comboBox_5.setSelectedItem(list.get(0).getSocialRoleProblemType());
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
		comboBox_5.setEnabled(value);
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
		String[] columns = new String[] { "Id", "Assessed Date", "Social Role Category", "Problem Type", "Problem",
				"Severity", "Duration", "Coping Ability", "Priority" };
		FollowUpTableManipulation follow = new FollowUpTableManipulation();
		Factor1TableManipulation fac1Dao = new Factor1TableManipulation();
		List<Factor1Bean> list = fac1Dao.getFactorInfo(clientID);

		// actual data for the table in a 2d array
		Object[][] data = new Object[list.size()][9];
		int i = 0;
		for (Factor1Bean bean : list) {
			data[i][0] = bean.getId();
			data[i][1] = follow.getFollowUpInfo(clientID, bean.getFollowup()).get(0).getDate();
			data[i][2] = bean.getSocialRoleDescription();
			data[i][3] = bean.getProblemType();
			data[i][4] = bean.getSocialRoleProblemType();
			data[i][5] = bean.getServerity();
			data[i][6] = bean.getDuration();
			data[i][7] = bean.getCopingAbitity();
			data[i][8] = bean.getPriority();
			i++;
		}
		if (list.size() == 0) {
			data = new Object[1][9];
			data[i][0] = "No Problems.";
			data[i][2] = "";
			data[i][3] = "";
			data[i][4] = "";
			data[i][5] = "";
			data[i][6] = "";
		}

		final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class, String.class };

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

	public Factor1Bean getCurrentValues() {
		Factor1TableManipulation fac1Dao = new Factor1TableManipulation();
		List<Factor1Bean> list = fac1Dao.getFactorInfo(currentId, clint);
		Factor1Bean bean = new Factor1Bean();
		if (!list.isEmpty()) {
			bean.setFollowup(list.get(0).getFollowup());
		}
		bean.setSocialRoleDescription(comboBox.getSelectedItem().toString());
		bean.setProblemType(comboBox_1.getSelectedItem().toString());
		bean.setServerity(comboBox_2.getSelectedItem().toString());
		bean.setDuration(comboBox_3.getSelectedItem().toString());
		bean.setCopingAbitity(comboBox_4.getSelectedItem().toString());
		bean.setPriority(comboBox_6.getSelectedItem().toString());
		bean.setGoal(textArea.getText());
		bean.setRecommendedInter(textArea_1.getText());
		bean.setExpectedOutcome(textArea_2.getText());
		bean.setSocialRoleProblemType(comboBox_5.getSelectedItem().toString());
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
