package pages.helper;

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

import dao.Load_SocialRoles;
import dao.Load_Strength_Factor2;
import dao.Load_Strength_Factor3;
import dao.Load_Strength_Factor4;
import daoBean.MentalStatusProblemsBean;
import daoBean.SocialRoleProblems;
import daoBean.Strength_Factor2_Category;
import daoBean.Strength_Factor2_Problems;
import daoBean.Strength_Factor3;
import daoBean.Strength_Factor4;
import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MentalExamSmallPanel extends JPanel {

	private List<MentalStatusProblemsBean> menu;
	private JComboBox comboBox;

	private boolean hasToUpdate;
	/**
	 * @return the lblNewLabel
	 */
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	/**
	 * @param lblNewLabel the lblNewLabel to set
	 */
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	private JLabel lblNewLabel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	JList list;

	@SuppressWarnings("rawtypes")
	public MentalExamSmallPanel(List<MentalStatusProblemsBean> list2) {
		this.menu = list2;
		setBounds(10, 45, 680, 438);
		//setBounds(10, 45, 456, 265);
		JScrollPane scrollPane = new JScrollPane();
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHasToUpdate(true);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel = new JLabel("Risk Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		list = new JList();
		populateTab(list2);
		scrollPane.setViewportView(list);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(comboBox, 0, 159, Short.MAX_VALUE)
							.addGap(405))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
					.addGap(17))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addGap(11))
		);
		setLayout(groupLayout);

	}

	/**
	 * @return the comboBox
	 */
	public JComboBox getComboBox() {
		return comboBox;
	}

	/**
	 * @param comboBox the comboBox to set
	 */
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	private void populateTab(List<MentalStatusProblemsBean> panelName) {

		List<MentalStatusProblemsBean> list = panelName;
		int childHoodCount = 0;

		for (MentalStatusProblemsBean bean : list) {
			childHoodCount++;
		}
		int i = 0;
		int j = 0;
		CheckboxListItem[] items = new CheckboxListItem[childHoodCount];

		for (MentalStatusProblemsBean bean : list) {
			items[i] = new CheckboxListItem(bean.getItem());
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
	 * @param hasToUpdate
	 *            the hasToUpdate to set
	 */
	public void setHasToUpdate(boolean hasToUpdate) {
		this.hasToUpdate = hasToUpdate;
	}
}
