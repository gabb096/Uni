import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WindowC extends JFrame
{
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize(); //Prende le dimensioni dello schermo
    
	public WindowC() 
	{
		super("Window C");
		int w=400,h=400;
		setSize(w,h);
		int x = ( screenSize.width *3/ 4 ) - ( w / 2 ) ;
	    int y = ( screenSize.height / 2 ) - ( h / 2 ) ;
	    setLocation(x,y); // la posiziono al centro della metà destra dello schermo
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// non fa nulla
	}
}
