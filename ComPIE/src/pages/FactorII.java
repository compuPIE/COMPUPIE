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

	private Component label_4;

	private javax.swing.JLabel label_3;

	private javax.swing.JLabel label_2;

	private javax.swing.JLabel label;

	private javax.swing.JLabel lblFactorISocial;

	private Component label_6;

	private javax.swing.JLabel label_7;

	private Component label_8;

	private Component label_9;

	private boolean hasToUpdate;

	private JLabel lblNewLabel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FactorII(int clientID) {
		setClientId(clientID);
		setBounds(0, 11, 963, 609);
		setLayout(null);

		lblFactorISocial = new JLabel("FACTOR II: Environmental Situations");
		lblFactorISocial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactorISocial.setBounds(325, 11, 440, 35);
		add(lblFactorISocial);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(179, 296, 757, 302);
		add(desktopPane);

		label = new JLabel("");
		label.setBounds(23, 11, 261, 14);
		desktopPane.add(label);

		label_2 = new JLabel("Severity");
		label_2.setBounds(310, 11, 226, 14);
		desktopPane.add(label_2);

		comboBox = new JComboBox<String>();

		comboBox.setBounds(24, 26, 261, 20);
		comboBox.addItem("Select");

		desktopPane.add(comboBox);

		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(310, 26, 254, 20);
		comboBox_2.addItem("Select");

		desktopPane.add(comboBox_2);

		label_3 = new JLabel("Duration");
		label_3.setBounds(23, 67, 237, 14);
		desktopPane.add(label_3);

		label_4 = new JLabel("Coping Ability");
		label_4.setBounds(310, 67, 237, 14);
		desktopPane.add(label_4);

		comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(24, 82, 261, 20);

		desktopPane.add(comboBox_3);

		comboBox_4 = new JComboBox<String>();
		comboBox_4.setBounds(312, 82, 252, 20);

		desktopPane.add(comboBox_4);

		textArea = new JTextArea();
		textArea.setBounds(23, 126, 724, 53);
		desktopPane.add(textArea);

		textArea_1 = new JTextArea();
		textArea_1.setBounds(23, 205, 326, 79);
		desktopPane.add(textArea_1);

		textArea_2 = new JTextArea();
		textArea_2.setBounds(412, 205, 335, 79);
		desktopPane.add(textArea_2);

		label_6 = new JLabel("Goal");
		label_6.setBounds(23, 113, 129, 14);
		desktopPane.add(label_6);

		label_7 = new JLabel("Recommended Intervention");
		label_7.setBounds(23, 190, 285, 14);
		desktopPane.add(label_7);

		label_8 = new JLabel("Expected Outcome");
		label_8.setBounds(412, 190, 285, 14);
		desktopPane.setVisible(false);
		desktopPane.add(label_8);

		label_9 = new JLabel("Priority");
		label_9.setBounds(588, 67, 200, 14);
		desktopPane.add(label_9);

		comboBox_6 = new JComboBox<String>();
		comboBox_6.setBounds(588, 82, 160, 20);
		comboBox_6.addItem("Select");
		desktopPane.add(comboBox_6);
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(396, 45, 219, 14);
		add(lblNewLabel);

		btnAddNewProblem = new JButton("Add new Problem");
		btnAddNewProblem.setBounds(586, 262, 115, 23);
		add(btnAddNewProblem);

		btnDeleteProblem = new JButton("Delete Problem");
		btnDeleteProblem.setBounds(828, 262, 108, 23);
		add(btnDeleteProblem);

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
		scrollPane.setBounds(179, 69, 774, 186);
		add(scrollPane);

		btnEditProblem = new JButton("Edit Problem");
		btnEditProblem.setBounds(711, 262, 107, 23);
		add(btnEditProblem);
		changeMenuWhenClicked("Food/Nutrition");
		populateValues();
		tree = setMenu();
		menuChange();
		tree.setRootVisible(false);
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		// tree.setSelectionPath(tree.get);
		tree.setBounds(10, 65, 159, 422);
		add(tree);

		

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
			lblNewLabel.setText("Economic/Basic Needs Problems");
			repaint();
			break;
		case "Shelter":
			lblNewLabel.setText("Economic/Basic Needs Problems");
			break;
		case "Employment":
			lblNewLabel.setText("Economic/Basic Needs Problems");
			break;
		case "Economic Resources":
			lblNewLabel.setText("Economic/Basic Needs Problems");
			break;
		case "Transportation":
			lblNewLabel.setText("Economic/Basic Needs Problems");
			break;
		case "Health Problems":
			lblNewLabel.setText("Health and Safety Problems");
			break;
		case "Safety Problems":
			lblNewLabel.setText("Health and Safety Problems");
			break;
		case "Social Service Problems":
			lblNewLabel.setText("Health and Safety Problems");
			break;
		case "Religious Group Problems":
			lblNewLabel.setText("Religious and community Group Problems");
			break;
		case "Community Group Problems":
			lblNewLabel.setText("Religious and community Group Problems");
			break;
		case "Education and Training":
			lblNewLabel.setText("Education/Training Problems");
			break;
		case "Judicial and Legal":
			lblNewLabel.setText("Criminal Justice Problems");
			break;
		case "Affectional Support":
			lblNewLabel.setText("Affectional Support Problems");
			break;

		}
		if (menu.equalsIgnoreCase("Food/Nutrition")) {
			table.setModel(tablePopulate(getClientId(), "FoodNutrition"));
		} else {
			table.setModel(tablePopulate(getClientId(), menu));
		}
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

		JTree tr = new JTree(root);

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
		desktopPane.setVisible(true);
		enableDisableValues(false);
		Factor2TableManipulation fac1Dao = new Factor2TableManipulation();
		List<Factor2Bean> list = fac1Dao
				.getFactorInfo(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()), clientID);
		comboBox.setSelectedItem(list.get(0).getProblemCategory());
		comboBox_2.setSelectedItem(list.get(0).getServerity());
		comboBox_3.setSelectedItem(list.get(0).getDuration());
		comboBox_4.setSelectedItem(list.get(0).getCopingAbitity());
		comboBox_6.setSelectedItem(list.get(0).getPriority());
		textArea.setText(list.get(0).getGoal());
		textArea_1.setText(list.get(0).getRecommendedInter());
		textArea_2.setText(list.get(0).getExpectedOutcome());
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
		String[] columns = new String[] { "Id", "Assessed Date", "Problem Category", "Problem", "Severity", "Duration",
				"Coping Ability", "Priority" };

		Factor2TableManipulation fac1Dao = new Factor2TableManipulation();
		List<Factor2Bean> list = fac1Dao.getFactorInfo(clientID, problem);

		// actual data for the table in a 2d array
		Object[][] data = new Object[list.size()][8];
		int i = 0;
		for (Factor2Bean bean : list) {
			data[i][0] = bean.getId();
			data[i][1] = bean.getId();
			data[i][2] = bean.getProblemCategory();
			data[i][3] = bean.getProblemType();
			data[i][4] = bean.getServerity();
			data[i][5] = bean.getDuration();
			data[i][6] = bean.getCopingAbitity();
			data[i][7] = bean.getPriority();
			i++;
		}

		final Class[] columnClass = new Class[] { Integer.class, Date.class, String.class, String.class, String.class,
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

	public Factor2Bean getCurrentValues() {
		Factor2Bean bean = new Factor2Bean();
		bean.setproblemCategory(comboBox.getSelectedItem().toString());
		bean.setServerity(comboBox_2.getSelectedItem().toString());
		bean.setDuration(comboBox_3.getSelectedItem().toString());
		bean.setCopingAbitity(comboBox_4.getSelectedItem().toString());
		bean.setPriority(comboBox_6.getSelectedItem().toString());
		bean.setGoal(textArea.getText());
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
}
