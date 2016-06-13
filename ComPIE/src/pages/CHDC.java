package pages;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import dao.CaseHistoryTableManipulation;
import dao.LoadTraumaHIstory;
import daoBean.CaseHistoryBean;
import daoBean.TraumaBean;
import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;

public class CHDC extends JPanel {

	public int clientId;
	private int caseHistoryId = -1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JList listy;
	private JList listx;
	private JLabel lblAdulthood;
	private JLabel lblChildhood;
	private TextArea textArea_2;
	private JLabel lblReasonForReferral;
	private JLabel lblTraumaHistory;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private TextArea textArea_3;
	private TextArea textArea;
	private JLabel lblFactorIiEnvironmental;
	private boolean hasToUpdate;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CHDC(int clientId) {
		 setHasToUpdate(false);
		this.clientId = clientId;
		setBounds(0, 11, 963, 609);
		lblFactorIiEnvironmental = new JLabel("Case History");
		lblFactorIiEnvironmental.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textArea = new TextArea();
		textArea.setForeground(Color.BLACK); 
		textArea.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
				setHasToUpdate(true);
			}
		});
		

		textArea_3 = new TextArea("",20,250,TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea_3.setColumns(10);
		textArea_3.setForeground(Color.BLACK); 

		textArea_3.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
				setHasToUpdate(true);
			}
		});

		lblNewLabel = new JLabel("Reason for Referral");

		lblNewLabel_1 = new JLabel("Current Situation");

		lblTraumaHistory = new JLabel("Trauma History");
		lblTraumaHistory.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblReasonForReferral = new JLabel("Relevant History");

		textArea_2 = new TextArea();
		textArea_2.setForeground(Color.BLACK); 

		textArea_2.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
				setHasToUpdate(true);
			}
		});

		lblChildhood = new JLabel("Childhood");

		lblAdulthood = new JLabel("Adulthood");

		populateTraumaHistory();
		populatePage();
		scrollPane = new JScrollPane(listx);
		
		scrollPane_1 = new JScrollPane(listy);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addGap(149)
							.addComponent(lblFactorIiEnvironmental, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
							.addGap(293))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
							.addGap(47)
							.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
							.addGap(82))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblReasonForReferral, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
							.addGap(706))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblChildhood)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAdulthood, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
									.addGap(82))
								.addComponent(lblTraumaHistory, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea_3, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
							.addGap(84))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFactorIiEnvironmental, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textArea_2, 0, 0, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(lblReasonForReferral)
					.addGap(1)
					.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblTraumaHistory)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChildhood)
						.addComponent(lblAdulthood))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
					.addGap(18))
		);
		setLayout(groupLayout);

	}
	
	public void populatePage(){
		CaseHistoryTableManipulation dao = new CaseHistoryTableManipulation();
		List<CaseHistoryBean> list = dao.getCaseHistory(this.clientId);
		if(!list.isEmpty()){
		textArea_2.setText(list.get(0).getCurrentSituation());
		textArea_3.setText(list.get(0).getRelevantHistory());
		textArea.setText(list.get(0).getReasonForRefer());
		String[] splits = list.get(0).getTraumaHistory().split(",");
		for(String split : splits){
			String[] s = split.split("-");
			if(s[0].equalsIgnoreCase("childhood")){
				for (int i = 0; i < listx.getModel().getSize(); i++) {
					if (((CheckboxListItem) listx.getModel().getElementAt(i)).toString().equalsIgnoreCase(s[1])) {
						((CheckboxListItem) listx.getModel().getElementAt(i)).setSelected(true);
					}
				}
			}else if(s[0].equalsIgnoreCase("adulthood")){
				for (int i = 0; i < listy.getModel().getSize(); i++) {
					if (((CheckboxListItem) listy.getModel().getElementAt(i)).toString().equalsIgnoreCase(s[1])) {
						((CheckboxListItem) listy.getModel().getElementAt(i)).setSelected(true);
					}
				}
			}
		}
		setCaseHistoryId(list.get(0).getId());
		}
		setHasToUpdate(false);
	}

	/**
	 * 
	 */
	private void populateTraumaHistory() {
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
		populateChildHood(childhood);
		populateAdulthood(adulthood);
	}

	/**
	 * @param adulthood
	 */
	private void populateAdulthood(CheckboxListItem[] adulthood) {
		listy = new JList(adulthood);
		listy.setCellRenderer(new CheckboxListRenderer());
		listy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add a mouse listener to handle changing selection

		listy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				setHasToUpdate(true);
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
	}

	/**
	 * @param childhood
	 */
	private void populateChildHood(CheckboxListItem[] childhood) {
		listx = new JList(childhood);
		listx.setCellRenderer(new CheckboxListRenderer());
		listx.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add a mouse listener to handle changing selection

		listx.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				setHasToUpdate(true);
				JList<CheckboxListItem> list = (JList<CheckboxListItem>) event.getSource();

				int index = listx.locationToIndex(event.getPoint());
				CheckboxListItem item = (CheckboxListItem) list.getModel().getElementAt(index);

				// Toggle selected state

				item.setSelected(!item.isSelected());

				// Repaint cell

				listx.repaint(listx.getCellBounds(index, index));
			}
		});
	}
	
	public CaseHistoryBean getCurrentValues(){
		CaseHistoryBean bean = new CaseHistoryBean();
		bean.setCurrentSituation(textArea_2.getText());
		bean.setReasonForRefer(textArea.getText());
		bean.setRelevantHistory(textArea_3.getText());
		bean.setTraumaHistory(generateTraumaHistoryString());
		bean.setClientId(this.clientId);
		bean.setId(this.caseHistoryId);
		return bean;
	}
	
	private String generateTraumaHistoryString(){
		StringBuffer buffer = new StringBuffer();
		int size = listx.getModel().getSize();
		for(int i=0; i<size;i++){
			if(((CheckboxListItem)listx.getModel().getElementAt(i)).isSelected()){
				buffer.append("childhood-"+listx.getModel().getElementAt(i).toString()+",");
			}
		}
		size = listx.getModel().getSize();
		for(int i=0; i<size;i++){
			if(((CheckboxListItem)listy.getModel().getElementAt(i)).isSelected()){
				buffer.append("adulthood-"+listy.getModel().getElementAt(i).toString()+",");
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

	/**
	 * @return the caseHistoryId
	 */
	public int getCaseHistoryId() {
		return caseHistoryId;
	}

	/**
	 * @param caseHistoryId the caseHistoryId to set
	 */
	public void setCaseHistoryId(int caseHistoryId) {
		this.caseHistoryId = caseHistoryId;
	}
}

























