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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));

		btnNewButton = new JButton("Open New Case");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton btnHistoryOfPie = new JButton("New to PIE");
		btnHistoryOfPie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnHistoryOfPie.setFont(new Font("Tahoma", Font.PLAIN, 30));

		
	

		JButton btnDedication = new JButton("CompuPIE Instructions");
		btnDedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Browser b = new Browser(
							"History_of_PIE_System.pdf",
							"History of PIE System");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnDedication.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JButton button_3 = new JButton("Dedication");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Browser b = new Browser("Dedication.pdf",
							"Dedication");
				} catch (Exception e1) {
				}
			}
		});

		JButton button_4 = new JButton("About the author");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 30));

		JLabel lblNewLabel = new JLabel("CompuPIE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));

		JLabel lblNewLabel_1 = new JLabel("An Assessment Tool for Social Workers");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("and Other Practitioners");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JTextArea txtrCompupieIsAn = new JTextArea();
		txtrCompupieIsAn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		txtrCompupieIsAn.setEnabled(false);
		txtrCompupieIsAn.setWrapStyleWord(true);
		txtrCompupieIsAn.setLineWrap(true);
		txtrCompupieIsAn.setText(
				"CompuPIE is an assessment tool that helps its users formulate a holistic assessment of clients\u2019 biopsychosocial functioning using the PIE System .A four factor classification system which includes the following dimensions: Social Role, Social Environmental Needs/Problems, Mental Health and Physical Health. The PIE system enables both practitioner and client to have a clear and comprehensive understanding of what is needed to enable clients to reach their goals. ");
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("logo_png_small.png"));
		JLabel lblNewLabel_3 = new JLabel(icon);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(382)
							.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
							.addGap(366))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
							.addGap(34)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
							.addGap(32)
							.addComponent(btnHistoryOfPie, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(btnDedication, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
							.addGap(34)
							.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
							.addGap(32)
							.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(113)
											.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
											.addGap(128))
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
									.addGap(206))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(19)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
									.addGap(277))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(txtrCompupieIsAn, GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)))
					.addGap(54))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblNewLabel_1)
							.addGap(6)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3))
					.addGap(31)
					.addComponent(txtrCompupieIsAn, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(btnHistoryOfPie, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDedication, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.stage = 0;
				home.createFollowUp = true;
				home.pages_1 = new ClientInfo(0, rectangle);
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
