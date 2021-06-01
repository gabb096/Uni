/*Creare una classe SimpleEmojiColorChanger che estenda JFrame 
non ridimensionabile.
Il frame deve contenere un'istanza panel di una classe che estenda JPanel.
Tale panel deve avere un MouseWheelListener.
Deve avere come variabile membro una SimpleEmoji 
di nome emoji centrata al centro del pannello.
Deve avere come variabile membro anche un array 
di colori ( NERO, ROSSO, VERDE, BLU, CIANO, MAGENTA, GIALLO).
Deve disegnare a schermo la faccina.
Quando l'utente muove la rotella del mouse, 
un altro colore dell'array deve essere selezionato 
ed assegnato alla faccina come colore degli occhi.*/

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.*;
import javax.swing.*;

 public class ESE45_SimpleEmojiColorChanger extends JFrame
 {
	 
	 class pannello extends JPanel
	 {
		 ESE45_SimpleEmoji emoji;
		 
		 Color colors [] = { Color.black,Color.blue,Color.cyan, Color.red, Color.green,Color.magenta,Color.yellow };
		 
		 public pannello() 
		 { 
			 emoji = new ESE45_SimpleEmoji(new Rectangle2D.Double(0,0,200,150) );
			 
			 this.addMouseWheelListener(new MouseAdapter() 
			 {
				 int i=0;
				 
				 public void mouseWheelMoved(MouseWheelEvent e)
		         {
					 
					  
		                 if ( e.getWheelRotation()>0) 
		                 {
		                	 	i++;
		                 }
		                 if ( e.getWheelRotation()<0 ) 
		                 {
			             	i--;
		                 }
		                 if(i>6) 
								i=0;
		                 else if(i<0)
		                	 	i=6;
		                 emoji.setEyeColor(colors[i]);
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
	 
	public ESE45_SimpleEmojiColorChanger()
	{
		this.setVisible(true);
		this.setSize(600 , 600);
		this.setLocation(450,150);
		this.setLayout(null);
		this.setResizable(false);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pannello p = new pannello();
		p.setBounds(200, 200, 200, 200);
		add(p);
		p.requestFocus();
	}
	
	public static void main(String [] a) 
	{
		ESE45_SimpleEmojiColorChanger r = new ESE45_SimpleEmojiColorChanger();
	}
 }
