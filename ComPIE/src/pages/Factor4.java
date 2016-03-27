package pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;

public class Factor4 extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Factor4() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		
		JLabel label = new JLabel("Assessment Type");
		label.setBounds(38, 84, 148, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Assessment Date");
		label_1.setBounds(198, 84, 241, 14);
		add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(38, 99, 117, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(198, 99, 142, 20);
		add(comboBox_1);
		
		JLabel lblPhysicalHealthProblem = new JLabel("Physical Health Problem");
		lblPhysicalHealthProblem.setBounds(38, 140, 241, 14);
		add(lblPhysicalHealthProblem);
		
		JLabel lblDiagnosisSource = new JLabel("Diagnosis Source");
		lblDiagnosisSource.setBounds(325, 140, 171, 14);
		add(lblDiagnosisSource);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(603, 140, 46, 14);
		add(lblCode);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(39, 155, 261, 20);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(327, 155, 252, 20);
		add(comboBox_3);
		
		JLabel label_5 = new JLabel("Duration");
		label_5.setBounds(310, 196, 117, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Coping Ability");
		label_6.setBounds(480, 196, 109, 14);
		add(label_6);
		
		JLabel label_7 = new JLabel("Strength");
		label_7.setBounds(707, 196, 123, 14);
		add(label_7);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(310, 211, 160, 20);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(480, 211, 208, 20);
		add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(709, 211, 171, 20);
		add(comboBox_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(39, 261, 400, 107);
		add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(480, 261, 400, 107);
		add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(39, 395, 400, 107);
		add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(480, 395, 400, 107);
		add(textArea_3);
		
		JLabel label_8 = new JLabel("Goal");
		label_8.setBounds(39, 242, 46, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("Recommended Intervention");
		label_9.setBounds(479, 242, 205, 14);
		add(label_9);
		
		JLabel label_10 = new JLabel("Referred To");
		label_10.setBounds(39, 379, 93, 14);
		add(label_10);
		
		JLabel label_11 = new JLabel("Expected Outcome");
		label_11.setBounds(479, 379, 117, 14);
		add(label_11);
		
		JLabel label_12 = new JLabel("Priority");
		label_12.setBounds(39, 514, 46, 14);
		add(label_12);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(39, 539, 160, 20);
		add(comboBox_8);
		
		JLabel lblFactorIvPhysical = new JLabel("FACTOR IV: Physical Health Problems");
		lblFactorIvPhysical.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactorIvPhysical.setBounds(325, 26, 394, 25);
		add(lblFactorIvPhysical);
		
		textField = new JTextField();
		textField.setBounds(603, 155, 277, 20);
		add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(38, 211, 252, 20);
		add(comboBox_4);
		
		JLabel lblSeverity = new JLabel("Severity");
		lblSeverity.setBounds(38, 196, 46, 14);
		add(lblSeverity);
	}

}
