package pages;

import javax.swing.JPanel;

import dao.AdditionalNotesManipulation;
import daoBean.AdditionalNotesBean;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class AdditionalNotes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextArea textArea;

	private int id;

	private int current = 0;

	private boolean hastoUpdate;

	public AdditionalNotes(int id) {
		this.id = id;
		setBounds(0, 11, 982, 671);

		JLabel lblAdditionalNotes = new JLabel("Additional Notes");
		lblAdditionalNotes.setFont(new Font("Tahoma", Font.PLAIN, 18));

		textArea = new TextArea();
		textArea.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
				setHastoUpdate(true);
			}
		});

		populate();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(397).addComponent(lblAdditionalNotes,
								GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(textArea,
								GroupLayout.PREFERRED_SIZE, 954, Short.MAX_VALUE)))
				.addGap(14)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(28)
								.addComponent(lblAdditionalNotes, GroupLayout.PREFERRED_SIZE, 36,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(textArea, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
								.addGap(17)));
		setLayout(groupLayout);
	}

	/**
	 * 
	 */
	public void populate() {
		AdditionalNotesManipulation manip = new AdditionalNotesManipulation();
		AdditionalNotesBean bean = manip.getStrength(this.id);
		if (bean != null) {
			textArea.setText(bean.getProblemStr());
			this.current = bean.getId();
		}
		setHastoUpdate(false);
	}

	public AdditionalNotesBean getCurrentBean() {
		AdditionalNotesBean bean = new AdditionalNotesBean();
		bean.setClientId(this.id);
		bean.setId(this.current);
		bean.setProblemStr(textArea.getText());
		return bean;
	}

	/**
	 * @return the hastoUpdate
	 */
	public boolean isHastoUpdate() {
		return hastoUpdate;
	}

	/**
	 * @param hastoUpdate
	 *            the hastoUpdate to set
	 */
	public void setHastoUpdate(boolean hastoUpdate) {
		this.hastoUpdate = hastoUpdate;
	}

}
