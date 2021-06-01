/*
 Creare una classe CenterCard che estenda JFrame.
Il frame deve avere come layout manager un BorderLayout.
Nell'area PAGE_START dovrà esserci una JLabel con testo "Visualizzatore Foto".
Nell'area CENTER dovrà esserci un JPanel con un layout manager di tipo CardLayout
 contenente N carte (scegliete voi quante) ciascuna contenente un'immagine.
Nell'area PAGE_END dovrà esserci un JButton con testo "Cambia Foto" 
che farà cambiare la foto visualizzata dal CardLayout.*/

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ESE31_CenterCard extends JFrame
{
	int n=1;
	
		public ESE31_CenterCard() 
		{
		super("CenterCard");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(450 , 450);
		this.setLayout(new BorderLayout());
		
		this.add(new JLabel("Visualizzatore Foto"), BorderLayout.PAGE_START);
		
		CardLayout layout = new CardLayout();
		JPanel panel = new JPanel(layout);
		
		for (int i = 1; i < 6; i++) 
		{
	         JPanel p = new JPanel();
	         p.add(new JLabel(new ImageIcon(getClass().getResource("img" + i + ".jpg"))));
	         panel.add(p, "img" + i);
		}
		
			JButton btn = new JButton("Cambia Foto");
			
		
			
			btn.addActionListener(new ActionListener() 
			{
				
				
				public void actionPerformed(ActionEvent e)
				{
					if(n>5)
					 n=1;
					
					layout.show(panel,"img"+n);
		            n++;
		            validate();
				}
			});
			
			this.add(panel, BorderLayout.CENTER);
		this.add(btn, BorderLayout.PAGE_END);
		 validate();
		}
		
		public static void main(String [] args) 
		{
			ESE31_CenterCard c = new ESE31_CenterCard();
			c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
