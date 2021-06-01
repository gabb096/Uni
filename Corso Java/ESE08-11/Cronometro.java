import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro implements ActionListener
{

	public int ore, minuti, secondi, centSecondi;
	
	public Cronometro() 
	{
		ore = 0;
		minuti = 0;
		secondi = 0;
		centSecondi = 0;
	}
	
	public void actionPerformed(ActionEvent e) // metodo dell'interfaccia
	{
		centSecondi += 25;
		if(centSecondi>99) 
		{
			centSecondi=0;
			secondi++;
		}
		if(secondi>59) 
		{
			secondi=0;
			minuti++;
		}
		if(minuti>59) 
		{
			minuti=0;
			ore++;
		}
		
		System.out.println("sono le "+ore+":"+minuti+":"+secondi+":"+centSecondi);
	}

	
}
