package pages;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LogIn extends JPanel{
	private JTextField textField;
	
	Home home;

	public LogIn(Home home){
		this.home = home;
		setBounds(0, 11, 982, 671);
		
		JLabel lblNewLabel = new JLabel("CompuPIE");
		lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 86));
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home.username= textField.getText();
				for(Component comp : home.layeredPane.getComponents()){
					if(comp instanceof JLabel && ((JLabel) comp).getText().contains("Welcome")){
						((JLabel) comp).setText("Welcome "+textField.getText());
					}
				}
				getThisObject().setVisible(false);
				home.panel.setVisible(true);
				
				repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Change Theme");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rectangle r = home.getThisObject().getBounds();
				home.changeLF();
				repaint();
				SwingUtilities.updateComponentTreeUI(home.layeredPane.getParent());
				home.pack();
				home.updateSize(r);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(327)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(243)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
									.addGap(173))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(152)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
							.addGap(14)))
					.addGap(68))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
					.addGap(82))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	public LogIn getThisObject() {
		return this;
	}
}
