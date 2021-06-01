import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AsteriscoMobile implements ActionListener
{
	static int posizione,lunghezzaPercorso,movimento;
	
	public AsteriscoMobile() 
	{
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		move();
		draw();
	}
	
	public void draw() 
	{
		char[] p = new char[lunghezzaPercorso];
		System.out.print("[");

		for(int i=0;i<p.length; i++) 
		{
			if(i==posizione) 
				p[i]='*';
			else
				p[i]='_';
			System.out.print(p[i]);
		}
		System.out.println("]");

	}
	
	public void move() 
	{
		if(posizione==0 && movimento == -1)
			movimento=1;
		if(posizione==lunghezzaPercorso-1 && movimento==1)
			movimento=-1;
		
		posizione += movimento;

	}

	
	
	public static void main(String [] args) 
	{
		posizione = 0;
		lunghezzaPercorso = 20;
		movimento=1;
		Timer t = new Timer(250, new AsteriscoMobile());
		
		t.start();
		
		JOptionPane.showMessageDialog(null, "Chiudere il programma?");
		
		System.exit(0);
	}
	
}
