import javax.swing.JFrame; 

public class WindowA extends JFrame
{

	public WindowA() 
	{
		super("Window A");
		int w=400,h=400;
		setSize(w,h);
		setLocationRelativeTo(null); // la posiziono al centro dello schermo
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
