package pages;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dao.AdditionalNotesManipulation;
import dao.CaseHistoryTableManipulation;
import dao.ClientTableManipulation;
import dao.Factor1TableManipulation;
import dao.Factor2TableManipulation;
import dao.Factor3TableManipulation;
import dao.Factor4TableManipulation;
import dao.FollowUpTableManipulation;
import dao.MentalStatusExamManipulation;
import dao.StrengthResourceManipulation;
import daoBean.AdditionalNotesBean;
import daoBean.CaseHistoryBean;
import daoBean.ClientBean;
import daoBean.Factor1Bean;
import daoBean.Factor2Bean;
import daoBean.Factor3Bean;
import daoBean.Factor4Bean;
import daoBean.FollowUpBean;
import daoBean.MentalStatusExamBean;
import daoBean.StrengthAndResourcesBean;
import pages.helper.Validator;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public JPanel pages;

	public LogIn login;

	public FindPatient findCase;

	public int clientId = 0;

	public int followUp = 1;

	public int stage = 0;

	public Menu panel;
	public Layered layeredPane;

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

					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					Home frame = new Home();
					frame.setTitle("CompuPIE");
					frame.setVisible(true);
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

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

		layeredPane = new Layered(getThisObject(), getBounds());
		login = new LogIn(getThisObject());
		login.setVisible(true);

		panel = new Menu(getThisObject(), getBounds());
		panel.setVisible(false);
		layeredPane.add(login);
		layeredPane.add(panel);
		layeredPane.lblNewLabel.setVisible(false);
		saveListener();
		layeredPane.btnGoHome.setVisible(false);
		layeredPane.btnSave.setVisible(false);
		layeredPane.setVisible(true);
		setContentPane(layeredPane);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				Rectangle rect = new Rectangle(getThisObject().getBounds());
				panel.setBounds(rect);
				login.setBounds(rect);
				if(pages_1 !=null){
					pages_1.setBounds(rect);
				}
				layeredPane.setBounds(rect);
				revalidate();
				repaint();
			}
		});

	}

	public void updateSize(Rectangle r) {
		getThisObject().setBounds(r);
		Rectangle rect = r;
		panel.setBounds(rect);
		login.setBounds(rect);
		layeredPane.setBounds(rect);
		if(pages_1 !=null){
			pages_1.setBounds(rect);
		}
		revalidate();
		repaint();
	}

	public Home getThisObject() {
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
		layeredPane.btnSave.addActionListener(new ActionListener() {
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
					saveMSE();
					saveAddnlNotes();
					JOptionPane.showMessageDialog(getThisObject(), "Details saved Successfully.");
					//pages_1.getPanel8().populateitems(false);
					pages_1.setPanel8(new Report(clientId));
					revalidate();
					repaint();
				} else {
					StringBuffer sb = new StringBuffer();
					for (String msg : valid.getMsgs()) {

						sb.append(msg + "\n");

					}
					JOptionPane.showMessageDialog(getThisObject(), sb.toString(), "Details not Saved",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void saveFollowUp() {
				if (createFollowUp && (pages_1.getPanel().isIstoUpdate() || pages_1.getPanel6().isHasToUpdate()
						|| pages_1.getPanel1().isHasToUpdate() || pages_1.getPanel2().isHasToUpdate()
						|| pages_1.getPanel3().isHasToUpdate() || pages_1.getPanel4().isHasToUpdate()
						|| pages_1.getPanel7().hastoUpdate() || pages_1.getMse().needsUpdate()
						|| pages_1.getAdd().isHastoUpdate())) {
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
				pages_1.getPanel().setIstoUpdate(false);
			}

			private void saveCaseHistory() {

				if (pages_1.getPanel6().isHasToUpdate()) {
					CaseHistoryBean bean = pages_1.getPanel6().getCurrentValues();
					CaseHistoryTableManipulation dao = new CaseHistoryTableManipulation();
					if (pages_1.getPanel6().isHasToUpdate() && pages_1.getPanel6().getCaseHistoryId() != -1) {
						dao.updateNewHIstory(bean);
					} else if (pages_1.getPanel6().isHasToUpdate()) {
						if (!createFollowUp && clientId == 0) {
							ClientTableManipulation cli = new ClientTableManipulation();
							getThisObject().clientId = clientId = cli.getmaxId() + 1;
						}
					}
					bean.setClientId(clientId);
					dao.saveNewHistory(bean);
				}
				pages_1.getPanel6().setHasToUpdate(false);
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
					bean.setClientid(clientId);
					if (bean.getId() != 0) {
						dao.updateNewStrength(bean);
					} else if (bean.getId() == 0) {
						if (!createFollowUp && clientId == 0) {
							ClientTableManipulation cli = new ClientTableManipulation();
							getThisObject().clientId = clientId = cli.getmaxId() + 1;
						}
					}
					bean.setClientid(clientId);
					dao.saveNewStrength(bean);
				}
				pages_1.getPanel7().settoUpdate(false);
			}

			private void saveMSE() {
				if (pages_1.getMse().needsUpdate()) {
					MentalStatusExamBean bean = pages_1.getMse().getCurrentBean();
					MentalStatusExamManipulation dao = new MentalStatusExamManipulation();
					bean.setClientId(clientId);
					if (bean.getId() != 0) {
						dao.updateNewStrength(bean);
					} else if (bean.getId() == 0) {
						if (!createFollowUp && clientId == 0) {
							ClientTableManipulation cli = new ClientTableManipulation();
							getThisObject().clientId = clientId = cli.getmaxId() + 1;
						}
					}
					bean.setClientId(clientId);
					dao.saveNewStrength(bean);
					pages_1.getMse().populateAllTabs();
				}
			}

			private void saveAddnlNotes() {
				if (pages_1.getAdd().isHastoUpdate()) {
					AdditionalNotesBean bean = pages_1.getAdd().getCurrentBean();
					AdditionalNotesManipulation dao = new AdditionalNotesManipulation();
					bean.setClientId(clientId);
					if (bean.getId() != 0) {
						dao.updateNewStrength(bean);
					} else if (bean.getId() == 0) {
						if (!createFollowUp && clientId == 0) {
							ClientTableManipulation cli = new ClientTableManipulation();
							getThisObject().clientId = clientId = cli.getmaxId() + 1;
						}
					}
					bean.setClientId(clientId);
					dao.saveNewStrength(bean);
					pages_1.getAdd().populate();
				}
			}
		});
	}
}
