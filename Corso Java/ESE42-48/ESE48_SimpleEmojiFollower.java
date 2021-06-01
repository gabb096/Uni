/*Creare una classe SimpleEmojiFollower che estenda JFrame non ridimensionabile.
Il frame deve contenere un'istanza panel di una classe che estenda JPanel.
Tale panel deve avere un Timer t e deve avere un MouseListener.
Deve avere come variabile membro una SimpleEmoji di nome emoji 
(di dimensioni e coordinate a vostra scelta) e una circonferenza di nome point 
(di dimensioni 2,2).
Il costruttore dovrà settare la direction di emoji con valore nullo e inizializzare 
point. Deve disegnare a schermo SOLO la faccina.
Quando l'utente clicca sul pannello, point dovrà essere posizionato nel punto del 
click e la direction di emoji dovrà essere settata in modo tale che punti in 
direzione del click.
Ad ogni tick del timer la faccina dovrà muoversi (richiamando il metodo move() ), 
settando la direction a valore nullo nel momento in cui il centro della faccina sia 
contenuto all'interno di point .*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;

import javax.swing.*;

public class ESE48_SimpleEmojiFollower extends JFrame
{
	
	class pannello extends JPanel
	{
		Timer t;
		ESE48_ExactMoveableSimpleEmoji emoji;
		Ellipse2D point;
		double dx,dy;
		float s;
		Rectangle2D rect;
		
		public pannello() 
		{
			emoji = new ESE48_ExactMoveableSimpleEmoji(new Rectangle2D.Double(100,200,70,70));
			point = new Ellipse2D.Double(emoji.face.getCenterX(),emoji.face.getCenterY(),3,3);
			t = new Timer(100,new ActionListener() 
			{
				public void actionPerformed( ActionEvent e) 
				{
					
					s = (float) (3*(emoji.face.getCenterX()-point.getCenterX())+(emoji.face.getCenterY()-point.getCenterY()));
				//	s = 3;
					
					dx = point.getCenterX() - emoji.face.getCenterX();
					dy = point.getCenterY() - emoji.face.getCenterY();
					
					dx = dx/Math.sqrt(dx*dx + dy*dy);
					dy = dy/Math.sqrt(dx*dx + dy*dy);
					
					emoji.setDirection(new Point2D.Double(dx,dy));
					
					emoji.setSpeed(s);
					rect = new Rectangle2D.Double(emoji.face.getCenterX(),emoji.face.getCenterY(),3,3);

					
					
					if(rect.intersects(new Rectangle2D.Double(point.getCenterX(),point.getCenterY(),1,1)))
						{
						emoji.setDirection(new Point2D.Double(0,0));
						}
					emoji.move();
						
					repaint();
				}
			});
			
			this.addMouseListener(new MouseAdapter() 
			{
				 public void mouseClicked(MouseEvent e) 
				 {
					point.setFrame(e.getX(), e.getY(), point.getWidth(), point.getHeight()); 
					System.out.println("X "+ point.getX() + " Y " +point.getY());
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
	
	
	public ESE48_SimpleEmojiFollower() 
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
		ESE48_SimpleEmojiFollower e = new ESE48_SimpleEmojiFollower();
	}
	
}
