package pages;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogIn extends JPanel{
	private JTextField textField;
	
	Home home;

	public LogIn(Home home){
		this.home = home;
		setBounds(0, 11, 982, 671);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CompuPIE");
		lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 86));
		lblNewLabel.setBounds(327, 159, 587, 188);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(570, 401, 157, 34);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(722, 411, 178, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				home.username= textField.getText();
				for(Component comp : home.panel.getComponents()){
					if(comp instanceof JLabel && ((JLabel) comp).getText().contains("Welcome")){
						((JLabel) comp).setText("Welcome "+textField.getText());
					}
				}
				getThisObject().setVisible(false);
				repaint();
				home.panel.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(811, 478, 89, 34);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("images/officialLogo.jpg"));
		lblNewLabel_2.setBounds(36, 183, 281, 248);
		add(lblNewLabel_2);
	}
	public LogIn getThisObject() {
		return this;
	}
}
