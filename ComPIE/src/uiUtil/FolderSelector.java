package uiUtil;

import javax.swing.JFileChooser;

public class FolderSelector {

	public String getSelectedFolder() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Choose folder in which you want to generate the report");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		} else {
		}
		return chooser.getSelectedFile().toString();
	}

	public static void main(String s[]) {
		FolderSelector s1 = new FolderSelector();
		s1.getSelectedFolder();
	}

}
