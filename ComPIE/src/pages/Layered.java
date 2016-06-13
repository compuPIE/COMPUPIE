package pages;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

public class Layered extends JLayeredPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblNewLabel;
	JButton btnSave = new JButton("Save");
	JButton btnGoHome ;
	public Layered(Home home,Rectangle rect) {
		try {
			btnGoHome = new JButton("Home", new ImageIcon(new File("images/home.png").toURI().toURL()));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(rect);
		JLabel lblNewLabel = new JLabel("Welcome " + home.username);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
		//add(home.login);
		//add(home.panel);
		
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.pages_1.setVisible(false);
				btnSave.setVisible(false);
				btnGoHome.setVisible(false);
				home.panel.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addGap(557)
					.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(23)
					.addComponent(btnGoHome, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(3)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(474, Short.MAX_VALUE))
				.addComponent(btnSave)
				.addComponent(btnGoHome)
		);
		setLayout(groupLayout);
		
	}

}
