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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
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
	
	private int currentId;

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

		lblFactorISocial = new JLabel("Factor I: Social Role and Relationship Functioning", SwingConstants.CENTER);
		lblFactorISocial.setFont(new Font("Tahoma", Font.PLAIN, 20));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);

		label = new JLabel("Social Role Description");

		label_1 = new JLabel("Problem Type");

		label_2 = new JLabel("Severity");

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

		label_3 = new JLabel("Duration");

		label_4 = new JLabel("Coping Ability");

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

		textArea = new JTextArea();

		textArea_1 = new JTextArea();

		textArea_2 = new JTextArea();

		label_6 = new JLabel("Goal");

		label_7 = new JLabel("Recommended Intervention");

		label_8 = new JLabel("Expected Outcome");
		desktopPane.setVisible(false);

		label_9 = new JLabel("Priority");

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
			}
		});

		btnDeleteProblem = new JButton("Delete Problem");

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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(586)
					.addComponent(btnAddNewProblem, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnEditProblem, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnDeleteProblem, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(248)
							.addComponent(lblFactorISocial, GroupLayout.PREFERRED_SIZE, 219, Short.MAX_VALUE)
							.addGap(241))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
							.addGap(27))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblFactorISocial, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddNewProblem)
						.addComponent(btnEditProblem)
						.addComponent(btnDeleteProblem))
					.addGap(11)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
					.addGap(11))
		);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(24)
					.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(100))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(24)
					.addComponent(comboBox, 0, 261, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(comboBox_1, 0, 252, Short.MAX_VALUE)
					.addGap(24)
					.addComponent(comboBox_2, 0, 304, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(label_9, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(126))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(24)
					.addComponent(comboBox_3, 0, 261, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(comboBox_4, 0, 252, Short.MAX_VALUE)
					.addGap(24)
					.addComponent(comboBox_6, 0, 160, Short.MAX_VALUE)
					.addGap(166))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addGap(732)))
					.addGap(30))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
					.addGap(176)
					.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
					.addGap(145))
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(23)
					.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addGap(61)
					.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addGap(30))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2))
					.addGap(1)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_9))
					.addGap(1)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
							.addGap(13)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
						.addComponent(label_6))
					.addGap(11)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7)
						.addComponent(label_8))
					.addGap(1)
					.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
						.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
					.addGap(18))
		);
		desktopPane.setLayout(gl_desktopPane);
		setLayout(groupLayout);
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
		setCurrentId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
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
		enableDisableValues(false);
		setCurrentId(0);
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
		if (list.size() == 0) {
			data = new Object[1][7];
			data[i][0] = "No Problems.";
			data[i][2] = "";
			data[i][3] = "";
			data[i][4] = "";
			data[i][5] = "";
			data[i][6] = "";
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
	 * @param hasToUpdate the hasToUpdate to set
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
	 * @param currentId the currentId to set
	 */
	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}
}
