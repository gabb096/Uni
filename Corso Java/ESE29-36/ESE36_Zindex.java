/*Creare una classe Zindex che estenda JFrame.
Il frame deve avere come layout manager un BorderLayout .
L'AREA CENTER deve contenere un LayeredPane largo quanto il frame, ma un po' meno alto 
(diciamo 50 pixel in meno). 
Chiameremo le dimensioni del LayeredPane N (larghezza) ed M (altezza).
Il LayeredPane dovrà contenere un JPanel con sfondo BIANCO di dimensioni N/2 , M/2 
posizionato (con coordinate assolute) nel quadrante in basso a sinistra del LayeredPane.
Il suo indice di profondità dovrà essere pari a 100.
L'AREA PAGE_END deve contenere un JButton ("Aggiungi Pannello") che una volta premuto 
aggiunga un nuovo pannello al LayeredPane.
Le dimensioni del pannello aggiunto dovranno essere uguali al pannello bianco, mentre 
il suo colore di sfondo dovrà essere casuale.
I pannelli di "indice" dispari dovranno essere spostati leggermente in basso a sinistra 
rispetto all'ultimo panello di "indice" dispari aggiunto (il primo avrà come riferimento 
il pannello bianco). Il loro indice di profondità dovrà essere sempre crescente, 
per garantire che coprano i pannelli vecchi.
I pannelli di "indice" pari dovranno essere spostati leggermente in alto a destra 
rispetto all'ultimo pannello di "indice" pari aggiunto (il primo avrà come riferimento 
il pannello bianco). Il loro indice di profondità dovrà essere sempre decrescente, per 
garantire che non coprano i pannelli vecchi.*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ESE36_Zindex extends JFrame
{
	JButton btn;
	JLayeredPane lp;
	JPanel pan, p;
	Random ran;
	static int i;
	public ESE36_Zindex() 
	{
		super("ZINDEXXXXXXX");
		this.setVisible(true);
		this.setSize(600 , 600);
		this.setLocation(450,150);
		
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		int N = this.getWidth(), M = this.getHeight();
		
		btn = new JButton("ADDA un pannello");
		lp = new JLayeredPane();
		lp.setSize(new Dimension(N,M-50));
		
		this.add(lp,BorderLayout.CENTER);
		
		pan = new JPanel();
		pan.setSize(new Dimension(N/2,M/2));
		pan.setBackground(Color.WHITE);
		
		int w = this.getWidth();
		int h = this.getHeight();
		
		pan.setBounds(0, M/2, N/2, M/2);
		lp.add(pan, Integer.valueOf(100));
		
		this.add(btn,BorderLayout.PAGE_END);
		
		ran = new Random();
		i=0;
		btn.addActionListener(new ActionListener()
				{
			
				public void actionPerformed(ActionEvent e) 
				{
				int r = ran.nextInt(256),
					g = ran.nextInt(256),
					b = ran.nextInt(256);
				
					p = new JPanel();
					p.setBackground(new Color(r,g,b));
					  i++;
					  
					if(i%2==0) 
						{
					   p.setBounds(0+(i*5), M/2-(i*5), N/2, M/2);
					   lp.add(p,  Integer.valueOf(100-i));
					   validate();
						}
					else 
						{
						p.setBounds(0-(i*5), M/2+(i*5), N/2, M/2);
						lp.add(p, Integer.valueOf(100+i));	
					    validate();
						}
					}
				});
	}
	
	public static void main(String [] args) 
	{
		ESE36_Zindex z = new ESE36_Zindex();
		z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
