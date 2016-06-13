package pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Factor2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public Factor2() {
		setBounds(0, 11, 963, 609);
		
		JLabel lblFactorIiEnvironmental = new JLabel("FACTOR II: Environmental Situations");
		lblFactorIiEnvironmental.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Food/Nutrition", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblAssessmentType = new JLabel("Assessment Type");
		lblAssessmentType.setBounds(10, 11, 124, 14);
		panel.add(lblAssessmentType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 24, 189, 20);
		panel.add(comboBox);
		
		JLabel lblAssessmentDate = new JLabel("Assessment Date");
		lblAssessmentDate.setBounds(235, 11, 219, 14);
		panel.add(lblAssessmentDate);
		
		textField = new JTextField();
		textField.setBounds(233, 24, 180, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFoodProblemType = new JLabel("Food Problem Type");
		lblFoodProblemType.setBounds(10, 61, 155, 14);
		panel.add(lblFoodProblemType);
		
		JLabel lblSeverity = new JLabel("Severity");
		lblSeverity.setBounds(206, 60, 124, 14);
		panel.add(lblSeverity);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(367, 61, 124, 14);
		panel.add(lblDuration);
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setBounds(515, 62, 124, 14);
		panel.add(lblStrength);
		
		JLabel lblDiscriminationType = new JLabel("Discrimination Type");
		lblDiscriminationType.setBounds(664, 61, 170, 14);
		panel.add(lblDiscriminationType);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 80, 189, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(206, 80, 149, 20);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(367, 80, 134, 20);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(515, 80, 134, 20);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(662, 80, 203, 20);
		panel.add(comboBox_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 153, 414, 126);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(477, 153, 414, 126);
		panel.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(10, 317, 414, 126);
		panel.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(477, 317, 414, 126);
		panel.add(textArea_3);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setBounds(10, 134, 46, 14);
		panel.add(lblGoal);
		
		JLabel lblRecommendedIntervention = new JLabel("Recommended Intervention");
		lblRecommendedIntervention.setBounds(477, 134, 203, 14);
		panel.add(lblRecommendedIntervention);
		
		JLabel lblReferredTo = new JLabel("Referred To");
		lblReferredTo.setBounds(10, 300, 73, 14);
		panel.add(lblReferredTo);
		
		JLabel lblExpectedOutcome = new JLabel("Expected Outcome");
		lblExpectedOutcome.setBounds(477, 300, 203, 14);
		panel.add(lblExpectedOutcome);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(10, 457, 46, 14);
		panel.add(lblPriority);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(10, 471, 141, 20);
		panel.add(comboBox_6);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Shelter", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Assessment Type");
		label.setBounds(26, 24, 149, 14);
		panel_1.add(label);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(26, 37, 189, 20);
		panel_1.add(comboBox_7);
		
		JLabel label_1 = new JLabel("Assessment Date");
		label_1.setBounds(251, 24, 141, 14);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(249, 37, 180, 20);
		panel_1.add(textField_1);
		
		JLabel lblShelterProblemType = new JLabel("Shelter Problem Type");
		lblShelterProblemType.setBounds(25, 79, 180, 14);
		panel_1.add(lblShelterProblemType);
		
		JLabel label_3 = new JLabel("Severity");
		label_3.setBounds(222, 79, 106, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Duration");
		label_4.setBounds(383, 79, 100, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Strength");
		label_5.setBounds(531, 79, 106, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Discrimination Type");
		label_6.setBounds(678, 79, 170, 14);
		panel_1.add(label_6);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(26, 93, 189, 20);
		panel_1.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(222, 93, 149, 20);
		panel_1.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(383, 93, 134, 20);
		panel_1.add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(531, 93, 134, 20);
		panel_1.add(comboBox_11);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(678, 93, 203, 20);
		panel_1.add(comboBox_12);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(26, 166, 414, 126);
		panel_1.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(493, 166, 414, 126);
		panel_1.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(26, 330, 414, 126);
		panel_1.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(493, 330, 414, 126);
		panel_1.add(textArea_7);
		
		JLabel label_7 = new JLabel("Goal");
		label_7.setBounds(26, 147, 46, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Recommended Intervention");
		label_8.setBounds(493, 147, 203, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Referred To");
		label_9.setBounds(26, 313, 73, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("Expected Outcome");
		label_10.setBounds(493, 313, 106, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Priority");
		label_11.setBounds(26, 470, 46, 14);
		panel_1.add(label_11);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBounds(26, 484, 141, 20);
		panel_1.add(comboBox_13);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Employment", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("Assessment Type");
		label_2.setBounds(25, 11, 154, 14);
		panel_2.add(label_2);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setBounds(25, 24, 189, 20);
		panel_2.add(comboBox_14);
		
		JLabel label_12 = new JLabel("Assessment Date");
		label_12.setBounds(250, 11, 170, 14);
		panel_2.add(label_12);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(248, 24, 180, 20);
		panel_2.add(textField_2);
		
		JLabel lblWorkemploymentProblemType = new JLabel("Work/Employment Problem Type");
		lblWorkemploymentProblemType.setBounds(24, 66, 190, 14);
		panel_2.add(lblWorkemploymentProblemType);
		
		JLabel label_14 = new JLabel("Severity");
		label_14.setBounds(221, 66, 106, 14);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel("Duration");
		label_15.setBounds(382, 66, 96, 14);
		panel_2.add(label_15);
		
		JLabel label_16 = new JLabel("Strength");
		label_16.setBounds(530, 66, 111, 14);
		panel_2.add(label_16);
		
		JLabel label_17 = new JLabel("Discrimination Type");
		label_17.setBounds(677, 66, 170, 14);
		panel_2.add(label_17);
		
		JComboBox comboBox_15 = new JComboBox();
		comboBox_15.setBounds(25, 80, 189, 20);
		panel_2.add(comboBox_15);
		
		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setBounds(221, 80, 149, 20);
		panel_2.add(comboBox_16);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setBounds(382, 80, 134, 20);
		panel_2.add(comboBox_17);
		
		JComboBox comboBox_18 = new JComboBox();
		comboBox_18.setBounds(530, 80, 134, 20);
		panel_2.add(comboBox_18);
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setBounds(677, 80, 203, 20);
		panel_2.add(comboBox_19);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBounds(25, 153, 414, 126);
		panel_2.add(textArea_8);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setBounds(492, 153, 414, 126);
		panel_2.add(textArea_9);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setBounds(25, 317, 414, 126);
		panel_2.add(textArea_10);
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setBounds(492, 317, 414, 126);
		panel_2.add(textArea_11);
		
		JLabel label_18 = new JLabel("Goal");
		label_18.setBounds(25, 134, 46, 14);
		panel_2.add(label_18);
		
		JLabel label_19 = new JLabel("Recommended Intervention");
		label_19.setBounds(492, 134, 203, 14);
		panel_2.add(label_19);
		
		JLabel label_20 = new JLabel("Referred To");
		label_20.setBounds(25, 300, 73, 14);
		panel_2.add(label_20);
		
		JLabel label_21 = new JLabel("Expected Outcome");
		label_21.setBounds(492, 300, 106, 14);
		panel_2.add(label_21);
		
		JLabel label_22 = new JLabel("Priority");
		label_22.setBounds(25, 457, 46, 14);
		panel_2.add(label_22);
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setBounds(25, 471, 141, 20);
		panel_2.add(comboBox_20);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Economic Resources", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_13 = new JLabel("Assessment Type");
		label_13.setBounds(26, 11, 164, 14);
		panel_3.add(label_13);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setBounds(26, 24, 189, 20);
		panel_3.add(comboBox_21);
		
		JLabel label_23 = new JLabel("Assessment Date");
		label_23.setBounds(251, 11, 213, 14);
		panel_3.add(label_23);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(249, 24, 180, 20);
		panel_3.add(textField_3);
		
		JLabel lblEconomicResourcesProblem = new JLabel("Economic Resources Problem Type");
		lblEconomicResourcesProblem.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEconomicResourcesProblem.setBounds(25, 66, 187, 14);
		panel_3.add(lblEconomicResourcesProblem);
		
		JLabel label_25 = new JLabel("Severity");
		label_25.setBounds(222, 66, 46, 14);
		panel_3.add(label_25);
		
		JLabel label_26 = new JLabel("Duration");
		label_26.setBounds(383, 66, 118, 14);
		panel_3.add(label_26);
		
		JLabel label_27 = new JLabel("Strength");
		label_27.setBounds(531, 66, 100, 14);
		panel_3.add(label_27);
		
		JLabel label_28 = new JLabel("Discrimination Type");
		label_28.setBounds(678, 66, 170, 14);
		panel_3.add(label_28);
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setBounds(26, 80, 189, 20);
		panel_3.add(comboBox_22);
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setBounds(222, 80, 149, 20);
		panel_3.add(comboBox_23);
		
		JComboBox comboBox_24 = new JComboBox();
		comboBox_24.setBounds(383, 80, 134, 20);
		panel_3.add(comboBox_24);
		
		JComboBox comboBox_25 = new JComboBox();
		comboBox_25.setBounds(531, 80, 134, 20);
		panel_3.add(comboBox_25);
		
		JComboBox comboBox_26 = new JComboBox();
		comboBox_26.setBounds(678, 80, 203, 20);
		panel_3.add(comboBox_26);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setBounds(26, 153, 414, 126);
		panel_3.add(textArea_12);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setBounds(493, 153, 414, 126);
		panel_3.add(textArea_13);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setBounds(26, 317, 414, 126);
		panel_3.add(textArea_14);
		
		JTextArea textArea_15 = new JTextArea();
		textArea_15.setBounds(493, 317, 414, 126);
		panel_3.add(textArea_15);
		
		JLabel label_29 = new JLabel("Goal");
		label_29.setBounds(26, 134, 141, 14);
		panel_3.add(label_29);
		
		JLabel label_30 = new JLabel("Recommended Intervention");
		label_30.setBounds(493, 134, 203, 14);
		panel_3.add(label_30);
		
		JLabel label_31 = new JLabel("Referred To");
		label_31.setBounds(26, 300, 164, 14);
		panel_3.add(label_31);
		
		JLabel label_32 = new JLabel("Expected Outcome");
		label_32.setBounds(493, 300, 203, 14);
		panel_3.add(label_32);
		
		JLabel label_33 = new JLabel("Priority");
		label_33.setBounds(26, 457, 141, 14);
		panel_3.add(label_33);
		
		JComboBox comboBox_27 = new JComboBox();
		comboBox_27.setBounds(26, 471, 141, 20);
		panel_3.add(comboBox_27);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Transportation", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label_24 = new JLabel("Assessment Type");
		label_24.setBounds(25, 21, 189, 14);
		panel_4.add(label_24);
		
		JComboBox comboBox_28 = new JComboBox();
		comboBox_28.setBounds(25, 34, 189, 20);
		panel_4.add(comboBox_28);
		
		JLabel label_34 = new JLabel("Assessment Date");
		label_34.setBounds(250, 21, 178, 14);
		panel_4.add(label_34);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(248, 34, 180, 20);
		panel_4.add(textField_4);
		
		JLabel lblTransportationProblemType = new JLabel("Transportation Problem Type");
		lblTransportationProblemType.setBounds(24, 76, 223, 14);
		panel_4.add(lblTransportationProblemType);
		
		JLabel label_36 = new JLabel("Severity");
		label_36.setBounds(221, 76, 106, 14);
		panel_4.add(label_36);
		
		JLabel label_37 = new JLabel("Duration");
		label_37.setBounds(382, 76, 106, 14);
		panel_4.add(label_37);
		
		JLabel label_38 = new JLabel("Strength");
		label_38.setBounds(530, 76, 134, 14);
		panel_4.add(label_38);
		
		JLabel label_39 = new JLabel("Discrimination Type");
		label_39.setBounds(677, 76, 170, 14);
		panel_4.add(label_39);
		
		JComboBox comboBox_29 = new JComboBox();
		comboBox_29.setBounds(25, 90, 189, 20);
		panel_4.add(comboBox_29);
		
		JComboBox comboBox_30 = new JComboBox();
		comboBox_30.setBounds(221, 90, 149, 20);
		panel_4.add(comboBox_30);
		
		JComboBox comboBox_31 = new JComboBox();
		comboBox_31.setBounds(382, 90, 134, 20);
		panel_4.add(comboBox_31);
		
		JComboBox comboBox_32 = new JComboBox();
		comboBox_32.setBounds(530, 90, 134, 20);
		panel_4.add(comboBox_32);
		
		JComboBox comboBox_33 = new JComboBox();
		comboBox_33.setBounds(677, 90, 203, 20);
		panel_4.add(comboBox_33);
		
		JTextArea textArea_16 = new JTextArea();
		textArea_16.setBounds(25, 163, 414, 126);
		panel_4.add(textArea_16);
		
		JTextArea textArea_17 = new JTextArea();
		textArea_17.setBounds(492, 163, 414, 126);
		panel_4.add(textArea_17);
		
		JTextArea textArea_18 = new JTextArea();
		textArea_18.setBounds(25, 327, 414, 126);
		panel_4.add(textArea_18);
		
		JTextArea textArea_19 = new JTextArea();
		textArea_19.setBounds(492, 327, 414, 126);
		panel_4.add(textArea_19);
		
		JLabel label_40 = new JLabel("Goal");
		label_40.setBounds(25, 144, 178, 14);
		panel_4.add(label_40);
		
		JLabel label_41 = new JLabel("Recommended Intervention");
		label_41.setBounds(492, 144, 203, 14);
		panel_4.add(label_41);
		
		JLabel label_42 = new JLabel("Referred To");
		label_42.setBounds(25, 310, 222, 14);
		panel_4.add(label_42);
		
		JLabel label_43 = new JLabel("Expected Outcome");
		label_43.setBounds(492, 310, 247, 14);
		panel_4.add(label_43);
		
		JLabel label_44 = new JLabel("Priority");
		label_44.setBounds(25, 467, 141, 14);
		panel_4.add(label_44);
		
		JComboBox comboBox_34 = new JComboBox();
		comboBox_34.setBounds(25, 481, 141, 20);
		panel_4.add(comboBox_34);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(271)
					.addComponent(lblFactorIiEnvironmental, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblFactorIiEnvironmental)
					.addGap(8)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		
	}

}
