package pages;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {
	

	MSE panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Test frame = new Test();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 11, 982, 671);
		//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		
		
		panel = new MSE(1);
		panel.setBorder(new CompoundBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(0, 0, 0)), null));
		panel.setVisible(true);
		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//panel.getCurrentString();
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		
		
		
	}
}
