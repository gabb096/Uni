/*Creare una classe SimpleEmojiTeleporter che estenda JFrame 
non ridimensionabile.
Il frame deve contenere un'istanza panel di una classe che estenda JPanel.
Tale panel deve avere un MouseListener.
Deve avere come variabile membro una SimpleEmoji 
di nome emoji centrata al centro del pannello.
Deve disegnare a schermo la faccina.
Quando l'utente clicca col mouse, la faccina dovrà 
essere riposizionata centrandola nel punto in cui il mouse 
è stato cliccato. Se il click è avvenuto col tasto sinistro la 
faccina dovrà essere GIALLA con occhi NERI, se il click è avvenuto 
col tasto destro la faccina dovrà essere VERDE con gli occhi ROSSI, 
se il click è avvenuto col tasto centrale la faccina dovrà essere NERA 
con gli occhi BIANCHI.*/

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.*;
import javax.swing.*;


public class ESE46_SimpleEmojiTeleporter extends JFrame
{
	
	
	public ESE46_SimpleEmojiTeleporter()
	{
		this.setVisible(true);
		this.setSize(600 , 600);
		this.setLocation(450,150);
		this.setLayout(null);
		this.setResizable(false);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pannello p = new pannello();
		p.setBounds(0, 0, 600, 600);
		add(p);
		p.requestFocus();
		
		
	}
	
	class pannello  extends JPanel
	{
		ESE45_SimpleEmoji emoji;
		
		public pannello() 
		{

			int w = 100, h=100;
		emoji = new ESE46_ReframeableSimpleEmoji(new Rectangle2D.Double(110,110,w,h) );

		 this.addMouseListener(new MouseAdapter() 
		 {			 
			 public void mouseClicked(MouseEvent e)
	         {
				 if(e.getButton() == MouseEvent.BUTTON1) 
				 {
					 emoji = new ESE46_ReframeableSimpleEmoji(new Rectangle2D.Double(e.getX()-w/2,e.getY()-h/2,w,h) );
					 emoji.setEyeColor(Color.BLACK);
					 emoji.setFaceColor(Color.YELLOW);
				 }
				 else 
					 if(e.getButton() == MouseEvent.BUTTON3) 
					 {
						 emoji = new ESE46_ReframeableSimpleEmoji(new Rectangle2D.Double(e.getX()-w/2,e.getY()-h/2,w,h) );
						 emoji.setEyeColor(Color.GREEN);
						 emoji.setFaceColor(Color.RED);
					 }
		
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
		
	
	public static void main(String [] a) 
	{
		ESE46_SimpleEmojiTeleporter r = new ESE46_SimpleEmojiTeleporter();
	}
}
