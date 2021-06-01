/*
Creare una classe SimpleEmojiBouncer che estenda 
JFrame non ridimensionabile.
Il frame deve contenere un'istanza panel di una 
classe che estenda JPanel.
Tale panel deve avere un Timer t.
Deve avere come variabile membro una SimpleEmoji di nome emoji 
di dimensioni a vostra scelta, situata nel quadrante in alto a 
sinistra dello schermo.
Deve disegnare a schermo la faccina.
Ad ogni tick del timer la faccina dovrà muoversi (richiamando 
il metodo move() ), rimbalzando quando tocca le pareti.
HINT: per gestire il rimbalzo seguire questo ragionamento.
Se il LATO DESTRO della faccina tocca o supera il LATO DESTRO 
del pannello, la componente X della sua direction dovrà assumere 
valore negativo.
Viceversa per i LATI SINISTRI, in tal caso dovrà assumere valore 
positivo. Applicare adeguatamente questo ragionamento alla componente Y.
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.Timer;

public class ESE47_SimpleEmojiBouncer extends JFrame
{

	class pannello extends JPanel
	{
		Timer t;
		ESE47_MovableSimpleEmoji emoji;
		
		public pannello() 
		{
			emoji = new ESE47_MovableSimpleEmoji(new Rectangle2D.Double(100,200,70,70));
			
			emoji.setDirection(new Point2D.Double(1,1) );
			emoji.setSpeed(10);
			t = new Timer(100,new ActionListener() 
			{
				public void actionPerformed( ActionEvent e) 
				{

					emoji.move();
				
			        if(emoji.face.getX() + emoji.face.getWidth() >= getContentPane().getWidth()) 
						emoji.setDirection(new Point2D.Double(-1,emoji.getDirection().getY() ) );
				else 
					if(emoji.face.getX() <= getContentPane().getX())
						emoji.setDirection(new Point2D.Double(1,emoji.getDirection().getY()));
				
					if(emoji.face.getY() + emoji.face.getHeight() >= getContentPane().getHeight()) 
						emoji.setDirection(new Point2D.Double(emoji.getDirection().getX(),-1));
				else 
					if(emoji.face.getY() <= getContentPane().getY())
						emoji.setDirection(new Point2D.Double(emoji.getDirection().getX(),1));

					repaint();
				}
			});
			
		}
		
		
		 public void paintComponent(Graphics g) 
		 {
			 super.paintComponent(g);
			 Graphics2D g2 = (Graphics2D)g;
			 emoji.draw(g2);
			 repaint();
		 }
		
	}
	
	public ESE47_SimpleEmojiBouncer() 
	{
		this.setVisible(true);
		this.setSize(600 , 600);
		this.setLocation(450,150);
		this.setLayout(null);
		this.setResizable(false);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pannello pan = new pannello();
		pan.setBounds(0, 0, 600, 600);
		pan.t.start();
		add(pan);
		validate();
		
	}
	
	public static void main(String [] a) 
	{
		ESE47_SimpleEmojiBouncer f = new ESE47_SimpleEmojiBouncer();
	}
}
