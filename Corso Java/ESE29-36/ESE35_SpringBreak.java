/*Creare una classe SpringBreak che estenda JFrame.
Il frame deve avere come layout manager un SpringLayout .
Esso dovrà contenere quattro JTextField (vuoti, di 20 colonne ciascuno) 
ordinati come rappresentato nella seguente immagine.
(da notare che il lato basso -SOUTH- del TextField in basso a sinistra, 
e' a distanza zero del lato alto -NORTH- del TextField in basso a destra)*/

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ESE35_SpringBreak extends JFrame //ESE35
{
	JTextField t1, t2, t3, t4;
	
	public ESE35_SpringBreak() 
	{
		super("SpringBreak");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(600 , 250);
		SpringLayout sp = new SpringLayout();
		this.setLayout(sp);
		
		t1 = new JTextField("TEXT 1", 20);
		t2 = new JTextField("TEXT 2", 20);
		t3 = new JTextField("TEXT 3", 20);
		t4 = new JTextField("TEXT 4", 20);
        		
		sp.putConstraint(SpringLayout.WEST, t1, 5 , SpringLayout.WEST, getContentPane());
		sp.putConstraint(SpringLayout.NORTH, t1, 5 , SpringLayout.NORTH, getContentPane());
		
		sp.putConstraint( SpringLayout.EAST, t2, -5, SpringLayout.EAST, getContentPane());
		sp.putConstraint(SpringLayout.NORTH, t2, 5 , SpringLayout.SOUTH, t1);
		sp.putConstraint(SpringLayout.WEST, t2, 5 , SpringLayout.EAST, t1);
		
		sp.putConstraint(SpringLayout.EAST, getContentPane(), 5 , SpringLayout.EAST, t4);
		sp.putConstraint(SpringLayout.NORTH, t3, 20 , SpringLayout.SOUTH, t2);
		sp.putConstraint(SpringLayout.WEST, t4, 5 , SpringLayout.EAST, t3);
		
	/*	sp.putConstraint(SpringLayout.WEST, t2, 0, SpringLayout.WEST, t4);
		sp.putConstraint(SpringLayout.EAST, t2, 0, SpringLayout.EAST, t4);
		sp.putConstraint(SpringLayout.EAST, t1, 0, SpringLayout.EAST, t3);
		sp.putConstraint(SpringLayout.WEST, t1, 0, SpringLayout.WEST, t3);*/


	    sp.putConstraint(SpringLayout.WEST, t3, 5, SpringLayout.WEST, getContentPane());
		sp.putConstraint(SpringLayout.NORTH, t4, 1 , SpringLayout.SOUTH, t3);
		

		
		add(t1);
		add(t2);
		add(t4);
		add(t3);
		
		validate();
	}
	
	public static void main(String [] args) 
	{
		ESE35_SpringBreak sb = new ESE35_SpringBreak();
		sb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
