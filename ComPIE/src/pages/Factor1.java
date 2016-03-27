package pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;

public class Factor1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Factor1() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		
		JLabel lblClientsLastName = new JLabel("Client's Last Name ");
		lblClientsLastName.setBounds(33, 70, 237, 14);
		add(lblClientsLastName);
		
		JLabel lblFirstName = new JLabel("First Name ");
		lblFirstName.setBounds(383, 70, 191, 14);
		add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(33, 88, 226, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(383, 88, 261, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAssessmentType = new JLabel("Assessment Type");
		lblAssessmentType.setBounds(33, 119, 148, 14);
		add(lblAssessmentType);
		
		JLabel lblAssessmentDate = new JLabel("Assessment Date");
		lblAssessmentDate.setBounds(193, 119, 167, 14);
		add(lblAssessmentDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(33, 134, 117, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(193, 134, 142, 20);
		add(comboBox_1);
		
		JLabel lblSocialRoleDescription = new JLabel("Social Role Description");
		lblSocialRoleDescription.setBounds(33, 175, 261, 14);
		add(lblSocialRoleDescription);
		
		JLabel lblProblemType = new JLabel("Problem Type");
		lblProblemType.setBounds(320, 175, 254, 14);
		add(lblProblemType);
		
		JLabel lblSeverity = new JLabel("Severity");
		lblSeverity.setBounds(598, 175, 226, 14);
		add(lblSeverity);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(34, 190, 261, 20);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(322, 190, 252, 20);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(598, 190, 304, 20);
		add(comboBox_4);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(33, 231, 237, 14);
		add(lblDuration);
		
		JLabel lblCopingAbility = new JLabel("Coping Ability");
		lblCopingAbility.setBounds(320, 231, 237, 14);
		add(lblCopingAbility);
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setBounds(595, 231, 237, 14);
		add(lblStrength);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(34, 246, 261, 20);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(322, 246, 252, 20);
		add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(598, 246, 304, 20);
		add(comboBox_7);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(34, 296, 400, 107);
		add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(475, 296, 400, 107);
		add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(34, 430, 400, 107);
		add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(475, 430, 400, 107);
		add(textArea_3);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setBounds(34, 277, 129, 14);
		add(lblGoal);
		
		JLabel lblRecommendedIntervention = new JLabel("Recommended Intervention");
		lblRecommendedIntervention.setBounds(474, 277, 285, 14);
		add(lblRecommendedIntervention);
		
		JLabel lblReferredTo = new JLabel("Referred To");
		lblReferredTo.setBounds(34, 414, 260, 14);
		add(lblReferredTo);
		
		JLabel lblExpectedOutcome = new JLabel("Expected Outcome");
		lblExpectedOutcome.setBounds(474, 414, 285, 14);
		add(lblExpectedOutcome);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(34, 549, 200, 14);
		add(lblPriority);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(34, 574, 160, 20);
		add(comboBox_8);
		
		JLabel lblFactorISocial = new JLabel("Factor I: Social Role and Relationship Functioning");
		lblFactorISocial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactorISocial.setBounds(239, 24, 440, 35);
		add(lblFactorISocial);
	}

}
