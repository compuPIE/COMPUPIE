package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Layers extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layers frame = new Layers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Layers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(21, 521, 1380, -515);
		contentPane.add(layeredPane);
		
		JPanel panel = new JPanel();
	
		panel.setLayout(null);
		
		JLabel lblCompupie = new JLabel("CompuPIE");
		lblCompupie.setBounds(290, 5, 91, 25);
		panel.add(lblCompupie);
		lblCompupie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPesonInEnvironment = new JLabel("Person In Environment System");
		lblPesonInEnvironment.setBounds(386, 11, 191, 17);
		panel.add(lblPesonInEnvironment);
		lblPesonInEnvironment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextPane txtpnCompupieInConjunction = new JTextPane();
		txtpnCompupieInConjunction.setBounds(-378, 35, 1624, 20);
		panel.add(txtpnCompupieInConjunction);
		txtpnCompupieInConjunction.setEnabled(false);
		txtpnCompupieInConjunction.setEditable(false);
		txtpnCompupieInConjunction.setText("CompuPIE, in conjunction with the PIE Manual,produces succinct description of client's social functioning problems and strengths. Assessments can be made at the initial contact and at follow-up contacts. Data entered may be modified as needed. CompPIE generates printed statements of findings and recommendations for interventions.");
		
		JButton btnNewButton = new JButton("Open New Case");
		btnNewButton.setBounds(128, 61, 109, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Find Existing Case");
		btnNewButton_1.setBounds(242, 61, 119, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Case");
		btnNewButton_2.setBounds(366, 61, 91, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Exit CompuPIE");
		btnNewButton_3.setBounds(462, 61, 103, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Display Instructions");
		btnNewButton_4.setBounds(570, 61, 127, 23);
		panel.add(btnNewButton_4);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setBounds(702, 60, 38, 20);
		panel.add(lblMenu);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextPane txtpnCompupieSystemCopyrightc = new JTextPane();
		txtpnCompupieSystemCopyrightc.setBounds(259, 89, 350, 34);
		panel.add(txtpnCompupieSystemCopyrightc);
		txtpnCompupieSystemCopyrightc.setEnabled(false);
		txtpnCompupieSystemCopyrightc.setEditable(false);
		txtpnCompupieSystemCopyrightc.setText("CompuPIE System, Copyright(c) 1998-2007, J.M. Karls and M. O'Keefe.\r\nAll rights reserved.                                                            Version 0320");
		panel.setVisible(true);
		layeredPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		layeredPane.add(panel);
	}
}

