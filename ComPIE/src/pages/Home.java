package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import dao.CaseHistoryTableManipulation;
import dao.ClientTableManipulation;
import dao.Factor1TableManipulation;
import dao.Factor2TableManipulation;
import daoBean.CaseHistoryBean;
import daoBean.ClientBean;
import daoBean.Factor1Bean;
import daoBean.Factor2Bean;
import net.infonode.gui.laf.InfoNodeLookAndFeel;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JPanel pages;

	private int clientId = 1;

	private int followUp = 1;

	JButton btnSave = new JButton("Save");
	JButton btnGoHome = new JButton("Go Back");

	private ClientInfo pages_1;

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
					 //UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.AcrylLookAndFeel");
					 
					// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					//UIManager.setLookAndFeel(new InfoNodeLookAndFeel());
					Home frame = new Home();
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
		pages_1 = new ClientInfo();
		pages_1.setBounds(0, 24, 982, 658);

		JLayeredPane layeredPane = new JLayeredPane();

		JPanel panel = new JPanel();
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
		txtpnCompupieInConjunction.setText(
				"CompuPIE, in conjunction with the PIE Manual,produces succinct description of client's social functioning problems and strengths. Assessments can be made at the initial contact and at follow-up contacts. Data entered may be modified as needed. CompPIE generates printed statements of findings and recommendations for interventions.");

		JButton btnNewButton = new JButton("Open New Case");
		btnNewButton.setBounds(651, 188, 127, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				pages_1.setVisible(true);
				btnSave.setVisible(true);
				btnGoHome.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("Find Existing Case");
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
		layeredPane.add(pages_1);
		btnGoHome.setBounds(887, 0, 89, 23);
		layeredPane.add(btnGoHome);
		btnSave.setBounds(781, 0, 89, 23);
		layeredPane.add(btnSave);
		layeredPane.add(panel);
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
		pages_1.setVisible(false);
	}
	
	
	 public void changeLF() {

	        List<String> lookAndFeelsDisplay = new ArrayList<>();
	        List<String> lookAndFeelsRealNames = new ArrayList<>();

	        for (LookAndFeelInfo each : UIManager.getInstalledLookAndFeels()) {
	            lookAndFeelsDisplay.add(each.getName());
	            lookAndFeelsRealNames.add(each.getClassName());
	        }

	        String changeLook = (String) JOptionPane.showInputDialog(this, "Choose Look and Feel Here:", "Select Look and Feel", JOptionPane.QUESTION_MESSAGE, null, lookAndFeelsDisplay.toArray(), null);

	        if (changeLook != null) {
	            for (int a = 0; a < lookAndFeelsDisplay.size(); a++) {
	                if (changeLook.equals(lookAndFeelsDisplay.get(a))) {
	                    try {
	                        UIManager.setLookAndFeel(lookAndFeelsRealNames.get(a));
	                        break;
	                    }
	                    catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	                        System.err.println(ex);
	                        ex.printStackTrace(System.err);
	                    }
	                }
	            }
	        }
	    }
	/**
	 * 
	 */
	private void saveListener() {
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCaseHistory();
				saveFactor1();
				saveClientInfo();
				saveFactor2();
			}

			private void saveClientInfo() {
				ClientBean cb = pages_1.getPanel().getClientInformation();
				if (pages_1.getPanel().isIstoUpdate() && cb.getId() == 0) {
					ClientTableManipulation manip = new ClientTableManipulation();
					manip.saveNewClient(cb);
				} else if (pages_1.getPanel().isIstoUpdate() && cb.getId() != 0) {
					ClientTableManipulation manip = new ClientTableManipulation();
					manip.updateNewClient(cb);
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
				Factor1Bean bean = pages_1.getPanel1().getCurrentValues();
				Factor1TableManipulation dao = new Factor1TableManipulation();
				if (pages_1.getPanel1().isHasToUpdate() && bean.getId() ==0) {
					bean.setClientId(clientId);
					bean.setFollowup(followUp);
					dao.saveNewFactory(bean);
					pages_1.getPanel1().getTable().setModel(pages_1.getPanel1().tablePopulate(clientId));
					pages_1.repaint();
				} else if (pages_1.getPanel1().isHasToUpdate() && bean.getId() !=0) {
					bean.setClientId(clientId);
					bean.setFollowup(followUp);
					dao.updateNewFactory(bean);
					pages_1.getPanel1().getTable().setModel(pages_1.getPanel1().tablePopulate(clientId));
					pages_1.repaint();
				}
			}
			
			private void saveFactor2(){
				Factor2Bean bean = pages_1.getPanel2().getCurrentValues();
				if (pages_1.getPanel2().isHasToUpdate() && bean.getId() == 0) {
					Factor2TableManipulation dao = new Factor2TableManipulation();
					bean.setClientId(clientId);
					bean.setFollowup(followUp);
					dao.saveNewFactory(bean);
					pages_1.getPanel2().getTable().setModel(pages_1.getPanel2().tablePopulate(clientId,pages_1.getPanel2().getCurrentMenu()));
					pages_1.repaint();
				}else if (pages_1.getPanel2().isHasToUpdate() && bean.getId() != 0){
					Factor2TableManipulation dao = new Factor2TableManipulation();
					bean.setClientId(clientId);
					bean.setFollowup(followUp);
					dao.updateNewFactory(bean);
					pages_1.getPanel2().getTable().setModel(pages_1.getPanel2().tablePopulate(clientId,pages_1.getPanel2().getCurrentMenu()));
					pages_1.repaint();
				}
			}
		});
	}
}
