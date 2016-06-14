package pages.helper;

import chrriis.dj.nativeswing.NSOption;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Browser
{
  public Browser(final String file, final String name)
  {
    NativeInterface.open();
    try
    {
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run()
        {
          JWebBrowser fileBrowser = new JWebBrowser(new NSOption[0]);
          fileBrowser.setBarsVisible(false);
          fileBrowser.setStatusBarVisible(false);
          JFrame frame = new JFrame(name);
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          frame.setDefaultCloseOperation(2);
          frame.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
          frame.add(fileBrowser, "Center");
          fileBrowser.navigate(file + "#zoom=75");
          frame.setExtendedState(6);
          frame.setVisible(true);
          frame.addWindowListener(new WindowListener()
          {
            public void windowOpened(WindowEvent e) {}
            
            public void windowClosing(WindowEvent e) {}
            
            public void windowClosed(WindowEvent e) {}
            
            public void windowIconified(WindowEvent e) {}
            
            public void windowDeiconified(WindowEvent e) {}
            
            public void windowActivated(WindowEvent e) {}
            
            public void windowDeactivated(WindowEvent e) {}
          });
        }
      });
    }
    catch (Exception localException) {}
  }
  
  public static void main(String[] args) {}
}
