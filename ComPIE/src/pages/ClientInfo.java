package pages;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ClientInfo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientPage panel;
	private CHDC panel6;
	private Factor1 panel1;
	private FactorII panel2;
	private FactorIII panel3;
	private FactorIV panel4;
	private StrengthAndResources panel7;
	private Report panel8;

	/**
	 * Create the panel.
	 */
	public ClientInfo(int id) {
		setBounds(0, 11, 982, 671);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		 panel = new ClientPage(id);
		 tabbedPane.addTab("Client Info", null, panel, null);
		 
		  panel6 = new CHDC(id);
		  tabbedPane.addTab("Case History", null, panel6, null);
		  
		   panel1 = new Factor1(id);
		   tabbedPane.addTab("Factor 1", null, panel1, null);
		   
		    panel2 = new FactorII(id);
		    tabbedPane.addTab("Factor 2", null, panel2, null);
		    
		     panel3 = new FactorIII(id);
		     tabbedPane.addTab("Factor 3", null, panel3, null);
		     
		      panel4 = new FactorIV(id);
		      tabbedPane.addTab("Factor 4", null, panel4, null);
		      
		       
		       
		       
		        panel7 = new StrengthAndResources(id);
		        tabbedPane.addTab("Strength and Resources", null, panel7, null);
		        
		        panel8 = new Report(id);
		        tabbedPane.addTab("Report", null, panel8, null);
		        GroupLayout groupLayout = new GroupLayout(this);
		        groupLayout.setHorizontalGroup(
		        	groupLayout.createParallelGroup(Alignment.LEADING)
		        		.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        );
		        groupLayout.setVerticalGroup(
		        	groupLayout.createParallelGroup(Alignment.LEADING)
		        		.addGroup(groupLayout.createSequentialGroup()
		        			.addGap(26)
		        			.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		        );
		        setLayout(groupLayout);
	}

		
	/**
	 * @return the panel
	 */
	public ClientPage getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(ClientPage panel) {
		this.panel = panel;
	}

	/**
	 * @return the panel6
	 */
	public CHDC getPanel6() {
		return panel6;
	}

	/**
	 * @param panel6 the panel6 to set
	 */
	public void setPanel6(CHDC panel6) {
		this.panel6 = panel6;
	}

	/**
	 * @return the panel1
	 */
	public Factor1 getPanel1() {
		return panel1;
	}

	/**
	 * @param panel1 the panel1 to set
	 */
	public void setPanel1(Factor1 panel1) {
		this.panel1 = panel1;
	}

	/**
	 * @return the panel2
	 */
	public FactorII getPanel2() {
		return panel2;
	}

	/**
	 * @param panel2 the panel2 to set
	 */
	public void setPanelII(FactorII panel2) {
		this.panel2 = panel2;
	}

	/**
	 * @return the panel3
	 */
	public FactorIII getPanel3() {
		return panel3;
	}

	/**
	 * @param panel3 the panel3 to set
	 */
	public void setPanel3(FactorIII panel3) {
		this.panel3 = panel3;
	}

	/**
	 * @return the panel4
	 */
	public FactorIV getPanel4() {
		return panel4;
	}

	/**
	 * @param panel4 the panel4 to set
	 */
	public void setPanel4(FactorIV panel4) {
		this.panel4 = panel4;
	}

	/**
	 * @return the panel7
	 */
	public StrengthAndResources getPanel7() {
		return panel7;
	}

	/**
	 * @param panel7 the panel7 to set
	 */
	public void setPanel7(StrengthAndResources panel7) {
		this.panel7 = panel7;
	}

	/**
	 * @return the panel8
	 */
	public Report getPanel8() {
		return panel8;
	}

	/**
	 * @param panel8 the panel8 to set
	 */
	public void setPanel8(Report panel8) {
		this.panel8 = panel8;
	}
}
