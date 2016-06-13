package pages;

import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dao.Load_MentalStatus;
import dao.MentalStatusExamManipulation;
import daoBean.MentalStatusExamBean;
import daoBean.MentalStatusProblemsBean;
import daoBean.MentalStatus_Category;
import pages.helper.MentalExamSmallPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MSE extends JPanel {

	private int id;

	private int current = 0;

	private static final long serialVersionUID = 1L;

	private Map<String, MentalExamSmallPanel> li;

	@SuppressWarnings("unchecked")
	public MSE(int id) {
		this.id = id;
		setBounds(0, 11, 982, 671);

		JLabel lblMentalStatusExam = new JLabel("Mental Status Exam");
		lblMentalStatusExam.setFont(new Font("Tahoma", Font.PLAIN, 23));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(414)
					.addComponent(lblMentalStatusExam, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
					.addGap(341))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblMentalStatusExam, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
					.addGap(11))
		);
		setLayout(groupLayout);
		Load_MentalStatus mentalstatus = new Load_MentalStatus();
		List<MentalStatus_Category> list = mentalstatus.getAllMentalStatusProblemsByCategory();
		li = new HashMap<String, MentalExamSmallPanel>();

		for (MentalStatus_Category cat : list) {
			if (!cat.getCategory().trim().equalsIgnoreCase("RISK LEVEL")) {
				MentalExamSmallPanel panel = new MentalExamSmallPanel(cat.getItems());
				panel.getComboBox().setVisible(false);
				panel.getLblNewLabel().setVisible(false);
				tabbedPane.addTab(cat.getCategory(), null, panel, null);
				li.put(cat.getCategory(), panel);
				if (cat.getCategory().contains("RISK OF")) {
					for (MentalStatus_Category cat1 : list) {
						if (cat1.getCategory().trim().equalsIgnoreCase("RISK LEVEL")) {
							for (MentalStatusProblemsBean bean : cat1.getItems()) {
								panel.getComboBox().addItem(bean.getItem());
							}
						}
					}
					panel.getComboBox().setVisible(true);
					panel.getLblNewLabel().setVisible(true);
					repaint();
				}
			}
		}
		populateAllTabs();
	}

	public void populateAllTabs() {

		MentalStatusExamManipulation mani = new MentalStatusExamManipulation();
		MentalStatusExamBean bean = mani.getStrength(this.id);
		if (bean != null) {
			this.current = bean.getId();
			String test = bean.getProblemStr();
			String[] sp = test.split("#");
			for (String s : sp) {
				String[] ss = s.split("_");
				if (ss.length > 1) {
					if (ss[0].contains("RISK OF")) {
						String[] g = ss[1].split(":");
						li.get(ss[0]).populatePage(g[0]);
						li.get(ss[0]).getComboBox().setSelectedItem(g[1]);
					} else {
						li.get(ss[0]).populatePage(ss[1]);
					}
					li.get(ss[0]).setHasToUpdate(false);
				}
			}
			repaint();
		}
	}

	public boolean needsUpdate() {

		int count = 0;
		for (Map.Entry<String, MentalExamSmallPanel> entry : li.entrySet()) {
			if (li.get(entry.getKey()).isHasToUpdate()) {
				count++;
			}
		}
		return (count != 0);
	}

	public MentalStatusExamBean getCurrentBean() {
		MentalStatusExamBean bean = new MentalStatusExamBean();

		StringBuffer sb = new StringBuffer("");
		for (Map.Entry<String, MentalExamSmallPanel> entry : li.entrySet()) {
			if (entry.getKey().contains("RISK OF")) {
				sb.append(entry.getKey() + "_" + li.get(entry.getKey()).generateCurrentString() + ":"
						+ li.get(entry.getKey()).getComboBox().getSelectedItem().toString() + "#");
			} else {
				sb.append(entry.getKey() + "_" + li.get(entry.getKey()).generateCurrentString() + "#");
			}
		}
		String h = sb.toString();
		bean.setProblemStr(h.substring(0, (h.lastIndexOf('#') - 1)));
		bean.setClientId(this.id);
		bean.setId(this.current);
		return bean;
	}

}
