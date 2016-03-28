package pages;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import dao.CaseHistoryTableManipulation;
import dao.Factor1TableManipulation;
import daoBean.CaseHistoryBean;
import daoBean.Factor1Bean;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JPanel pages;
	
	private int clientId=1;
	
	private int followUp=1;

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
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 986, 0 };
		gbl_contentPane.rowHeights = new int[] { 692, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		pages_1 = new ClientInfo();
		pages_1.setBounds(0, 24, 982, 658);

		JLayeredPane layeredPane = new JLayeredPane();
		GridBagConstraints gbc_layeredPane = new GridBagConstraints();
		gbc_layeredPane.fill = GridBagConstraints.BOTH;
		gbc_layeredPane.gridx = 0;
		gbc_layeredPane.gridy = 0;
		contentPane.add(layeredPane, gbc_layeredPane);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(173, 255, 47));
		panel.setBounds(0, 11, 982, 658);
		JLabel lblCompupie = new JLabel("CompuPIE");
		lblCompupie.setBounds(450, 11, 91, 25);
		panel.add(lblCompupie);
		lblCompupie.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblPesonInEnvironment = new JLabel("Person In Environment System");
		lblPesonInEnvironment.setBounds(401, 47, 191, 17);
		panel.add(lblPesonInEnvironment);
		lblPesonInEnvironment.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTextPane txtpnCompupieInConjunction = new JTextPane();
		txtpnCompupieInConjunction.setEditable(false);
		txtpnCompupieInConjunction.setBounds(76, 364, 392, 151);
		panel.add(txtpnCompupieInConjunction);
		txtpnCompupieInConjunction.setText(
				"CompuPIE, in conjunction with the PIE Manual,produces succinct description of client's social functioning problems and strengths. Assessments can be made at the initial contact and at follow-up contacts. Data entered may be modified as needed. CompPIE generates printed statements of findings and recommendations for interventions.");

		JButton btnNewButton = new JButton("Open New Case");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				pages_1.setVisible(true);
				btnSave.setVisible(true);
				btnGoHome.setVisible(true);
			}
		});
		layeredPane.setLayout(null);
		btnNewButton.setBounds(651, 188, 127, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Find Existing Case");
		btnNewButton_1.setBounds(651, 238, 127, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete Case");
		btnNewButton_2.setBounds(651, 297, 127, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Exit CompuPIE");
		btnNewButton_3.setBounds(651, 346, 127, 23);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Display Instructions");
		btnNewButton_4.setBounds(651, 397, 127, 23);
		panel.add(btnNewButton_4);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(693, 135, 38, 20);
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JTextPane txtpnCompupieSystemCopyrightc = new JTextPane();
		txtpnCompupieSystemCopyrightc.setBounds(340, 605, 350, 34);
		panel.add(txtpnCompupieSystemCopyrightc);
		txtpnCompupieSystemCopyrightc.setEnabled(false);
		txtpnCompupieSystemCopyrightc.setEditable(false);
		txtpnCompupieSystemCopyrightc.setText(
				"CompuPIE System, Copyright(c) 1998-2007, J.M. Karls and M. O'Keefe.\r\nAll rights reserved.                                                            Version 0320");

		layeredPane.add(panel);
		layeredPane.add(pages_1);
		panel.setLayout(null);

		JLabel lblLogoGoesHere = new JLabel("Logo Goes here....");
		lblLogoGoesHere.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLogoGoesHere.setBounds(57, 174, 367, 124);
		panel.add(lblLogoGoesHere);
		saveListener();
		btnSave.setBounds(781, 0, 89, 23);
		layeredPane.add(btnSave);
		btnGoHome.setBounds(887, 0, 89, 23);
		layeredPane.add(btnGoHome);
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

	/**
	 * 
	 */
	private void saveListener() {
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveCaseHistory();
				saveFactor1();
			}

			private void saveCaseHistory() {
				if(pages_1.getPanel6().isHasToUpdate()){
					CaseHistoryBean bean = pages_1.getPanel6().getCurrentValues();
					CaseHistoryTableManipulation dao = new CaseHistoryTableManipulation();
					if(pages_1.getPanel6().isHasToUpdate() && pages_1.getPanel6().getCaseHistoryId() != -1){
						dao.updateNewHIstory(bean);	
					}else if(pages_1.getPanel6().isHasToUpdate()){
						dao.saveNewHistory(bean);	
					}
				}
			}

			private void saveFactor1() {
				if(pages_1.getPanel1().isHasToUpdate()){
					Factor1Bean bean = pages_1.getPanel1().getCurrentValues();
					Factor1TableManipulation dao = new Factor1TableManipulation();
					bean.setClientId(clientId);
					bean.setFollowup(followUp);
					dao.saveNewFactory(bean);
					pages_1.getPanel1().getTable().setModel(pages_1.getPanel1().tablePopulate(clientId));
					pages_1.repaint();
				}
			}
		});
	}
}
