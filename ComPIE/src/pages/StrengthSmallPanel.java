package pages;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;

import javax.swing.JList;

public class StrengthSmallPanel extends JPanel {
	JList list;

	public StrengthSmallPanel() {
		setBounds(10, 45, 454, 264);

		list = new JList();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * @param adulthood
	 */
	private void populateAdulthood(CheckboxListItem[] adulthood) {
		list = new JList(adulthood);
		list.setCellRenderer(new CheckboxListRenderer());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add a mouse listener to handle changing selection

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
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

	private String generateCurrentString() {
		StringBuffer buffer = new StringBuffer();
		int size = list.getModel().getSize();
		for (int i = 0; i < size; i++) {
			if (((CheckboxListItem) list.getModel().getElementAt(i)).isSelected()) {
				buffer.append("1-" + i + ",");
			}
		}
		size = list.getModel().getSize();
		for (int i = 0; i < size; i++) {
			if (((CheckboxListItem) list.getModel().getElementAt(i)).isSelected()) {
				buffer.append("2-" + i + ",");
			}
		}
		return buffer.toString();
	}
}
