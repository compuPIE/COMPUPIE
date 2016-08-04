package pages;

import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class LogIn extends JPanel {
	private JTextField textField;

	Home home;

	public LogIn(Home home) {
		this.home = home;
		setBounds(0, 11, 982, 671);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Logo_png.png"));
		JLabel lblNewLabel = new JLabel("CompuPIE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Javanese Text", Font.BOLD, 86));

		JLabel lblNewLabel_1 = new JLabel("Enter your Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				home.username = textField.getText();
				for (Component comp : home.layeredPane.getComponents()) {
					if (comp instanceof JLabel && ((JLabel) comp).getText().contains("Welcome")) {
						((JLabel) comp).setText("Welcome " + textField.getText());
					}
				}
				getThisObject().setVisible(false);
				home.layeredPane.lblNewLabel.setVisible(true);
				home.panel.setVisible(true);

				repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnNewButton_1 = new JButton("Change Theme");
		try {
			if (!System.getProperty("os.name").contains("MAC")) {
				
				btnNewButton_1 = new JButton("Change Background",
						new ImageIcon(new File("images/setting.png").toURI().toURL()));
				btnNewButton_1.setVisible(false);
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!System.getProperty("os.name").contains("MAC")) {
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
		}
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNewLabel_2 = new JLabel(icon);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
					.addGap(29))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
					.addGap(29))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(232, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public LogIn getThisObject() {
		return this;
	}
}
