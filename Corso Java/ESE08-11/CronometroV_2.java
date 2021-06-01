import java.awt.event.ActionEvent;

public class CronometroV_2 extends Cronometro
{
	int centsPerTick;
	
	public CronometroV_2(int c) 
	{
		super();
		centsPerTick = c;
	}
	
	
	public void actionPerformed(ActionEvent e) // metodo dell'interfaccia
	{
		centSecondi += centsPerTick;
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

	
	public CronometroV_2() 
	{
		super();
		centsPerTick = 25;
	}
	
	public int getCentsPerTick() 
	{
		return centsPerTick;
	}
}
