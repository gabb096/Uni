/*Creare una classe FocusablePanel che estenda JFrame non ridimensionabile.
Il frame deve contenere due Jpanels, uno verde e uno rosso che devono poter 
ricevere il focus, avere coordinate assolute (dimensioni a vostra scelta) 
e avere un KeyListener e un MouseListener ciascuno.
Il frame non deve avere alcun layout manager.
Il KeyListener del pannello verde deve riposizionare il pannello verde se 
l'utente preme le frecce direzionali, il KeyListener di quello blu farà la 
stessa cosa, spostando però quello blu. Il MouseListener del pannello verde 
dovrà far sì che se l'utente clicca su tale pannello esso richiederà il focus, 
stessa cosa vale per il pannello blu.*/

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;

public class ESE42_FocusablePanel extends JFrame
{
	JPanel Gpan,Bpan;
	
	 public class myKeyAdapter extends KeyAdapter
	{
		 public void keyPressed(KeyEvent e) 
			{	 
			 if(Bpan.hasFocus())
			 {
				 switch(e.getKeyCode()) 
				{
				case KeyEvent.VK_UP : Bpan.setLocation(Bpan.getX(), Bpan.getY()-10);
				break;
				case KeyEvent.VK_LEFT : Bpan.setLocation(Bpan.getX()-10, Bpan.getY());
						break;
				case KeyEvent.VK_RIGHT : Bpan.setLocation(Bpan.getX()+10, Bpan.getY());
						break;
				case KeyEvent.VK_DOWN : Bpan.setLocation(Bpan.getX(), Bpan.getY()+10);
						break;
				default:break;		
				}
			 validate();
			}
			 else if(Gpan.hasFocus())
				 {
				 switch(e.getKeyCode()) 
					{
					case KeyEvent.VK_UP : Gpan.setLocation(Gpan.getX(), Gpan.getY()-10);
					break;
					case KeyEvent.VK_LEFT : Gpan.setLocation(Gpan.getX()-10, Gpan.getY());
							break;
					case KeyEvent.VK_RIGHT : Gpan.setLocation(Gpan.getX()+10, Gpan.getY());
							break;
					case KeyEvent.VK_DOWN : Gpan.setLocation(Gpan.getX(), Gpan.getY()+10);
							break;
					default:break;		
					}
				}
				 validate();
			}
		 
	}
	 
	 myKeyAdapter ka = new myKeyAdapter();
	 
	public ESE42_FocusablePanel() 
	{
		super("FocusablePanel");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(500 , 400);
		this.setLocation(450,250);
		this.setLayout(null);
		this.setResizable(false);
		
		Gpan = new JPanel();
		Gpan.setBackground(Color.GREEN);
		Gpan.setBounds(this.getWidth()/2-150,this.getHeight()/2-50,50,50);
		Gpan.setFocusable(true);
		
		Gpan.addMouseListener(new MouseAdapter() 
		{
			public void  mouseClicked(MouseEvent e) 
			{
				Gpan.requestFocusInWindow();
			}
		});
		add(Gpan);
		
		Bpan = new JPanel();
		Bpan.setBackground(Color.BLUE);
		Bpan.setBounds(this.getWidth()/2+100,this.getHeight()/2-50,50,50);
		Bpan.setRequestFocusEnabled(true);
		Bpan.setFocusable(true);
		Bpan.addMouseListener(new MouseAdapter() 
		{
			public void  mouseClicked(MouseEvent e) 
			{
				Bpan.requestFocusInWindow();
			}
		});
		add(Bpan);
		
		
		Gpan.addKeyListener(ka);
		Bpan.addKeyListener(ka);
		
		
		
	}
	
	public static void main(String [] a) 
	{
		ESE42_FocusablePanel FP = new ESE42_FocusablePanel();
		FP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
