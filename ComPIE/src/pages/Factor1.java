package pages;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

import dao.Factor1TableManipulation;
import dao.Load_Coping_Ability;
import dao.Load_Duration;
import dao.Load_Priority;
import dao.Load_Severity;
import dao.Load_SocialRoles;
import daoBean.Coping_Ability;
import daoBean.Duration;
import daoBean.Factor1Bean;
import daoBean.Priority;
import daoBean.Severity;
import daoBean.SocialRoleCategory;
import daoBean.SocialRoleProblems;

public class Factor1 extends JPanel {

	private JButton btnDeleteProblem;

	private JButton btnAddNewProblem;

	private JTable table;

	private JComboBox comboBox;

	private JComboBox comboBox_1;

	private JComboBox comboBox_2;

	private JComboBox comboBox_3;

	private JComboBox comboBox_4;

	private JTextArea textArea;

	private JTextArea textArea_1;

	private JTextArea textArea_2;

	private JComboBox comboBox_6;

	private JScrollPane scrollPane;

	private JButton btnEditProblem;

	private JDesktopPane desktopPane;

	private Component label_4;

	private javax.swing.JLabel label_3;

	private javax.swing.JLabel label_2;

	private Component label_1;

	private javax.swing.JLabel label;

	private javax.swing.JLabel lblFactorISocial;

	private Component label_6;

	private javax.swing.JLabel label_7;

	private Component label_8;

	private Component label_9;
	
