package pages;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import pages.helper.Browser;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public Menu(Home home, Rectangle rectangle) {
		setBounds(rectangle);
		btnNewButton_1 = new JButton("Find Existing Case");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNewButton= new JButton("Open New Case");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnHistoryOfPie = new JButton("History of PIE");
		btnHistoryOfPie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				new Browser(System.getProperty("user.dir")+"/resources/History_of_PIE_System.pdf","History of PIE System");
				}catch(Exception e){}
			}
		});
		btnHistoryOfPie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDedication = new JButton("Dedication");
		btnDedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				new Browser(System.getProperty("user.dir")+"/resources/Dedication.pdf","Dedication");
				}catch(Exception e1){}
			}
		});
		btnDedication.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton button_3 = new JButton("New button");
		
		JButton button_4 = new JButton("New button");
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("CompuPIE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("An Assessment Tool for Social Workers");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("and Other Practitioners");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea txtrCompupieIsAn = new JTextArea();
		txtrCompupieIsAn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtrCompupieIsAn.setEnabled(false);
		txtrCompupieIsAn.setWrapStyleWord(true);
		txtrCompupieIsAn.setLineWrap(true);
		txtrCompupieIsAn.setText("CompuPIE is an assessment tool that helps its users formulate a holistic assessment of clients\u2019 biopsychosocial functioning using the PIE System .A four factor classification system which includes the following dimensions: Social Role, Social Environmental Needs/Problems, Mental Health and Physical Health. The PIE system enables both practitioner and client to have a clear and comprehensive understanding of what is needed to enable clients to reach their goals. ");
		ImageIcon icon = new ImageIcon("images/officiallogoSmall.png");
		JLabel lblNewLabel_3 = new JLabel(icon);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(113)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(128))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(69)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(71)))
					.addGap(260))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(397)
					.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(405))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtrCompupieIsAn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnDedication, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
									.addGap(74)
									.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
									.addGap(74)
									.addComponent(btnHistoryOfPie, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))))
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(lblNewLabel_2)))
					.addGap(18)
					.addComponent(txtrCompupieIsAn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(btnHistoryOfPie, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
								.addComponent(btnDedication, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
					.addGap(49))
		);
		setLayout(groupLayout);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.stage = 0;
				home.createFollowUp = true;
				home.pages_1 = new ClientInfo(0,rectangle);
				home.pages_1.setBounds(rectangle);
				home.layeredPane.add(home.pages_1);
				setVisible(false);
				home.pages_1.setVisible(true);
				home.layeredPane.btnSave.setVisible(true);
				home.layeredPane.btnGoHome.setVisible(true);
				repaint();
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.findCase = new FindPatient(home.getThisObject());
				home.layeredPane.add(home.findCase);
				home.findCase.setVisible(true);
				home.panel.setVisible(false);
				home.repaint();
			}
		});
	}
}
