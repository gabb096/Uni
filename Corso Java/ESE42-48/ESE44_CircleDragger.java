/*
Creare una classe CircleDragger che estenda JFrame non ridimensionabile.
Il frame deve contenere un'istanza panel di una classe che estenda JPanel.
Tale panel deve avere un MouseMotionListener.
Deve avere come variabile membro un rettangolo di nome goal di dimensioni 
e coordinate di partenza a vostra scelta.
Deve avere come variabile membro un cerchio di nome circle di dimensioni 
e coordinate di partenza a vostra scelta minori di goal.
Deve disegnare su schermo le due forme: circle in CIANO e goal in VERDE.
Quando l'utente muove il mouse le coordinate del mouse devono essere stampate 
sullo schermo seguite dalle distanze lungo i due assi tra il centro di circle 
e tali coordinate. Quando l'utente effettua un drag su circle (il punto deve 
essere contenuto in circle), circle segue il mouse centrandosi nelle coordinate 
della posizione del mouse.
Se goal contiene circle, lo sfondo dovrà essere colorato di BIANCO.

VARIANTE PRO: invece di risposizionare circle centrandolo nelle coordinate del mouse, 
mantenere l'offset di partenza (se l'utente inizia il movimento cliccando un punto 
diverso dal centro, la distanza tra il mouse e il centro del cerchio dovrà rimanere costante).
 */

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;

public class ESE44_CircleDragger extends JFrame
{
	
	class Pannello extends JPanel
	{
		Rectangle2D goal;
		Ellipse2D circle;
		
		public Pannello()
		{
			this.setLayout(null);
			this.setBounds(0,0,600,600);
			
			goal = new Rectangle2D.Double(50,50,160,160);
			circle = new Ellipse2D.Double(300,200,60,60);
			
			this.addMouseListener(new MouseAdapter() 
			{
				 public void mouseClicked(MouseEvent e)
		         {
					 if(circle.intersects(e.getPoint().getX(), e.getPoint().getY(), 10, 10)) 
					 {
						 circle.setFrame(e.getPoint().getX()-(circle.getWidth()/2), e.getPoint().getY()-(circle.getHeight()/2), circle.getWidth(), circle.getHeight());
					 }
				      repaint();
		         } 
				 
				 
			});
			
			this.addMouseMotionListener(new MouseAdapter()
					{
				public void mouseDragged(MouseEvent e)
		         {
					 if(circle.intersects(e.getPoint().getX(), e.getPoint().getY(), 10, 10)) 
					 {
						 
						 circle.setFrame(e.getX()-(circle.getWidth()/2), e.getY()-(circle.getHeight()/2), circle.getWidth(), circle.getHeight());
						 repaint();
					 }
				     

		         } 
				 public void mouseMoved(MouseEvent e) 
				 {
					 System.out.println(" asse x ["+e.getX()+"]");
					 System.out.println(" asse y ["+e.getY()+"]");
					 System.out.println("_______________________");
				 } 
					});
			
			
		}
		
		
		public void paintComponent(Graphics g)
		   {
			  super.paintComponent(g);
 	        
		      Graphics2D g2 = (Graphics2D) g;
    
		      g2.setPaint(Color.GREEN);
		      g2.draw(goal);
		      g2.setPaint(Color.GREEN);
		      g2.fill(goal); 
		      
		      g2.setPaint(Color.CYAN);
		      g2.draw(circle);
		      g2.setPaint(Color.CYAN);
		      g2.fill(circle); 
		      
		      
		      if ( circle.intersects(goal) )
		      	{
		          this.setBackground(Color.BLACK);
		      	}
		      else 
		    	  	this.setBackground(Color.WHITE);

		      
		      
		      
		      repaint();
		   }
		
	}
	
	
	public ESE44_CircleDragger() 
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
		ESE44_CircleDragger e = new ESE44_CircleDragger();
	}
}
