/*
Creare una classe PanelsMouseMover che estede JFrame, non ridimensionabile.
Il frame deve contenere due pannelli, uno blu e uno giallo, 
in posizioni assolute (il frame non deve avere alcun layout manager).
Quando l'utente muove il mouse, la coordinata del cursore deve essere 
stampata sul terminale.
Quando l'utente dragga il mouse, se lo sta facendo col tasto sinistro 
del mouse, il pannello blu deve riposizionarsi precisamente sotto il cursore; 
se invec il drag lo sta facendo col tasto destro del mouse sarà il pannello giallo 
a doversi riposizionare.
Se l'utente ruota la rotella del mouse mentre tiene premuto SHIFT, 
allora il pannello blu dovrà espandersi (o restringersi, se ruota nella 
direzione opposta) in tutte le direzioni.
Se invece ruota la rotella tenendo premuto CTRL, 
allora il pannello giallo dovrà espandersi 
(o restringersi, se ruota nella direzione opposta) in tutte le direzioni.
*/

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class ESE41_PanelsMouseMover extends JFrame
{
	JPanel Ypan, Bpan;
	
	public ESE41_PanelsMouseMover()
	{
		super("PanelsMouseMover");
		this.setVisible(true);
		this.setSize(600 , 600);
		this.setLocation(450,150);
		this.setLayout(null);
		this.setResizable(false);
		this.setFocusable(true);
		
		MouseAdapter ad = new MouseAdapter() 
		{
			
			 public void mouseClicked(MouseEvent e) 
	            {
				 if(e.getButton() == MouseEvent.BUTTON1) 
				 {
					 Bpan.setBounds(e.getX()-Bpan.getWidth()/2, e.getY()-Bpan.getHeight(), Bpan.getWidth(), Bpan.getHeight());
					 validate();
				 }
				 
				 if(e.getButton() == MouseEvent.BUTTON3) 
				 {
					 Ypan.setBounds(e.getX()-Ypan.getWidth()/2, e.getY()-Ypan.getHeight(), Ypan.getWidth(), Ypan.getHeight());
					 validate();
				 }
	            }
			
			 public void mouseWheelMoved(MouseWheelEvent e)
	         {
	               
	                	int a = e.getWheelRotation();

	                 if ( e.isControlDown() ) 
	                 {
	             		Ypan.setBounds(Ypan.getX()-a/2, Ypan.getY()-a/2, Ypan.getWidth()+a, Ypan.getHeight()+a);
	             		validate();
	                 }
	                 if ( e.isShiftDown() ) 
	                 {
		             	Bpan.setBounds(Bpan.getX()-a/2, Bpan.getY()-a/2, Bpan.getWidth()+a, Bpan.getHeight()+a);
		             	validate();
	                 }
	                
	         }
			 
			 public void mouseDragged(MouseEvent e)
	         {

				 if(e.getButton() == MouseEvent.BUTTON1) 
				 {
					 Bpan.setBounds(e.getX()-Bpan.getWidth()/2, e.getY()-Bpan.getHeight(), Bpan.getWidth(), Bpan.getHeight());
					 validate();
				 }
				 
				 if(e.getButton() == MouseEvent.BUTTON3) 
				 {
					 Ypan.setBounds(e.getX()-Ypan.getWidth()/2, e.getY()-Ypan.getHeight(), Ypan.getWidth(), Ypan.getHeight());
					 validate();
				 }
				 
	         }
		};
		
		
		Ypan = new JPanel();
		Ypan.setBackground(Color.YELLOW);
		Ypan.setBounds(this.getWidth()/2-100, this.getHeight()/2 -50, 50, 50);
		
		Bpan = new JPanel();
		Bpan.setBackground(Color.BLUE);
		Bpan.setBounds(this.getWidth()/2+100, this.getHeight()/2-50, 50, 50);
		
		add(Ypan);
		add(Bpan);
		
		this.addMouseListener(ad);
		this.addMouseWheelListener(ad);
		this.addMouseMotionListener(ad);

		validate();
		
		
	}
	
	public static void main(String [] args)
	{
		ESE41_PanelsMouseMover pmm = new ESE41_PanelsMouseMover();
		pmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
