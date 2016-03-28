package pages;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import dao.LoadTraumaHIstory;
import daoBean.TraumaBean;
import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;

public class CHDC extends JPanel {

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CHDC() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		JLabel lblFactorIiEnvironmental = new JLabel("Case History");
		lblFactorIiEnvironmental.setBounds(406, 11, 394, 25);
		lblFactorIiEnvironmental.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblFactorIiEnvironmental);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(66, 80, 384, 79);
		add(textArea);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(66, 200, 813, 51);
		add(textArea_3);

		JLabel lblNewLabel = new JLabel("Relevant History");
		lblNewLabel.setBounds(66, 60, 206, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Current Situation");
		lblNewLabel_1.setBounds(497, 60, 173, 14);
		add(lblNewLabel_1);

		JLabel lblTraumaHistory = new JLabel("Trauma History");
		lblTraumaHistory.setBounds(442, 262, 206, 14);
		add(lblTraumaHistory);

		JLabel lblReasonForReferral = new JLabel("Reason for Referral");
		lblReasonForReferral.setBounds(66, 185, 191, 14);
		add(lblReasonForReferral);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(497, 80, 384, 79);
		add(textArea_2);

		JLabel lblChildhood = new JLabel("Childhood");
		lblChildhood.setBounds(254, 284, 114, 14);
		add(lblChildhood);

		JLabel lblAdulthood = new JLabel("Adulthood");
		lblAdulthood.setBounds(664, 284, 114, 14);
		add(lblAdulthood);

		LoadTraumaHIstory history = new LoadTraumaHIstory();
		List<TraumaBean> list = history.getAllTraumaHistory();

		int childHoodCount = 0;
		int adulthoodCount = 0;

		for (TraumaBean bean : list) {
			if (bean.getCategory().equalsIgnoreCase("Childhood")) {
				childHoodCount++;
			}else{
				adulthoodCount++;
			}
		}
		int i = 0;
		int j=0;
		CheckboxListItem[] childhood = new CheckboxListItem[childHoodCount];
		CheckboxListItem[] adulthood = new CheckboxListItem[adulthoodCount];

		for (TraumaBean bean : list) {
			if (bean.getCategory().equalsIgnoreCase("Childhood")) {
				childhood[i] = new CheckboxListItem(bean.getItems());
				i++;
			}else{
				adulthood[j] = new CheckboxListItem(bean.getItems());
				j++;
			}
		}
		JList listx = new JList(childhood);
		listx.setCellRenderer(new CheckboxListRenderer());
		listx.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add a mouse listener to handle changing selection

		listx.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<CheckboxListItem> list = (JList<CheckboxListItem>) event.getSource();

				// Get index of item clicked

				int index = listx.locationToIndex(event.getPoint());
				CheckboxListItem item = (CheckboxListItem) list.getModel().getElementAt(index);

				// Toggle selected state

				item.setSelected(!item.isSelected());

				// Repaint cell

				listx.repaint(listx.getCellBounds(index, index));
			}
		});
		JList listy = new JList(adulthood);
		listy.setCellRenderer(new CheckboxListRenderer());
		listy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add a mouse listener to handle changing selection

		listy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				JList<CheckboxListItem> list = (JList<CheckboxListItem>) event.getSource();

				// Get index of item clicked

				int index = listy.locationToIndex(event.getPoint());
				CheckboxListItem item = (CheckboxListItem) list.getModel().getElementAt(index);

				// Toggle selected state

				item.setSelected(!item.isSelected());

				// Repaint cell

				listy.repaint(listy.getCellBounds(index, index));
			}
		});

		JScrollPane scrollPane = new JScrollPane(listx);
		scrollPane.setBounds(153, 309, 274, 237);
		add(scrollPane); // add(new JScrollPane(listx));
		
		JScrollPane scrollPane_1 = new JScrollPane(listy);
		scrollPane_1.setBounds(565, 309, 261, 237);
		add(scrollPane_1);

	}
}
