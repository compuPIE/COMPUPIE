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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

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
		
		JButton button_1 = new JButton("New button");
		
		JButton button_2 = new JButton("New button");
		
		JButton button_3 = new JButton("New button");
		
		JButton button_4 = new JButton("New button");
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(77)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(74)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addGap(68))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(77)
					.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addGap(74)
					.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addGap(68))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(403)
					.addComponent(lblMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(399))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addGap(220))
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
