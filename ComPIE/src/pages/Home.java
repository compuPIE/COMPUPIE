package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import dao.CaseHistoryTableManipulation;
import dao.ClientTableManipulation;
import dao.Factor1TableManipulation;
import dao.Factor2TableManipulation;
import dao.Factor3TableManipulation;
import dao.Factor4TableManipulation;
import dao.FollowUpTableManipulation;
import dao.StrengthResourceManipulation;
import daoBean.CaseHistoryBean;
import daoBean.ClientBean;
import daoBean.Factor1Bean;
import daoBean.Factor2Bean;
import daoBean.Factor3Bean;
import daoBean.Factor4Bean;
import daoBean.FollowUpBean;
import daoBean.StrengthAndResourcesBean;
import pages.helper.Validator;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public JPanel pages;
	
	public LogIn login;

	public FindPatient findCase;
	public JPanel panel;

	public int clientId = 0;

	public int followUp = 1;

	public int stage = 0;

	JButton btnSave = new JButton("Save");
	JButton btnGoHome = new JButton("Go Back");
	public JLayeredPane layeredPane;

	public ClientInfo pages_1;

	boolean createFollowUp = false;

	String username;
	JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");

					// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					// UIManager.setLookAndFeel(new InfoNodeLookAndFeel());
					Home frame = new Home();
					frame.setTitle("CompuPIE");
					// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					// frame.setSize(screenSize);
					frame.setVisible(true); // FIRST visible = true
					// frame.setResizable(false); // THEN resizable = false
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		saveListener();

		layeredPane = new JLayeredPane();

		login = new LogIn(getThisObject());
		login.setVisible(true);
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(0, 11, 982, 658);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.PINK);
		JLabel lblCompupie = new JLabel("CompuPIE");
		lblCompupie.setBounds(450, 11, 91, 25);
		lblCompupie.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblPesonInEnvironment = new JLabel("Person In Environment System");
		lblPesonInEnvironment.setBounds(401, 47, 191, 17);
		lblPesonInEnvironment.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTextPane txtpnCompupieInConjunction = new JTextPane();
		txtpnCompupieInConjunction.setBounds(76, 364, 392, 151);
		txtpnCompupieInConjunction.setEditable(false);
		txtpnCompupieInConjunction
				.setText("CompuPIE, in conjunction with the PIE Manual,produces succinct description of"
						+ " client's social functioning problems and strengths. Assessments can be made at the"
						+ " initial contact and at follow-up contacts. Data entered may be modified as needed."
						+ " CompPIE generates printed statements of findings and recommendations for interventions.");

		JButton btnNewButton = new JButton("Open New Case");
		btnNewButton.setBounds(651, 188, 127, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stage = 0;
				createFollowUp = true;
				pages_1 = new ClientInfo(0);
				pages_1.setBounds(0, 24, 982, 658);
				layeredPane.add(pages_1);
				panel.setVisible(false);
				pages_1.setVisible(true);
				btnSave.setVisible(true);
				btnGoHome.setVisible(true);
				repaint();
			}
		});

		JButton btnNewButton_1 = new JButton("Find Existing Case");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findCase = new FindPatient(getThisObject());
				layeredPane.add(findCase);
				panel.setVisible(false);
				findCase.setVisible(true);
				repaint();
			}
		});
		btnNewButton_1.setBounds(651, 238, 127, 23);

		JButton btnNewButton_2 = new JButton("Delete Case");
		btnNewButton_2.setBounds(651, 297, 127, 23);

		JButton btnNewButton_3 = new JButton("Exit CompuPIE");
		btnNewButton_3.setBounds(651, 346, 127, 23);

		JButton btnNewButton_4 = new JButton("Display Instructions");
		btnNewButton_4.setBounds(651, 397, 127, 23);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(693, 135, 38, 20);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JTextPane txtpnCompupieSystemCopyrightc = new JTextPane();
		txtpnCompupieSystemCopyrightc.setBounds(340, 605, 350, 34);
		txtpnCompupieSystemCopyrightc.setEnabled(false);
		txtpnCompupieSystemCopyrightc.setEditable(false);
		txtpnCompupieSystemCopyrightc.setText(
				"CompuPIE System, Copyright(c) 1998-2007, J.M. Karls and M. O'Keefe.\r\nAll rights reserved.                                                            Version 0320");

		JLabel lblLogoGoesHere = new JLabel("Logo Goes here....");
		lblLogoGoesHere.setBounds(57, 174, 367, 124);
		lblLogoGoesHere.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 986, GroupLayout.PREFERRED_SIZE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(layeredPane,
				GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE));
		layeredPane.setLayout(null);

		btnGoHome.setBounds(887, 0, 89, 23);
		layeredPane.add(btnGoHome);
		btnSave.setBounds(781, 0, 89, 23);
		layeredPane.add(btnSave);
		layeredPane.add(panel);
		layeredPane.add(login);
		panel.setLayout(null);
		panel.add(lblCompupie);
		panel.add(lblPesonInEnvironment);
		panel.add(lblMenu);
		panel.add(lblLogoGoesHere);
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton_2);
		panel.add(txtpnCompupieInConjunction);
		panel.add(btnNewButton_3);
		panel.add(btnNewButton_4);
		panel.add(txtpnCompupieSystemCopyrightc);

		JButton btnNewButton_5 = new JButton("Change Theme");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeLF();
				repaint();
				SwingUtilities.updateComponentTreeUI(layeredPane.getParent());
				pack();
			}
		});
		btnNewButton_5.setBounds(651, 447, 127, 23);
		panel.add(btnNewButton_5);
		
		lblNewLabel = new JLabel("Welcome "+username);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		lblNewLabel.setBounds(716, 50, 184, 14);
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				pages_1.setVisible(false);
				btnSave.setVisible(false);
				btnGoHome.setVisible(false);
			}
		});
		btnGoHome.setVisible(false);
		btnSave.setVisible(false);

	}

	private Home getThisObject() {
		return this;
	}

	public void changeLF() {
		Properties prop = new Properties();
		InputStream input = null;
		try {

			String filename = "themes.properties";
			input = Home.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		String changeLook = (String) JOptionPane.showInputDialog(this, "Choose Look and Feel Here:",
				"Select Look and Feel", JOptionPane.QUESTION_MESSAGE, null, prop.keySet().toArray(), null);

		if (changeLook != null) {
			try {
				UIManager.setLookAndFeel(prop.getProperty(changeLook));
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException ex) {
				System.err.println(ex);
				ex.printStackTrace(System.err);
			}
		}
	}

	/**
	 * 
	 */
	private void saveListener() {
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Validator valid = new Validator(getThisObject());
				if (valid.getMsgs().isEmpty()) {
					saveFollowUp();
					saveClientInfo();
					saveCaseHistory();
					saveFactor1();
					saveFactor2();
					saveFactor3();
					saveFactor4();
					saveStrengthAndResources();
					JOptionPane.showMessageDialog(getThisObject(), "Details saved Successfully.");
				} else {
					StringBuffer sb = new StringBuffer();
					for (String msg : valid.getMsgs()) {

						sb.append(msg + "\n");

					}
					JOptionPane.showMessageDialog(getThisObject(),
						    sb.toString(),
						    "Details not Saved",
						    JOptionPane.ERROR_MESSAGE);
				}
			}

			private void saveFollowUp() {
				if (createFollowUp && (pages_1.getPanel().isIstoUpdate() || pages_1.getPanel6().isHasToUpdate()
						|| pages_1.getPanel1().isHasToUpdate() || pages_1.getPanel2().isHasToUpdate()
						|| pages_1.getPanel3().isHasToUpdate() || pages_1.getPanel4().isHasToUpdate()
						|| pages_1.getPanel7().hastoUpdate())) {
					FollowUpTableManipulation follow = new FollowUpTableManipulation();
					ClientTableManipulation cli = new ClientTableManipulation();
					if (clientId == 0) {
						clientId = cli.getmaxId() + 1;
					}
					followUp = follow.getmaxId(clientId) + 1;
					FollowUpBean bean = new FollowUpBean();
					bean.setClientid(clientId);
					bean.setAccessedBy(username);
					bean.setId(followUp);
					bean.setStage(stage);
					follow.saveNewFollowUp(bean);
					createFollowUp = false;
				}
			}

			private void saveClientInfo() {
				if (pages_1.getPanel().isIstoUpdate()) {
					ClientBean cb = pages_1.getPanel().getClientInformation();
					if (cb.getId() == 0) {
						ClientTableManipulation manip = new ClientTableManipulation();
						manip.saveNewClient(cb);
					} else if (cb.getId() != 0) {
						ClientTableManipulation manip = new ClientTableManipulation();
						manip.updateNewClient(cb);
					}
				}
			}

			private void saveCaseHistory() {
				if (pages_1.getPanel6().isHasToUpdate()) {
					CaseHistoryBean bean = pages_1.getPanel6().getCurrentValues();
					CaseHistoryTableManipulation dao = new CaseHistoryTableManipulation();
					if (pages_1.getPanel6().isHasToUpdate() && pages_1.getPanel6().getCaseHistoryId() != -1) {
						dao.updateNewHIstory(bean);
					} else if (pages_1.getPanel6().isHasToUpdate()) {
						dao.saveNewHistory(bean);
					}
				}
			}

			private void saveFactor1() {
				if (pages_1.getPanel1().isHasToUpdate()) {
					Factor1Bean bean = pages_1.getPanel1().getCurrentValues();
					Factor1TableManipulation dao = new Factor1TableManipulation();
					if (bean.getId() == 0) {
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.saveNewFactory(bean);
						pages_1.getPanel1().getTable().setModel(pages_1.getPanel1().tablePopulate(clientId));
						pages_1.getPanel1().getTable()
								.removeColumn(pages_1.getPanel1().getTable().getColumnModel().getColumn(0));
						pages_1.repaint();
					} else if (bean.getId() != 0) {
						bean.setClientId(clientId);
						dao.updateNewFactory(bean);
						pages_1.getPanel1().getTable().setModel(pages_1.getPanel1().tablePopulate(clientId));
						pages_1.getPanel1().getTable()
								.removeColumn(pages_1.getPanel1().getTable().getColumnModel().getColumn(0));
						pages_1.repaint();
					}
				}
				pages_1.getPanel1().setHasToUpdate(false);
			}

			private void saveFactor2() {
				if (pages_1.getPanel2().isHasToUpdate()) {
					Factor2Bean bean = pages_1.getPanel2().getCurrentValues();
					if (bean.getId() == 0) {
						Factor2TableManipulation dao = new Factor2TableManipulation();
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.saveNewFactory(bean);
						pages_1.getPanel2().getTable().setModel(
								pages_1.getPanel2().tablePopulate(clientId, pages_1.getPanel2().getCurrentMenu()));
						pages_1.repaint();
					} else if (bean.getId() != 0) {
						Factor2TableManipulation dao = new Factor2TableManipulation();
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.updateNewFactory(bean);
						pages_1.getPanel2().getTable().setModel(
								pages_1.getPanel2().tablePopulate(clientId, pages_1.getPanel2().getCurrentMenu()));
						pages_1.repaint();
					}
				}
				pages_1.getPanel2().setHasToUpdate(false);
			}

			private void saveFactor3() {
				if (pages_1.getPanel3().isHasToUpdate()) {
					Factor3Bean bean = pages_1.getPanel3().getCurrentValues();
					if (bean.getId() == 0) {
						Factor3TableManipulation dao = new Factor3TableManipulation();
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.saveNewFactory(bean);
						pages_1.getPanel3().getTable().setModel(pages_1.getPanel3().tablePopulate(clientId));
						pages_1.getPanel3().getTable()
								.removeColumn(pages_1.getPanel3().getTable().getColumnModel().getColumn(0));
						pages_1.repaint();
					} else if (bean.getId() != 0) {
						Factor3TableManipulation dao = new Factor3TableManipulation();
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.updateNewFactory(bean);
						pages_1.getPanel3().getTable().setModel(pages_1.getPanel3().tablePopulate(clientId));
						pages_1.getPanel3().getTable()
								.removeColumn(pages_1.getPanel3().getTable().getColumnModel().getColumn(0));
						pages_1.repaint();
					}
				}
				pages_1.getPanel3().setHasToUpdate(false);
			}

			private void saveFactor4() {
				if (pages_1.getPanel4().isHasToUpdate()) {
					Factor4Bean bean = pages_1.getPanel4().getCurrentValues();
					if (bean.getId() == 0) {
						Factor4TableManipulation dao = new Factor4TableManipulation();
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.saveNewFactory(bean);
						pages_1.getPanel4().getTable().setModel(pages_1.getPanel4().tablePopulate(clientId));
						pages_1.getPanel4().getTable()
								.removeColumn(pages_1.getPanel4().getTable().getColumnModel().getColumn(0));
						pages_1.repaint();
					} else if (bean.getId() != 0) {
						Factor4TableManipulation dao = new Factor4TableManipulation();
						bean.setClientId(clientId);
						bean.setFollowup(followUp);
						dao.updateNewFactory(bean);
						pages_1.getPanel4().getTable().setModel(pages_1.getPanel4().tablePopulate(clientId));
						pages_1.getPanel4().getTable()
								.removeColumn(pages_1.getPanel4().getTable().getColumnModel().getColumn(0));
						pages_1.repaint();
					}
				}
				pages_1.getPanel4().setHasToUpdate(false);
			}

			private void saveStrengthAndResources() {
				if (pages_1.getPanel7().hastoUpdate()) {
					StrengthAndResourcesBean bean = pages_1.getPanel7().getCurrentvalues();
					StrengthResourceManipulation dao = new StrengthResourceManipulation();
					if (bean.getId() != 0) {
						dao.updateNewStrength(bean);
					} else if (bean.getId() == 0) {
						dao.saveNewStrength(bean);
					}
				}
			}
		});
	}
}
