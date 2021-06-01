/*
Creare una classe TastierinoFlow che estenda JFrame.
Il frame deve avere come layout manager un FlowLayout centrato.
Il frame deve contenere 12 JButtons ed un JTextField 
(non editabile, inizialmente vuoto) posizionati come nell'immagine. 
I bottoni contenenti un numero aggiungono quel numero come ultimo valore 
del testo contenuto nel JTextField, il bottone "C" elimina l'ultimo carattere 
del testo del JTextField, il bottone "OK" stampa sul terminale il valore del testo 
JTextField e poi lo ripristina al valore iniziale "" (senza testo) .*/

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ESE29_TastierinoFlow extends JFrame
{
	JButton btn [] = new JButton [12] ;
	JTextField text = new JTextField("", 15);
		public ESE29_TastierinoFlow() 
		{
			super("TastierinoFlow");
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setSize(250 , 200);
			this.setLayout(new FlowLayout());
			
			text.setEditable(false);
			
			for(int i=0;i<12;i++)
			{
				if(i==9)
					{
					btn[i]= new JButton("C");
					btn[i].addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							text.setText(text.getText().substring(0, text.getText().length()-1));
						}
						});
					}
				else 
					if(i==11)
						{
						btn[i]= new JButton("OK");
						btn[i].addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								System.out.println(text.getText() );
							}
							});
						}
					else 
						if(i==10)
							{
							btn[i]= new JButton("0");
							btn[i].addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
								{
									text.setText(text.getText() + "0" );

								}
								});
							}
				else
					{
					btn[i]= new JButton(""+(i+1));
					int j = i;
					btn[i].addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							text.setText(text.getText() + btn[j].getText() );
						}
						});
					}
				
				this.add(btn[i]);
			}
			
			this.add(text);
		}

		
	public static void main(String [] args) 
	{
		ESE29_TastierinoFlow t = new ESE29_TastierinoFlow();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
