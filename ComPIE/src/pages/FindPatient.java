package pages;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ClientTableManipulation;
import daoBean.SearchBean;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	private JButton btnNewButton_3;

	public FindPatient(Home page) {
		
		this.pages = page;
		setBounds(page.getBounds());

		textField = new JTextField();
		textField.setColumns(10);

		JLabel label = new JLabel("Last Name");

		JLabel label_1 = new JLabel("Middle Name");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("First Name ");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel label_3 = new JLabel("Client ID #");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		JLabel label_4 = new JLabel("Postal Code");

		JLabel label_5 = new JLabel("Phone");

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(tablePopulate(true));
				table.removeColumn(table.getColumnModel().getColumn(0));
				repaint();
			}
		});

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

		JButton btnNewButton_1 = new JButton("Create Followup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pages.stage = 1;
				pages.createFollowUp = true;
				pages.pages_1 = new ClientInfo(getSelectedId(),pages.getBounds());
				pages.clientId = getSelectedId();
				pages.layeredPane.add(pages.pages_1);
				pages.findCase.setVisible(false);
				pages.setVisible(true);
				pages.layeredPane.btnSave.setVisible(true);
				pages.layeredPane.btnGoHome.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = null;
		try {
			btnNewButton_3 = new JButton("Home", new ImageIcon(new File("images/home.png").toURI().toURL()));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pages.panel.setVisible(true);
					pages.layeredPane.btnSave.setVisible(false);
					pages.layeredPane.btnGoHome.setVisible(false);
					pages.findCase.setVisible(false);
				}
			});
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnNewButton_3.setAlignmentX(SwingConstants.WEST);
		btnNewButton_3.setIconTextGap(30);
		btnNewButton_3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 10));
		
		JButton btnNewButton_4 = new JButton("Close Case");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pages.stage = 2;
				pages.createFollowUp = true;
				pages.pages_1 = new ClientInfo(getSelectedId(),pages.getBounds());
				pages.clientId = getSelectedId();
				pages.layeredPane.add(pages.pages_1);
				pages.findCase.setVisible(false);
				pages.setVisible(true);
				pages.layeredPane.btnSave.setVisible(true);
				pages.layeredPane.btnGoHome.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(796)
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
					.addGap(141)
					.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
					.addGap(154)
					.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addGap(64))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addGap(46)))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addGap(71))
						.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addGap(107)))
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(616)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(45))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(614)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
					.addGap(36)
					.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(34))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(44))
		);
		setLayout(groupLayout);
	}

	private void addTableListener() {
		setSelectedId(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
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
