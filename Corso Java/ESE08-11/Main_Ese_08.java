
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Main_Ese_08 
{

	public static void main(String [] args) 
	{
		Timer t = new Timer(250, new Cronometro());
		
		t.start();
		
		JOptionPane.showMessageDialog(null, "Chiudere il programma?");
		
		System.exit(0);
	}
	
	
}
