package pages;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.FollowUpTableManipulation;
import daoBean.FollowUpBean;
import report.LongReport;
import report.ShortReport;
import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;

public class Report extends JPanel {
	private JList list;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private int id;
	
	private Component getThis(){
		return this;
	}

	public Report(int clientID) {
		this.id = clientID;
		setBounds(0, 11, 963, 609);
		setLayout(null);

		JLabel lblReport = new JLabel("Report Generation", SwingConstants.CENTER);
		lblReport.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));
		lblReport.setBounds(362, 32, 280, 40);
		add(lblReport);

		comboBox = new JComboBox();
		comboBox.setBounds(93, 177, 280, 31);
		comboBox.addItem("Short");
		comboBox.addItem("Long");
		comboBox.setSelectedItem("Short");
		add(comboBox);

		JLabel lblTypeOfReport = new JLabel("Type of Report");
		lblTypeOfReport.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));
		lblTypeOfReport.setBounds(96, 135, 158, 31);
		add(lblTypeOfReport);

		scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(471, 177, 412, 263);
		add(scrollPane);

		list = new JList();
		populateitems(false);
		scrollPane.setViewportView(list);

		JLabel lblChooseFollowups = new JLabel("Choose Follow-ups");
		lblChooseFollowups.setFont(new Font(CustomFontSize.FONT_TYPE, Font.PLAIN, CustomFontSize.FONT_SIZE));
		lblChooseFollowups.setBounds(471, 135, 171, 31);
		add(lblChooseFollowups);

		btnNewButton = new JButton("Select All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.getModel().getSize(); i++) {
					((CheckboxListItem) list.getModel().getElementAt(i)).setSelected(true);
				}
				repaint();
			}
		});
		btnNewButton.setBounds(695, 451, 89, 23);
		add(btnNewButton);

		btnNewButton_1 = new JButton("Generate Report");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> followupids = new ArrayList<Integer>();
				int size = list.getModel().getSize();
				for (int i = 0; i < size; i++) {
					if (((CheckboxListItem) list.getModel().getElementAt(i)).isSelected()) {
						followupids.add(Integer.parseInt((((CheckboxListItem) list.getModel().getElementAt(i)))
								.toString().split("-")[0].trim()));
					}
				}
				if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Short")){
					ShortReport sreport = new ShortReport();
					if(sreport.createShortAssessment(id, followupids)){
						JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(getThis()),
							    "Report Generated.");
					}else{
						JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(getThis()),
							    "Report Not Generated.");
					}
				}else{
					LongReport lreport = new LongReport();
					if(lreport.createlongAssessment(id, followupids)){
						JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(getThis()),
							    "Report Generated.");
					}else{
						JOptionPane.showMessageDialog((JFrame) SwingUtilities.getWindowAncestor(getThis()),
							    "Report Not Generated.");
					}
				}
			}
		});
		btnNewButton_1.setBounds(570, 502, 313, 55);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("Unselect All");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.getModel().getSize(); i++) {
					((CheckboxListItem) list.getModel().getElementAt(i)).setSelected(false);
				}
				repaint();
			}
		});
		btnNewButton_2.setBounds(794, 449, 89, 23);
		add(btnNewButton_2);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" }) void populateitems(boolean allSelected) {

		FollowUpTableManipulation followup = new FollowUpTableManipulation();
		List<FollowUpBean> listval = followup.getFollowUpInfo(this.id );
		CheckboxListItem[] items = new CheckboxListItem[listval.size()];
		int i = 0;
		for (FollowUpBean bean : listval) {
			if (bean.getStage() == 0)
				items[i] = new CheckboxListItem(bean.getId() + " - Initial on " + bean.getDate());
			else if (bean.getStage() == 1)
				items[i] = new CheckboxListItem(bean.getId() + " - FollowUp on " + bean.getDate());
			else if (bean.getStage() == 2)
				items[i] = new CheckboxListItem(bean.getId() + " - Closing FollowUp on " + bean.getDate());
			if (allSelected)
				items[i].setSelected(true);
			i++;
		}
		list = new JList(items);
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

}
