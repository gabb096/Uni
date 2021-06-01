/*
 Creare una classe RectKeyboardMover che estenda JFrame non ridimensionabile.
Il frame deve contenere un'istanza panel di una classe che estenda JPanel.
Tale panel deve poter ricevere il focus e avere un KeyListener.
Deve avere come variabile membro due rettangoli (non pannelli) 
di nome controlled e goal di dimensioni e coordinate di partenza 
diverse e a vostra scelta.
Deve disegnare su schermo i due rettangoli: controlled in ROSSO e goal in VERDE. 
Quando l'utente preme il tasto W (o la freccia SU) il rettangolo controlled dovrà 
spostarsi verso l'alto di un valore costante (a vostra scelta).
Stessa cosa dovrà avvenire nelle altre direzioni con i tasti A S D e le altre frecce 
(rispettivamente SINISTRA, GIU', DESTRA).
Se i due rettangoli si intersecano, la porzione di intersezione dovrà essere 
colorata di NERO.*/

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import javax.swing.*;


public class ESE43_RectKeyboardMover extends JFrame
{	
	
	
	class Pannello extends JPanel
	{
		Rectangle2D controlled,goal;
		
		public Pannello()
		{
			this.setLayout(null);
			this.setBounds(0,0,600,600);
			
			controlled = new Rectangle2D.Double(100,100,60,60);
			goal = new Rectangle2D.Double(350,350,70,70);

			
			this.addKeyListener(new KeyAdapter()
					
			{
				public void keyPressed(KeyEvent e) 
				{	 

					 switch(e.getKeyCode()) 
					{
					case KeyEvent.VK_UP : controlled.setFrame(controlled.getX(), controlled.getY() - 5, controlled.getWidth(), controlled.getHeight());
							break;
					case KeyEvent.VK_LEFT : controlled.setFrame(controlled.getX() - 5, controlled.getY(), controlled.getWidth(), controlled.getHeight());
							break;
					case KeyEvent.VK_RIGHT : controlled.setFrame(controlled.getX() + 5, controlled.getY(), controlled.getWidth(), controlled.getHeight());
							break;
					case KeyEvent.VK_DOWN : controlled.setFrame(controlled.getX(), controlled.getY() + 5, controlled.getWidth(), controlled.getHeight());
							break;
					default: 
						    break;		
					}
				repaint();
				}
					});
			}
		
		
		public void paintComponent(Graphics g)
		   {
			  super.paintComponent(g);
    	          
			  Rectangle2D intersectionRectangle = new Rectangle2D.Double();

		      Graphics2D g2 = (Graphics2D) g;

		      g2.setPaint(Color.GREEN);
		      g2.draw(controlled);
		      g2.setPaint(Color.GREEN);
		      g2.fill(controlled); 
		      
		      g2.setPaint(Color.RED);
		      g2.draw(goal);
		      g2.setPaint(Color.RED);
		      g2.fill(goal); 
		      
		      
		      if ( controlled.intersects(goal) )
		      	{
		          Rectangle2D.intersect( controlled, goal, intersectionRectangle);
		      	}
		      if ( intersectionRectangle.getWidth() > 0 && intersectionRectangle.getHeight() > 0 )
		      	{
		    	  	g2.setPaint( Color.BLACK );
		    	  	g2.fill( intersectionRectangle );
		      	}
		      
		      repaint();
		    }
	}
	
	public ESE43_RectKeyboardMover()
	{
		this.setVisible(true);
		this.setSize(600 , 600);
		this.setLocation(450,150);
		this.setLayout(null);
		this.setResizable(false);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pannello p = new Pannello();
		add(p);
		p.requestFocus();
		
	}
	
	public static void main(String [] a)
	{
		ESE43_RectKeyboardMover r = new ESE43_RectKeyboardMover();
	}
}
