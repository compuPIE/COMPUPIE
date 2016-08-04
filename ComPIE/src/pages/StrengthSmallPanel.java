package pages;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import dao.Load_Strength_Factor2;
import dao.Load_Strength_Factor3;
import dao.Load_Strength_Factor4;
import dao.Load_strength_facor1;
import daoBean.SocialRoleProblems;
import daoBean.StrengthFactor1;
import daoBean.Strength_Factor2_Category;
import daoBean.Strength_Factor2_Problems;
import daoBean.Strength_Factor3;
import daoBean.Strength_Factor4;
import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;

public class StrengthSmallPanel extends JPanel {

	private String menu;
	
	private boolean hasToUpdate;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	JList list;

	@SuppressWarnings("rawtypes")
	public StrengthSmallPanel(String menu) {
		this.menu = menu;
		setBounds(10, 45, 454, 264);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
								.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
								.addContainerGap()));

		list = new JList();
		populateTab(menu);
		scrollPane.setViewportView(list);
		setLayout(groupLayout);

	}

	private void populateTab(String panelName) {

		String factor1 = "Strengths";
		String factor2 = "Basic,Health,Education,Volunteer,Judicial,Affectional";

		List<String> list = new ArrayList<String>();

		if (factor1.contains(panelName)) {
			Load_strength_facor1 roles = new Load_strength_facor1();
			List<StrengthFactor1> problems = null;
			switch (panelName) {
			case "Strengths":
				problems = roles.getAllStrength_Factor_1();
				break;
			}
			for (StrengthFactor1 prob : problems) {
				list.add(prob.getCategory());
			}
		} else if (factor2.contains(panelName)) {

			Load_Strength_Factor2 factor2meta = new Load_Strength_Factor2();
			List<Strength_Factor2_Category> problems = factor2meta.getAllProblemsByCategory();

			Strength_Factor2_Category problem = null;

			for (Strength_Factor2_Category probem : problems) {
				if (probem.getCategory().contains(panelName)) {
					problem = probem;
					break;
				}
			}
			for (Strength_Factor2_Problems prob : problem.getItems()) {
				list.add(prob.getItem());
			}
		} else if (panelName.equalsIgnoreCase("factor3")) {
			Load_Strength_Factor3 fac3 = new Load_Strength_Factor3();
			for (Strength_Factor3 bean : fac3.getAllStrength_Factor_3()) {
				list.add(bean.getCategory());
			}

		} else if (panelName.equalsIgnoreCase("factor4")) {
			Load_Strength_Factor4 fac3 = new Load_Strength_Factor4();
			for (Strength_Factor4 bean : fac3.getAllStrength_Factor4()) {
				list.add(bean.getCategory());
			}
		}

		int childHoodCount = 0;

		for (String bean : list) {
			childHoodCount++;
		}
		int i = 0;
		int j = 0;
		CheckboxListItem[] items = new CheckboxListItem[childHoodCount];

		for (String bean : list) {
			items[i] = new CheckboxListItem(bean);
			i++;
		}
		populateitems(items);
	}

	public void populatePage(String value) {
		if (value != null && !value.equalsIgnoreCase("")) {
			String[] splits = value.split(",");
			for (String split : splits) {
				if (split != null && !split.trim().equalsIgnoreCase("")) {
					for (int i = 0; i < list.getModel().getSize(); i++) {
						if (((CheckboxListItem) list.getModel().getElementAt(i)).toString().equalsIgnoreCase(split)) {
							((CheckboxListItem) list.getModel().getElementAt(i)).setSelected(true);
							;
						}
					}
				}
			}
		}
	}

	/**
	 * @param items
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void populateitems(CheckboxListItem[] items) {
		list = new JList(items);
		list.setCellRenderer(new CheckboxListRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add a mouse listener to handle changing selection

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				setHasToUpdate(true);
				JList<CheckboxListItem> list = (JList<CheckboxListItem>) event.getSource();

				// Get index of item clicked

				int index = list.locationToIndex(event.getPoint());
				CheckboxListItem item = (CheckboxListItem) list.getModel().getElementAt(index);

				// Toggle selected state

				item.setSelected(!item.isSelected());

				// Repaint cell

				list.repaint(list.getCellBounds(index, index));
			}
		});
	}

	public String generateCurrentString() {
		StringBuffer buffer = new StringBuffer();
		int size = list.getModel().getSize();
		for (int i = 0; i < size; i++) {
			if (((CheckboxListItem) list.getModel().getElementAt(i)).isSelected()) {
				buffer.append(((CheckboxListItem) list.getModel().getElementAt(i)).toString() + ",");
			}
		}
		return buffer.toString();
	}

	/**
	 * @return the hasToUpdate
	 */
	public boolean isHasToUpdate() {
		return hasToUpdate;
	}

	/**
	 * @param hasToUpdate the hasToUpdate to set
	 */
	public void setHasToUpdate(boolean hasToUpdate) {
		this.hasToUpdate = hasToUpdate;
	}
}
