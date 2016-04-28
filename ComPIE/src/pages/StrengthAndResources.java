package pages;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JLabel;

public class StrengthAndResources extends JPanel {

	/**
	 * Create the panel.
	 */
	public StrengthAndResources() {
		setBounds(0, 11, 963, 609);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 45, 454, 264);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Family", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Occupational", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Other Interpersonal", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Special Life Situation", null, panel_3, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(484, 45, 469, 264);
		add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Basic Needs", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Health and Safety", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Education and Training", null, panel_6, null);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Volunteer Associations", null, panel_7, null);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_1.addTab("Judicial and Legal", null, panel_8, null);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("Affectional Support", null, panel_9, null);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 345, 454, 253);
		add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(484, 345, 469, 253);
		add(scrollPane_1);
		
		JLabel lblFactorI = new JLabel("Factor I - Social Relationships");
		lblFactorI.setBounds(10, 32, 174, 14);
		add(lblFactorI);
		
		JLabel lblFactorIi = new JLabel("FACTOR II - Environmental");
		lblFactorIi.setBounds(484, 32, 179, 14);
		add(lblFactorIi);
		
		JLabel lblFactorIii = new JLabel("FACTOR III - Mental Health Functioning");
		lblFactorIii.setBounds(10, 332, 215, 14);
		add(lblFactorIii);
		
		JLabel lblFactorIv = new JLabel("Factor IV - Physical Health Functioning ");
		lblFactorIv.setBounds(484, 332, 208, 14);
		add(lblFactorIv);
	}
}
