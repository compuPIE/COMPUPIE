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

	/**
	 * Create the panel.
	 */
	public ClientInfo() {
		setBounds(0, 11, 982, 671);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 22, 961, 641);
		add(tabbedPane);
		
		JPanel panel = new ClientPage();
		tabbedPane.addTab("Client Info", null, panel, null);
		
		JPanel panel1 = new Factor1();
		tabbedPane.addTab("Factor 1", null, panel1, null);
		
		JPanel panel2 = new Factor2();
		tabbedPane.addTab("Factor 2", null, panel2, null);
		
		JPanel panel3 = new Factor3();
		tabbedPane.addTab("Factor 3", null, panel3, null);
		
		JPanel panel4 = new Factor4();
		tabbedPane.addTab("Factor 4", null, panel4, null);
		
		JPanel panel5 = new JPanel();
		tabbedPane.addTab("Factor 5", null, panel5, null);
		
		JPanel panel6 = new CHDC();
		tabbedPane.addTab("CHDC", null, panel6, null);
		
		JPanel panel7 = new StrengthAndResources();
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
}