	private boolean hasToUpdate;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Factor1(int clientID) {
		setBounds(0, 11, 963, 609);
		setLayout(null);

		lblFactorISocial = new JLabel("Factor I: Social Role and Relationship Functioning");
		lblFactorISocial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactorISocial.setBounds(239, 24, 440, 35);
		add(lblFactorISocial);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(22, 296, 914, 302);
		add(desktopPane);

		label = new JLabel("Social Role Description");
		label.setBounds(23, 11, 261, 14);
		desktopPane.add(label);

		label_1 = new JLabel("Problem Type");
		label_1.setBounds(310, 11, 254, 14);
		desktopPane.add(label_1);

		label_2 = new JLabel("Severity");
		label_2.setBounds(588, 11, 226, 14);
		desktopPane.add(label_2);

		Load_SocialRoles roles = new Load_SocialRoles();
		List<SocialRoleCategory> categ = roles.getAllProblemsByCategory();

		comboBox = new JComboBox();
		comboBox_1 = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.removeAllItems();
				for (SocialRoleCategory category : categ) {
					if (category.getCategory().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
						for (SocialRoleProblems problem : category.getItems()) {
							comboBox_1.addItem(problem.getItem());
						}
					}
				}
			}
		});
		comboBox.setBounds(24, 26, 261, 20);
		comboBox.addItem("Select");
		for (SocialRoleCategory category : categ) {
			comboBox.addItem(category.getCategory());
		}
		desktopPane.add(comboBox);

		comboBox_1.setBounds(312, 26, 252, 20);
		desktopPane.add(comboBox_1);

		Load_Severity severity = new Load_Severity();

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(588, 26, 304, 20);
		comboBox_2.addItem("Select");
		for (Severity sev : severity.getAllSeverity()) {
			comboBox_2.addItem(sev.getCategory());
		}
		desktopPane.add(comboBox_2);

		label_3 = new JLabel("Duration");
		label_3.setBounds(23, 67, 237, 14);
		desktopPane.add(label_3);

		label_4 = new JLabel("Coping Ability");
		label_4.setBounds(310, 67, 237, 14);
		desktopPane.add(label_4);

		Load_Duration duration = new Load_Duration();
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(24, 82, 261, 20);
		comboBox_3.addItem("Select");
		for (Duration sev : duration.getAllDuration()) {
			comboBox_3.addItem(sev.getCategory());
		}
		desktopPane.add(comboBox_3);

		Load_Coping_Ability coping = new Load_Coping_Ability();
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(312, 82, 252, 20);
		comboBox_4.addItem("Select");
		for (Coping_Ability sev : coping.getAllCoping_Ability()) {
			comboBox_4.addItem(sev.getCategory());
		}
		desktopPane.add(comboBox_4);

		textArea = new JTextArea();
		textArea.setBounds(23, 126, 861, 53);
		desktopPane.add(textArea);

		textArea_1 = new JTextArea();
		textArea_1.setBounds(23, 205, 400, 79);
		desktopPane.add(textArea_1);

		textArea_2 = new JTextArea();
		textArea_2.setBounds(484, 205, 400, 79);
		desktopPane.add(textArea_2);

		label_6 = new JLabel("Goal");
		label_6.setBounds(23, 113, 129, 14);
		desktopPane.add(label_6);

		label_7 = new JLabel("Recommended Intervention");
		label_7.setBounds(23, 190, 285, 14);
		desktopPane.add(label_7);

		label_8 = new JLabel("Expected Outcome");
		label_8.setBounds(484, 190, 285, 14);
		desktopPane.setVisible(false);
		desktopPane.add(label_8);

		label_9 = new JLabel("Priority");
		label_9.setBounds(588, 67, 200, 14);
		desktopPane.add(label_9);

		Load_Priority priority = new Load_Priority();
		comboBox_6 = new JComboBox();
		comboBox_6.setBounds(588, 82, 160, 20);
		comboBox_6.addItem("Select");
		for (Priority sev : priority.getAllPriority()) {
			comboBox_6.addItem(sev.getCategory());
		}
		desktopPane.add(comboBox_6);

		btnAddNewProblem = new JButton("Add new Problem");
		btnAddNewProblem.setBounds(586, 262, 115, 23);
		btnAddNewProblem.addActionListener(new java.awt.event.ActionListener() { 
			
			public void actionPerformed(ActionEvent arg0) {
				setHasToUpdate(true);
				resetValues();
			}
		});
		add(btnAddNewProblem);

		btnDeleteProblem = new JButton("Delete Problem");
		btnDeleteProblem.setBounds(828, 262, 108, 23);
		add(btnDeleteProblem);

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
		scrollPane.setBounds(24, 65, 912, 186);
		add(scrollPane);

		btnEditProblem = new JButton("Edit Problem");
		btnEditProblem.setBounds(711, 262, 107, 23);
		add(btnEditProblem);
	}
	
	private void resetValues(){
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
		Factor1TableManipulation fac1Dao = new Factor1TableManipulation();
		List<Factor1Bean> list = fac1Dao
				.getFactorInfo(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()), clientID);
		comboBox.setSelectedItem(list.get(0).getSocialRoleDescription());
		comboBox_1.setSelectedItem(list.get(0).getProblemType());
		comboBox_2.setSelectedItem(list.get(0).getServerity());
		comboBox_3.setSelectedItem(list.get(0).getDuration());
		comboBox_4.setSelectedItem(list.get(0).getCopingAbitity());
		comboBox_6.setSelectedItem(list.get(0).getPriority());
		textArea.setText(list.get(0).getGoal());
		textArea_1.setText(list.get(0).getRecommendedInter());
		textArea_2.setText(list.get(0).getExpectedOutcome());
	}
	
	private void enableDisableValues(boolean value){
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
		String[] columns = new String[] { "Id", "Assessed Date", "Social Role Category", "Problem", "Severity",
				"Duration", "Coping Ability", "Priority" };

		Factor1TableManipulation fac1Dao = new Factor1TableManipulation();
		List<Factor1Bean> list = fac1Dao.getFactorInfo(clientID);

		// actual data for the table in a 2d array
		Object[][] data = new Object[list.size()][8];
		int i = 0;
		for (Factor1Bean bean : list) {
			data[i][0] = bean.getId();
			data[i][1] = bean.getId();
			data[i][2] = bean.getSocialRoleDescription();
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
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	public Factor1Bean getCurrentValues() {
		Factor1Bean bean = new Factor1Bean();
		bean.setSocialRoleDescription(comboBox.getSelectedItem().toString());
		bean.setProblemType(comboBox_1.getSelectedItem().toString());
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
	 * @param hasToUpdate the hasToUpdate to set
	 */
	public void setHasToUpdate(boolean hasToUpdate) {
		this.hasToUpdate = hasToUpdate;
	}
}
