package pages.helper;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Main extends JFrame
{
    JPanel red = new ColorPanel(Color.red,300,300);
    JPanel grn = new ColorPanel(Color.green,100,300);
     
    public Main()
    {
        RelativeLayout rl = new RelativeLayout(RelativeLayout.X_AXIS, 10);
        JPanel panel = new JPanel( rl );
        panel.add(red, new Float(1));
        panel.add(grn);
         
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.pack();
    }
     
     
    public static void main(String[] args)
    {
        new Main();
    }
}
 
 
class ColorPanel extends JPanel
{
    public ColorPanel(Color color, int W, int H)
    {
        this.setBackground(color);
        this.setPreferredSize(new Dimension(W,H));
    }
}