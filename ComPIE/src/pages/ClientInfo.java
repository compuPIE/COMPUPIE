package pages;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientInfo extends JPanel {

	private ClientPage panel;
	private CHDC panel6;
	private Factor1 panel1;
	private Factor2 panel2;
	private Factor3 panel3;
	private Factor4 panel4;
	private JPanel panel5;
	private StrengthAndResources panel7;

	/**
	 * Create the panel.
	 */
	public ClientInfo() {
		setBounds(0, 11, 982, 671);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 22, 961, 641);
		add(tabbedPane);
		
		 panel = new ClientPage();
		tabbedPane.addTab("Client Info", null, panel, null);
		
		 panel6 = new CHDC(1);
		tabbedPane.addTab("Case History", null, panel6, null);
		
		 panel1 = new Factor1(1);
		tabbedPane.addTab("Factor 1", null, panel1, null);
		
		 panel2 = new Factor2();
		tabbedPane.addTab("Factor 2", null, panel2, null);
		
		 panel3 = new Factor3();
		tabbedPane.addTab("Factor 3", null, panel3, null);
		
		 panel4 = new Factor4();
		tabbedPane.addTab("Factor 4", null, panel4, null);
		
		 panel5 = new JPanel();
		tabbedPane.addTab("Factor 5", null, panel5, null);
		
		
		 panel7 = new StrengthAndResources();
		tabbedPane.addTab("Strength and Resources", null, panel7, null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 97, 21);
		add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mnFile.add(mntmSearch);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnFile.add(mntmDelete);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Reports");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Generate a PIE Assessment Summary");
		mnNewMenu.add(mntmNewMenuItem_1);
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
	public Factor2 getPanel2() {
		return panel2;
	}

	/**
	 * @param panel2 the panel2 to set
	 */
	public void setPanel2(Factor2 panel2) {
		this.panel2 = panel2;
	}

	/**
	 * @return the panel3
	 */
	public Factor3 getPanel3() {
		return panel3;
	}

	/**
	 * @param panel3 the panel3 to set
	 */
	public void setPanel3(Factor3 panel3) {
		this.panel3 = panel3;
	}

	/**
	 * @return the panel4
	 */
	public Factor4 getPanel4() {
		return panel4;
	}

	/**
	 * @param panel4 the panel4 to set
	 */
	public void setPanel4(Factor4 panel4) {
		this.panel4 = panel4;
	}

	/**
	 * @return the panel5
	 */
	public JPanel getPanel5() {
		return panel5;
	}

	/**
	 * @param panel5 the panel5 to set
	 */
	public void setPanel5(JPanel panel5) {
		this.panel5 = panel5;
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
}
