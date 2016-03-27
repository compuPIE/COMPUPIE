package pages;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JEditorPane;

public class CHDC extends JPanel {

	/**
	 * Create the panel.
	 */
	public CHDC() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		JLabel lblFactorIiEnvironmental = new JLabel("Case History, Dynamics and Comments");
		lblFactorIiEnvironmental.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactorIiEnvironmental.setBounds(271, 11, 394, 25);
		add(lblFactorIiEnvironmental);
		
		JLabel lblEnterCaseHistory = new JLabel("Enter Case History, Dynamics and Comments For this Client");
		lblEnterCaseHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterCaseHistory.setBounds(31, 78, 443, 14);
		add(lblEnterCaseHistory);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(31, 103, 882, 473);
		add(editorPane);
	}
}
