package pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import dao.Factor2TableManipulation;
import dao.Load_Coping_Ability;
import dao.Load_Duration;
import dao.Load_Factor2MetaInfo;
import dao.Load_Priority;
import dao.Load_Severity;
import daoBean.Coping_Ability;
import daoBean.Duration;
import daoBean.Factor2Bean;
import daoBean.Factor2Category;
import daoBean.Priority;
import daoBean.Severity;
import daoBean.SocialRoleCategory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;

public class FactorII extends JPanel {

	private int clientId;

	private JButton btnDeleteProblem;

	private JButton btnAddNewProblem;

	private JTable table;

	private JComboBox<String> comboBox;

	private JComboBox<String> comboBox_2;

	private JComboBox<String> comboBox_3;

	private JComboBox<String> comboBox_4;

	private JTextArea textArea;

	private JTextArea textArea_1;

	private JTextArea textArea_2;

	private JComboBox<String> comboBox_6;

	private JScrollPane scrollPane;

	private JButton btnEditProblem;

	private JDesktopPane desktopPane;

	private Component lblCopingAbility;

	private javax.swing.JLabel lblDuration;

	private javax.swing.JLabel lblSeverity;

	private javax.swing.JLabel label;

	private javax.swing.JLabel lblFactorISocial;

	private Component label_6;

	private javax.swing.JLabel label_7;

	private Component label_8;

	private Component lblPriority;

	private boolean hasToUpdate;

	private JLabel lblNewLabel;

	private int currentProbId = 0;

	private String currentMenu = "";
	
	private boolean hasRecords =false;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;
	private JTree tr;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FactorII(int clientID) {
		setClientId(clientID);
		setBounds(0, 11, 963, 609);

		lblFactorISocial = new JLabel("FACTOR II: Environmental Situations");
		lblFactorISocial.setFont(new Font("Tahoma", Font.PLAIN, 20));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);

		label = new JLabel("");

		lblSeverity = new JLabel("Severity(*)");

		comboBox = new JComboBox<String>();
		comboBox.addItem("Select");

		comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("Select");

		lblDuration = new JLabel("Duration(*)");

		lblCopingAbility = new JLabel("Coping Ability(*)");

		comboBox_3 = new JComboBox<String>();

		comboBox_4 = new JComboBox<String>();

		textArea = new JTextArea();

		textArea_1 = new JTextArea();

		textArea_2 = new JTextArea();

		label_6 = new JLabel("Goal");

		label_7 = new JLabel("Recommended Intervention");

		label_8 = new JLabel("Expected Outcome");
		desktopPane.setVisible(false);

		lblPriority = new JLabel("Priority(*)");

		comboBox_6 = new JComboBox<String>();
		comboBox_6.addItem("Select");
		lblNewLabel = new JLabel("");

		btnAddNewProblem = new JButton("Add new Problem");

		btnDeleteProblem = new JButton("Delete Problem");

