package pages;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dao.StrengthResourceManipulation;
import daoBean.StrengthAndResourcesBean;

public class StrengthAndResources extends JPanel {

	private int id;
	private int currentId = 0;
	private StrengthSmallPanel panel;
	private StrengthSmallPanel panel_1;
	private StrengthSmallPanel panel_2;
	private StrengthSmallPanel panel_3;
	private StrengthSmallPanel panel_4;
	private StrengthSmallPanel panel_5;
	private StrengthSmallPanel panel_6;
	private StrengthSmallPanel panel_7;
	private StrengthSmallPanel panel_8;
	private StrengthSmallPanel panel_9;
	private StrengthSmallPanel panel_10;
	private StrengthSmallPanel panel_11;

	/**
	 * Create the panel.
	 */
	public StrengthAndResources(int id) {
		this.id = id;
		setBounds(0, 11, 963, 609);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		panel = new StrengthSmallPanel("Family");
		tabbedPane.addTab("Family", null, panel, null);

		panel_1 = new StrengthSmallPanel("Occupational");
		tabbedPane.addTab("Occupational", null, panel_1, null);

		panel_2 = new StrengthSmallPanel("Other");
		tabbedPane.addTab("Other Interpersonal", null, panel_2, null);

		panel_3 = new StrengthSmallPanel("Special");
		tabbedPane.addTab("Special Life Situation", null, panel_3, null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

		panel_4 = new StrengthSmallPanel("Basic");
		tabbedPane_1.addTab("Basic Needs", null, panel_4, null);

		panel_5 = new StrengthSmallPanel("Health");
		tabbedPane_1.addTab("Health and Safety", null, panel_5, null);

		panel_6 = new StrengthSmallPanel("Education");
		tabbedPane_1.addTab("Education and Training", null, panel_6, null);

		panel_7 = new StrengthSmallPanel("Volunteer");
		tabbedPane_1.addTab("Volunteer Associations", null, panel_7, null);

		panel_8 = new StrengthSmallPanel("Judicial");
		tabbedPane_1.addTab("Judicial and Legal", null, panel_8, null);

		panel_9 = new StrengthSmallPanel("Affectional");
		tabbedPane_1.addTab("Affectional Support", null, panel_9, null);

		JLabel lblFactorI = new JLabel("Factor I - Social Relationships");

		JLabel lblFactorIi = new JLabel("Factor II - Environmental");

		JLabel lblFactorIii = new JLabel("Factor III - Mental Health Functioning");

		JLabel lblFactorIv = new JLabel("Factor IV - Physical Health Functioning ");

		panel_10 = new StrengthSmallPanel("factor3");

		panel_11 = new StrengthSmallPanel("factor4");
		populateValues();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
												.createSequentialGroup()
												.addComponent(lblFactorI, GroupLayout.DEFAULT_SIZE, 174,
														Short.MAX_VALUE)
												.addGap(300)
												.addComponent(lblFactorIi, GroupLayout.DEFAULT_SIZE, 179,
														Short.MAX_VALUE)
												.addGap(290))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
																454, Short.MAX_VALUE)
														.addGroup(groupLayout.createSequentialGroup().addGap(16)
																.addComponent(lblFactorIii, GroupLayout.DEFAULT_SIZE,
																		215, Short.MAX_VALUE)
																.addGap(223))
														.addComponent(panel_10, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGap(20)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 469,
																		Short.MAX_VALUE)
																.addGroup(groupLayout.createSequentialGroup().addGap(12)
																		.addComponent(lblFactorIv,
																				GroupLayout.DEFAULT_SIZE, 208,
																				Short.MAX_VALUE)
																		.addGap(249)))
														.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 469,
																Short.MAX_VALUE))))
										.addGap(10)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(25)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblFactorI)
								.addComponent(lblFactorIi))
						.addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE).addComponent(
										tabbedPane_1, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
						.addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblFactorIii)
								.addGroup(groupLayout.createSequentialGroup().addGap(13).addComponent(panel_10,
										GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addGap(13).addComponent(panel_11,
										GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
								.addComponent(lblFactorIv))
						.addGap(11)));
		setLayout(groupLayout);
	}

	public boolean hastoUpdate() {
		return (panel.isHasToUpdate() || panel_1.isHasToUpdate() || panel_2.isHasToUpdate() || panel_3.isHasToUpdate()
				|| panel_4.isHasToUpdate() || panel_5.isHasToUpdate() || panel_6.isHasToUpdate()
				|| panel_7.isHasToUpdate() || panel_10.isHasToUpdate() || panel_9.isHasToUpdate()
				|| panel_8.isHasToUpdate() || panel_11.isHasToUpdate());
	}

	public void settoUpdate(boolean flag) {
		panel.setHasToUpdate(flag);
		panel_1.setHasToUpdate(flag);
		panel_2.setHasToUpdate(flag);
		panel_3.setHasToUpdate(flag);
		panel_4.setHasToUpdate(flag);
		panel_5.setHasToUpdate(flag);
		panel_6.setHasToUpdate(flag);
		panel_7.setHasToUpdate(flag);
		panel_10.setHasToUpdate(flag);
		panel_9.setHasToUpdate(flag);
		panel_8.setHasToUpdate(flag);
		panel_11.setHasToUpdate(flag);
	}

	public StrengthAndResourcesBean getCurrentvalues() {

		StrengthAndResourcesBean bean = new StrengthAndResourcesBean();
		bean.setClientid(id);
		bean.setFactor1(getCurrentValuesFactor1());
		bean.setFactor2(getCurrentValuesFactor2());
		bean.setFactor3(panel_10.generateCurrentString());
		bean.setFactor4(panel_11.generateCurrentString());
		bean.setId(getCurrentId());
		return bean;
	}

	public void populateValues() {
		panel.setHasToUpdate(false);
		panel_1.setHasToUpdate(false);
		panel_2.setHasToUpdate(false);
		panel_3.setHasToUpdate(false);
		panel_4.setHasToUpdate(false);
		panel_5.setHasToUpdate(false);
		panel_6.setHasToUpdate(false);
		panel_7.setHasToUpdate(false);
		panel_8.setHasToUpdate(false);
		panel_9.setHasToUpdate(false);
		panel_10.setHasToUpdate(false);
		panel_11.setHasToUpdate(false);
		StrengthResourceManipulation manip = new StrengthResourceManipulation();
		StrengthAndResourcesBean bean = manip.getStrength(id);
		if (bean != null) {
			setCurrentId(bean.getId());
			populatefactor1(bean.getFactor1());
			populatefactor2(bean.getFactor2());
			panel_10.populatePage(bean.getFactor3());
			panel_11.populatePage(bean.getFactor4());
		}
	}

	private void populatefactor1(String factor1) {
		String[] splits = factor1.split(":");
		for (String split : splits) {
			String[] s = split.split("-");
			if (s.length > 1) {
				switch (s[0]) {
				case "Family":
					panel.populatePage(s[1]);
					break;
				case "Occupational":
					panel_1.populatePage(s[1]);
					break;
				case "Other":
					panel_2.populatePage(s[1]);
					break;
				case "Special":
					panel_3.populatePage(s[1]);
					break;
				}
			}
		}
	}

	private void populatefactor2(String factor2) {
		String[] splits = factor2.split(":");
		for (String split : splits) {
			String[] s = split.split("-");
			if (s.length > 1) {
				switch (s[0]) {
				case "Basic":
					panel_4.populatePage(s[1]);
					break;
				case "Health":
					panel_5.populatePage(s[1]);
					break;
				case "Education":
					panel_6.populatePage(s[1]);
					break;
				case "Volunteer":
					panel_7.populatePage(s[1]);
					break;
				case "Judicial":
					panel_8.populatePage(s[1]);
					break;
				case "Affectional":
					panel_9.populatePage(s[1]);
					break;
				}
			}
		}
	}

	private String getCurrentValuesFactor1() {
		StringBuffer sb = new StringBuffer();
		sb.append("Family-" + panel.generateCurrentString() + ":");
		sb.append("Occupational-" + panel_1.generateCurrentString() + ":");
		sb.append("Other-" + panel_2.generateCurrentString() + ":");
		sb.append("Special-" + panel_3.generateCurrentString() + "");
		return sb.toString();
	}

	private String getCurrentValuesFactor2() {
		StringBuffer sb = new StringBuffer();
		sb.append("Basic-" + panel_4.generateCurrentString() + ":");
		sb.append("Health-" + panel_5.generateCurrentString() + ":");
		sb.append("Education-" + panel_6.generateCurrentString() + ":");
		sb.append("Volunteer-" + panel_7.generateCurrentString() + ":");
		sb.append("Judicial-" + panel_8.generateCurrentString() + ":");
		sb.append("Affectional-" + panel_8.generateCurrentString() + "");
		return sb.toString();
	}

	/**
	 * @return the currentId
	 */
	public int getCurrentId() {
		return currentId;
	}

	/**
	 * @param currentId
	 *            the currentId to set
	 */
	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}

}
