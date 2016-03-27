package pages;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Factor3 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Factor3() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		JLabel lblFactorIiEnvironmental = new JLabel("FACTOR III: Mental Health Functioning ");
		lblFactorIiEnvironmental.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFactorIiEnvironmental.setBounds(271, 11, 394, 25);
		add(lblFactorIiEnvironmental);
		
		JLabel lblAssessmentType = new JLabel("Assessment Type ");
		lblAssessmentType.setBounds(36, 50, 129, 14);
		add(lblAssessmentType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 47, 235, 20);
		add(comboBox);
		
		JLabel lblAssessmentDate = new JLabel("Assessment Date");
		lblAssessmentDate.setBounds(440, 50, 115, 14);
		add(lblAssessmentDate);
		
		textField = new JTextField();
		textField.setBounds(565, 47, 193, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDsmAxisI = new JLabel("DSM Axis I Diagnosis");
		lblDsmAxisI.setBounds(36, 83, 129, 14);
		add(lblDsmAxisI);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(37, 95, 373, 20);
		add(comboBox_1);
		
		JLabel lblDiagnosisSource = new JLabel("Diagnosis Source");
		lblDiagnosisSource.setBounds(440, 83, 117, 14);
		add(lblDiagnosisSource);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(440, 95, 259, 20);
		add(comboBox_2);
		
		JLabel lblDsmCode = new JLabel("DSM Code");
		lblDsmCode.setBounds(728, 83, 94, 14);
		add(lblDsmCode);
		
		textField_1 = new JTextField();
		textField_1.setBounds(724, 95, 185, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSeverity = new JLabel("Severity");
		lblSeverity.setBounds(36, 127, 94, 14);
		add(lblSeverity);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(271, 126, 122, 14);
		add(lblDuration);
		
		JLabel lblCopingAbility = new JLabel("Coping Ability");
		lblCopingAbility.setBounds(521, 127, 116, 14);
		add(lblCopingAbility);
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setBounds(711, 127, 111, 14);
		add(lblStrength);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(36, 139, 210, 20);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(269, 139, 242, 20);
		add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(521, 139, 178, 20);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(711, 139, 198, 20);
		add(comboBox_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 184, 874, 61);
		add(textArea);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setBounds(36, 170, 46, 14);
		add(lblGoal);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(36, 276, 222, 61);
		add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(271, 276, 222, 61);
		add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(503, 276, 222, 61);
		add(textArea_3);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(755, 298, 154, 20);
		add(comboBox_7);
		
		JLabel lblRecommendedIntervention = new JLabel("Recommended Intervention");
		lblRecommendedIntervention.setBounds(36, 256, 222, 14);
		add(lblRecommendedIntervention);
		
		JLabel lblReferredTo = new JLabel("Referred To");
		lblReferredTo.setBounds(277, 256, 133, 14);
		add(lblReferredTo);
		
		JLabel lblExpectedOutcome = new JLabel("Expected Outcome");
		lblExpectedOutcome.setBounds(503, 256, 162, 14);
		add(lblExpectedOutcome);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(755, 281, 46, 14);
		add(lblPriority);
		
		JLabel lblDsmAxisIi = new JLabel("DSM Axis II Diagnosis");
		lblDsmAxisIi.setBounds(37, 347, 221, 14);
		add(lblDsmAxisIi);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(37, 362, 373, 20);
		add(comboBox_8);
		
		JLabel label_1 = new JLabel("Diagnosis Source");
		label_1.setBounds(440, 348, 197, 14);
		add(label_1);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(440, 362, 259, 20);
		add(comboBox_9);
		
		JLabel label_2 = new JLabel("DSM Code");
		label_2.setBounds(728, 347, 94, 14);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(728, 362, 185, 20);
		add(textField_2);
		
		JLabel label_3 = new JLabel("Severity");
		label_3.setBounds(37, 388, 93, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Duration");
		label_4.setBounds(272, 387, 101, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Coping Ability");
		label_5.setBounds(522, 388, 116, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Strength");
		label_6.setBounds(712, 388, 46, 14);
		add(label_6);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(36, 400, 210, 20);
		add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(270, 400, 242, 20);
		add(comboBox_11);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(522, 400, 178, 20);
		add(comboBox_12);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBounds(712, 400, 198, 20);
		add(comboBox_13);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(36, 443, 874, 61);
		add(textArea_4);
		
		JLabel label_7 = new JLabel("Goal");
		label_7.setBounds(37, 429, 46, 14);
		add(label_7);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(36, 526, 222, 61);
		add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(278, 527, 222, 61);
		add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(510, 527, 222, 61);
		add(textArea_7);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setBounds(756, 529, 154, 20);
		add(comboBox_14);
		
		JLabel label_8 = new JLabel("Recommended Intervention");
		label_8.setBounds(36, 513, 166, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("Referred To");
		label_9.setBounds(278, 512, 80, 14);
		add(label_9);
		
		JLabel label_10 = new JLabel("Expected Outcome");
		label_10.setBounds(510, 512, 117, 14);
		add(label_10);
		
		JLabel label_11 = new JLabel("Priority");
		label_11.setBounds(756, 512, 46, 14);
		add(label_11);
	}

}
