import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WindowB extends JFrame
{

	 Toolkit kit = Toolkit.getDefaultToolkit();
     Dimension screenSize = kit.getScreenSize(); //Prende le dimensioni dello schermo
     
	public WindowB() 
	{
		super("Window B");
		int w=400,h=400;
		setSize(w,h);
		int x = ( screenSize.width / 4 ) - ( w / 2 ) ;
	    int y = ( screenSize.height / 2 ) - ( h / 2 ) ;
	    setLocation(x,y); // la posiziono al centro della metà sinistra dello schermo
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // distrugge la finestra
	}
}
