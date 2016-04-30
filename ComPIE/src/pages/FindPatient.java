package pages;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ClientTableManipulation;
import daoBean.SearchBean;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FindPatient extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	JScrollPane scrollPane;

	private int selectedId;
	
	Home pages;

	public FindPatient(Home page) {
		this.pages = page;
		setBounds(0, 11, 963, 609);
		setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(21, 77, 266, 20);
		add(textField);

		JLabel label = new JLabel("Last Name");
		label.setBounds(21, 57, 180, 14);
		add(label);

		JLabel label_1 = new JLabel("Middle Name");
		label_1.setBounds(342, 57, 167, 14);
		add(label_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(342, 77, 266, 20);
		add(textField_1);

		JLabel label_2 = new JLabel("First Name ");
		label_2.setBounds(663, 57, 236, 14);
		add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(663, 77, 250, 20);
		add(textField_2);

		JLabel label_3 = new JLabel("Client ID #");
		label_3.setBounds(603, 152, 203, 14);
		add(label_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(596, 165, 317, 20);
		add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(21, 165, 226, 20);
		add(textField_4);

		JLabel label_4 = new JLabel("Postal Code");
		label_4.setBounds(21, 152, 180, 14);
		add(label_4);

		JLabel label_5 = new JLabel("Phone");
		label_5.setBounds(311, 152, 180, 14);
		add(label_5);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(306, 165, 256, 20);
		add(textField_5);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(tablePopulate(true));
				table.removeColumn(table.getColumnModel().getColumn(0));
				repaint();
			}
		});
		btnNewButton.setBounds(616, 216, 146, 23);
		add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(tablePopulate(false));
				table.removeColumn(table.getColumnModel().getColumn(0));
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				repaint();
			}
		});
		btnClear.setBounds(772, 216, 146, 23);
		add(btnClear);

		DefaultTableModel model = tablePopulate(false);
		table = new JTable(model) {
			public String getToolTipText(MouseEvent e) {
				String tip = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				try {
					tip = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {
					// catch null pointer exception if mouse is over an empty
					// line
				}

				return tip;
			}
		};
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addTableListener();
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				addTableListener();
			}
		});
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(26, 287, 912, 279);
		add(scrollPane);

		JButton btnNewButton_1 = new JButton("Create Followup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pages.pages_1 = new ClientInfo(getSelectedId());
				pages.pages_1.setBounds(0, 24, 982, 658);
				pages.layeredPane.add(pages.pages_1);
				pages.findCase.setVisible(false);
				pages.setVisible(true);
				pages.btnSave.setVisible(true);
				pages.btnGoHome.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(787, 577, 151, 23);
		add(btnNewButton_1);
	}

	private void addTableListener() {
		setSelectedId(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
		System.out.println(getSelectedId());
	}

	public DefaultTableModel tablePopulate(boolean searched) {
		String[] columns = new String[] { "Id", "ClientId", "First Name", "Middle Name", "Last Name", "Street", "City",
				"State", "Postal Code", "Phone", "Gender" };
		Object[][] data = null;
		if (searched) {
			ClientTableManipulation fac1Dao = new ClientTableManipulation();
			List<SearchBean> list = fac1Dao.searchClient(getcurrentValues());

			// actual data for the table in a 2d array
			data = new Object[list.size()][11];
			int i = 0;
			for (SearchBean bean : list) {
				data[i][0] = bean.getId();
				data[i][1] = bean.getClientId();
				data[i][2] = bean.getFirstName();
				data[i][3] = bean.getMiddleName();
				data[i][4] = bean.getLastName();
				data[i][5] = bean.getStreet();
				data[i][6] = bean.getCity();
				data[i][7] = bean.getState();
				data[i][8] = bean.getZipCode();
				data[i][9] = bean.getPhone();
				data[i][10] = bean.getGender();
				i++;
			}
			if (list.size() == 0) {
				data = new Object[1][11];
				data[i][0] = "";
				data[i][1] = "No Records.";
				data[i][2] = "";
				data[i][3] = "";
				data[i][4] = "";
				data[i][5] = "";
				data[i][6] = "";
				data[i][7] = "";
				data[i][8] = "";
				data[i][9] = "";
				data[i][10] = "";
			}
		} 
		final Class[] columnClass = new Class[] { Integer.class, String.class, String.class, String.class, String.class,
				String.class, String.class, String.class, String.class, String.class, String.class };

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

	private SearchBean getcurrentValues() {
		SearchBean bean = new SearchBean();
		bean.setFirstName(textField_2.getText());
		bean.setMiddleName(textField_1.getText());
		bean.setLastName(textField.getText());
		bean.setPhone(textField_5.getText());
		bean.setClientId(textField_3.getText());
		bean.setZipCode(textField_4.getText());
		return bean;
	}

	/**
	 * @return the selectedId
	 */
	public int getSelectedId() {
		return selectedId;
	}

	/**
	 * @param selectedId
	 *            the selectedId to set
	 */
	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

}
