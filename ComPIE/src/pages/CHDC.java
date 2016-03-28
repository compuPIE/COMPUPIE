package pages;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dao.CaseHistoryTableManipulation;
import dao.LoadTraumaHIstory;
import daoBean.CaseHistoryBean;
import daoBean.TraumaBean;
import uiUtil.CheckboxListItem;
import uiUtil.CheckboxListRenderer;

public class CHDC extends JPanel {

	private int clientId;
	private int caseHistoryId = -1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private JList listy;
	private JList listx;
	private JLabel lblAdulthood;
	private JLabel lblChildhood;
	private JTextArea textArea_2;
	private JLabel lblReasonForReferral;
	private JLabel lblTraumaHistory;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextArea textArea_3;
	private JTextArea textArea;
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
		setLayout(null);
		lblFactorIiEnvironmental = new JLabel("Case History");
		lblFactorIiEnvironmental.setBounds(406, 11, 394, 25);
		lblFactorIiEnvironmental.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblFactorIiEnvironmental);

		textArea = new JTextArea();
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    warn();
			  }

			  public void warn() {
				  setHasToUpdate(true);
			  }
			});
		textArea.setBounds(66, 80, 384, 79);
		add(textArea);

		textArea_3 = new JTextArea();
		textArea_3.setBounds(66, 200, 813, 51);
		textArea_3.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    warn();
			  }

			  public void warn() {
				  setHasToUpdate(true);
			  }
			});
		add(textArea_3);

		lblNewLabel = new JLabel("Relevant History");
		lblNewLabel.setBounds(66, 60, 206, 14);
		add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Current Situation");
		lblNewLabel_1.setBounds(497, 60, 173, 14);
		add(lblNewLabel_1);

		lblTraumaHistory = new JLabel("Trauma History");
		lblTraumaHistory.setBounds(442, 262, 206, 14);
		add(lblTraumaHistory);

		lblReasonForReferral = new JLabel("Reason for Referral");
		lblReasonForReferral.setBounds(66, 185, 191, 14);
		add(lblReasonForReferral);

		textArea_2 = new JTextArea();
		textArea_2.setBounds(497, 80, 384, 79);
		textArea_2.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    warn();
			  }

			  public void warn() {
				  setHasToUpdate(true);
			  }
			});
		add(textArea_2);

		lblChildhood = new JLabel("Childhood");
		lblChildhood.setBounds(254, 284, 114, 14);
		add(lblChildhood);

		lblAdulthood = new JLabel("Adulthood");
		lblAdulthood.setBounds(664, 284, 114, 14);
		add(lblAdulthood);

		populateTraumaHistory();
		populatePage();
		scrollPane = new JScrollPane(listx);
		scrollPane.setBounds(153, 309, 274, 237);
		add(scrollPane); // add(new JScrollPane(listx));
		
		scrollPane_1 = new JScrollPane(listy);
		scrollPane_1.setBounds(565, 309, 261, 237);
		add(scrollPane_1);

	}
	
	public void populatePage(){
		CaseHistoryTableManipulation dao = new CaseHistoryTableManipulation();
		List<CaseHistoryBean> list = dao.getCaseHistory(this.clientId);
		if(!list.isEmpty()){
		textArea_2.setText(list.get(0).getCurrentSituation());
		textArea_3.setText(list.get(0).getReasonForRefer());
		textArea.setText(list.get(0).getRelevantHistory());
		String[] splits = list.get(0).getTraumaHistory().split(",");
		for(String split : splits){
			String[] s = split.split("-");
			if(s[0].equalsIgnoreCase("1")){
				((CheckboxListItem)listx.getModel().getElementAt(Integer.parseInt(s[1]))).setSelected(true);;
			}else if(s[0].equalsIgnoreCase("2")){
				((CheckboxListItem)listy.getModel().getElementAt(Integer.parseInt(s[1]))).setSelected(true);;
			}
		}
		setCaseHistoryId(list.get(0).getId());
		}
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
		bean.setReasonForRefer(textArea_3.getText());
		bean.setRelevantHistory(textArea.getText());
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
				buffer.append("1-"+i+",");
			}
		}
		size = listx.getModel().getSize();
		for(int i=0; i<size;i++){
			if(((CheckboxListItem)listx.getModel().getElementAt(i)).isSelected()){
				buffer.append("2-"+i+",");
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

























