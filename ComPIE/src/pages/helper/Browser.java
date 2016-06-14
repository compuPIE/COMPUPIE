package pages.helper;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class Browser {

	public Browser(String file, String name) {
		NativeInterface.open(); // not sure what else may be needed for this
		try{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JWebBrowser fileBrowser = new JWebBrowser();
				fileBrowser.setBarsVisible(false);
				fileBrowser.setStatusBarVisible(false);
				JFrame frame = new JFrame(name);
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
				frame.add(fileBrowser, BorderLayout.CENTER);
				fileBrowser.navigate(file + "#zoom=75");
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				frame.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
					}

					@Override
					public void windowClosing(WindowEvent e) {
						// window is being closed
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// window is closed
					}

					@Override
					public void windowIconified(WindowEvent e) {
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
					}

				});

			}
		});
		}catch(Exception e){
			
		}

	}

	public static void main(String[] args) {
		// System.out.println(System.getProperty("user.dir"));
		// Browser bro = new
		// Browser(System.getProperty("user.dir")+"/resources/History_of_PIE_System.pdf");

	}
}