		DefaultTableModel model = tablePopulate(clientID, "Food/Nutrition");
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
		changeMenuWhenClicked("Food/Nutrition");
		populateValues();
		tree = setMenu();
		menuChange();
		tree.setRootVisible(false);
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		
		lblNewLabel_1 = new JLabel("Fields marked (*) are mandatory");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(396)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
					.addGap(348))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tr, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(222)
							.addComponent(btnAddNewProblem, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnEditProblem, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnDeleteProblem, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
						.addComponent(desktopPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(373)
					.addComponent(lblFactorISocial, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addGap(263))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFactorISocial, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tr, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
							.addGap(111))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAddNewProblem)
										.addComponent(btnEditProblem)
										.addComponent(btnDeleteProblem))
									.addGap(11))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(11))
		);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane
				.setHorizontalGroup(
						gl_desktopPane
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_desktopPane.createSequentialGroup().addGap(23)
										.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
										.addGap(104)
										.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
										.addGap(60))
								.addGroup(gl_desktopPane.createSequentialGroup()
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_desktopPane.createSequentialGroup().addGap(24)
														.addComponent(comboBox_3, 0, 254, Short.MAX_VALUE).addGap(39))
												.addGroup(gl_desktopPane.createSequentialGroup().addGap(33)
														.addComponent(lblDuration, GroupLayout.DEFAULT_SIZE, 278,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_desktopPane.createSequentialGroup()
														.addComponent(comboBox_4, 0, 216, Short.MAX_VALUE).addGap(18))
												.addGroup(gl_desktopPane.createSequentialGroup()
														.addComponent(lblCopingAbility, GroupLayout.PREFERRED_SIZE, 0,
																Short.MAX_VALUE)
														.addGap(161)))
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_desktopPane.createSequentialGroup()
														.addComponent(comboBox_6, 0, 137, Short.MAX_VALUE).addGap(50))
												.addGroup(gl_desktopPane.createSequentialGroup()
														.addComponent(lblPriority, GroupLayout.DEFAULT_SIZE, 62,
																Short.MAX_VALUE)
														.addContainerGap())))
								.addGroup(gl_desktopPane.createSequentialGroup()
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_desktopPane.createSequentialGroup().addGap(24)
														.addComponent(comboBox, 0, 261, Short.MAX_VALUE).addGap(25))
												.addGroup(gl_desktopPane.createSequentialGroup().addGap(23)
														.addComponent(label, GroupLayout.DEFAULT_SIZE, 246,
																Short.MAX_VALUE)
														.addGap(41)))
										.addGap(10)
										.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBox_2, 0, 254, Short.MAX_VALUE)
												.addGroup(gl_desktopPane.createSequentialGroup()
														.addComponent(lblSeverity, GroupLayout.DEFAULT_SIZE, 55,
																Short.MAX_VALUE)
														.addGap(199)))
										.addGap(164))
								.addGroup(
										gl_desktopPane.createSequentialGroup().addGap(23)
												.addGroup(gl_desktopPane
														.createParallelGroup(Alignment.TRAILING)
														.addGroup(
																gl_desktopPane
																		.createSequentialGroup().addGroup(gl_desktopPane
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(
																						textArea,
																						GroupLayout.DEFAULT_SIZE, 680,
																						Short.MAX_VALUE)
																				.addGroup(gl_desktopPane
																						.createSequentialGroup()
																						.addComponent(textArea_1,
																								GroupLayout.DEFAULT_SIZE,
																								307, Short.MAX_VALUE)
																						.addGap(63)
																						.addComponent(textArea_2,
																								GroupLayout.DEFAULT_SIZE,
																								310, Short.MAX_VALUE)))
																		.addGap(35))
														.addGroup(gl_desktopPane
																.createSequentialGroup().addComponent(label_6,
																		GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
																.addGap(605)))));
		gl_desktopPane.setVerticalGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup().addGap(11)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(lblSeverity))
						.addGap(1)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCopingAbility)
								.addComponent(lblDuration).addComponent(lblPriority))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(11).addComponent(label_6).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING).addComponent(label_7)
								.addComponent(label_8))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
								.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
						.addGap(13)));
		desktopPane.setLayout(gl_desktopPane);
		setLayout(groupLayout);

	}

	/**
	 * 
	 */
	private void populateValues() {

		Load_Severity severity = new Load_Severity();
		for (Severity sev : severity.getAllSeverity()) {
			comboBox_2.addItem(sev.getCategory());
		}

		Load_Duration duration = new Load_Duration();
		comboBox_3.addItem("Select");
		for (Duration sev : duration.getAllDuration()) {
			comboBox_3.addItem(sev.getCategory());
		}

		Load_Coping_Ability coping = new Load_Coping_Ability();
		comboBox_4.addItem("Select");
		for (Coping_Ability sev : coping.getAllCoping_Ability()) {
			comboBox_4.addItem(sev.getCategory());
		}

		Load_Priority priority = new Load_Priority();
		for (Priority sev : priority.getAllPriority()) {
			comboBox_6.addItem(sev.getCategory());
		}

		btnAddNewProblem.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				setHasToUpdate(true);
				desktopPane.setVisible(true);
				resetValues();
				setCurrentProbId(0);
			}
		});
	}

	/**
	 * @param menu
	 */
	private void populateProblem(String menu) {
		Load_Factor2MetaInfo roles = new Load_Factor2MetaInfo();
		List<Factor2Category> categ = roles.getAllProblemsByCategory(menu);
		comboBox.removeAllItems();
		comboBox.addItem("Select");
		for (Factor2Category category : categ) {
			comboBox.addItem(category.getCategory());
		}
	}

	private void changeMenuWhenClicked(String menu) {
		switch (menu) {
		case "Food/Nutrition":
			lblNewLabel.setText("Economic/Basic Needs Problems(*)");
			repaint();
			break;
		case "Shelter":
			lblNewLabel.setText("Economic/Basic Needs Problems(*)");
			break;
		case "Employment":
			lblNewLabel.setText("Economic/Basic Needs Problems(*)");
			break;
		case "Economic Resources":
			lblNewLabel.setText("Economic/Basic Needs Problems(*)");
			break;
		case "Transportation":
			lblNewLabel.setText("Economic/Basic Needs Problems(*)");
			break;
		case "Health Problems":
			lblNewLabel.setText("Health and Safety Problems(*)");
			break;
		case "Safety Problems":
			lblNewLabel.setText("Health and Safety Problems(*)");
			break;
		case "Social Service Problems":
			lblNewLabel.setText("Health and Safety Problems(*)");
			break;
		case "Religious Group Problems":
			lblNewLabel.setText("Religious and community Group Problems(*)");
			break;
		case "Community Group Problems":
			lblNewLabel.setText("Religious and community Group Problems(*)");
			break;
		case "Education and Training":
			lblNewLabel.setText("Education/Training Problems(*)");
			break;
		case "Judicial and Legal":
			lblNewLabel.setText("Criminal Justice Problems(*)");
			break;
		case "Affectional Support":
			lblNewLabel.setText("Affectional Support Problems(*)");
			break;

		}
		setCurrentMenu(menu);
		desktopPane.setVisible(false);

		table.setModel(tablePopulate(getClientId(), menu));

		label.setText(menu + " Problem");
		populateProblem(menu);
		repaint();
	}

	/**
	 * 
	 */
	private void menuChange() {
		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (tree.getSelectionPath().toString().split(",").length > 2) {
					changeMenuWhenClicked(tree.getSelectionPath().toString()
							.split(",")[(tree.getSelectionPath().toString().split(",").length - 1)].replace("]", "")
									.trim());
				} else {
					changeMenuWhenClicked(tree.getSelectionPath().toString().split(",")[1].replace("]", "").trim());
				}
			}
		});
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tree.getSelectionPath().toString().split(",").length > 2) {
					changeMenuWhenClicked(tree.getSelectionPath().toString()
							.split(",")[(tree.getSelectionPath().toString().split(",").length - 1)].replace("]", "")
									.trim());
				} else {
					changeMenuWhenClicked(tree.getSelectionPath().toString().split(",")[1].replace("]", "").trim());
				}
			}
		});
	}

	private JTree setMenu() {

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode basicNeeds = new DefaultMutableTreeNode("Basic Needs");
		DefaultMutableTreeNode eduAndTraing = new DefaultMutableTreeNode("Education and Training");
		DefaultMutableTreeNode judAndLegal = new DefaultMutableTreeNode("Judicial and Legal");
		DefaultMutableTreeNode hsSs = new DefaultMutableTreeNode("Health,Safety and Social Services");
		DefaultMutableTreeNode voluntaryAsso = new DefaultMutableTreeNode("Voluntary Associations");
		DefaultMutableTreeNode affectionalSupport = new DefaultMutableTreeNode("Affectional Support");

		DefaultMutableTreeNode foodNutrition = new DefaultMutableTreeNode("Food/Nutrition");
		basicNeeds.add(foodNutrition);

		basicNeeds.add(new DefaultMutableTreeNode("Shelter"));
		basicNeeds.add(new DefaultMutableTreeNode("Employment"));
		basicNeeds.add(new DefaultMutableTreeNode("Economic Resources"));
		basicNeeds.add(new DefaultMutableTreeNode("Transportation"));

		hsSs.add(new DefaultMutableTreeNode("Health Problems"));
		hsSs.add(new DefaultMutableTreeNode("Safety Problems"));
		hsSs.add(new DefaultMutableTreeNode("Social Service Problems"));

		voluntaryAsso.add(new DefaultMutableTreeNode("Religious Group Problems"));
		voluntaryAsso.add(new DefaultMutableTreeNode("Community Group Problems"));

		root.add(basicNeeds);
		root.add(eduAndTraing);
		root.add(judAndLegal);
		root.add(hsSs);
		root.add(voluntaryAsso);
		root.add(affectionalSupport);

		tr = new JTree(root);

		// tr.setSelectionPath(new TreePath(foodNutrition));
		DefaultMutableTreeNode[] defaultPath = { root, basicNeeds, foodNutrition };
		tr.setSelectionPath(new TreePath(defaultPath));
		return tr;

	}

	private void resetValues() {
		enableDisableValues(true);
		comboBox.setSelectedItem("Select");
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
		if(isHasRecords()){
		desktopPane.setVisible(true);
		enableDisableValues(false);
		Factor2TableManipulation fac1Dao = new Factor2TableManipulation();
		List<Factor2Bean> list = fac1Dao
				.getFactorInfo(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()), clientID);
		setCurrentProbId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
		comboBox.setSelectedItem(list.get(0).getProblemType());
		comboBox_2.setSelectedItem(list.get(0).getServerity());
		comboBox_3.setSelectedItem(list.get(0).getDuration());
		comboBox_4.setSelectedItem(list.get(0).getCopingAbitity());
		comboBox_6.setSelectedItem(list.get(0).getPriority());
		textArea.setText(list.get(0).getGoal());
		textArea_1.setText(list.get(0).getRecommendedInter());
		textArea_2.setText(list.get(0).getExpectedOutcome());
		}
	}

	private void enableDisableValues(boolean value) {
		comboBox.setEnabled(value);
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
	public DefaultTableModel tablePopulate(int clientID, String problem) {
		enableDisableValues(false);
		String[] columns = new String[] { "Id", "Assessed Date", "Problem", "Severity", "Duration", "Coping Ability",
				"Priority" };

		Factor2TableManipulation fac1Dao = new Factor2TableManipulation();
		List<Factor2Bean> list = fac1Dao.getFactorInfo(clientID, problem);

		// actual data for the table in a 2d array
		Object[][] data = new Object[list.size()][7];
		int i = 0;
		for (Factor2Bean bean : list) {
			data[i][0] = bean.getId();
			data[i][1] = bean.getId();
			data[i][2] = bean.getProblemType();
			data[i][3] = bean.getServerity();
			data[i][4] = bean.getDuration();
			data[i][5] = bean.getCopingAbitity();
			data[i][6] = bean.getPriority();
			i++;
		}
		if (list.size() == 0) {
			setHasRecords(false);
			data = new Object[1][7];
			data[i][0] = "No Problems.";
			data[i][2] = "";
			data[i][3] = "";
			data[i][4] = "";
			data[i][5] = "";
			data[i][6] = "";
		}else{
			setHasRecords(true);
		}
		final Class[] columnClass = new Class[] { Integer.class, Date.class, String.class, String.class, String.class,
				String.class, String.class };

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

	public Factor2Bean getCurrentValues() {
		Factor2Bean bean = new Factor2Bean();
		bean.setproblemCategory(getCurrentMenu());
		bean.setProblemType(comboBox.getSelectedItem().toString());
		bean.setServerity(comboBox_2.getSelectedItem().toString());
		bean.setDuration(comboBox_3.getSelectedItem().toString());
		bean.setCopingAbitity(comboBox_4.getSelectedItem().toString());
		bean.setPriority(comboBox_6.getSelectedItem().toString());
		bean.setGoal(textArea.getText());
		bean.setId(getCurrentProbId());
		bean.setRecommendedInter(textArea_1.getText());
		bean.setExpectedOutcome(textArea_2.getText());
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
	 * @return the clientId
	 */
	public int getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the currentProbId
	 */
	public int getCurrentProbId() {
		return currentProbId;
	}

	/**
	 * @param currentProbId
	 *            the currentProbId to set
	 */
	public void setCurrentProbId(int currentProbId) {
		this.currentProbId = currentProbId;
	}

	/**
	 * @return the currentMenu
	 */
	public String getCurrentMenu() {
		return currentMenu;
	}

	/**
	 * @param currentMenu
	 *            the currentMenu to set
	 */
	public void setCurrentMenu(String currentMenu) {
		this.currentMenu = currentMenu;
	}

	/**
	 * @return the hasRecords
	 */
	public boolean isHasRecords() {
		return hasRecords;
	}

	/**
	 * @param hasRecords the hasRecords to set
	 */
	public void setHasRecords(boolean hasRecords) {
		this.hasRecords = hasRecords;
	}
}
