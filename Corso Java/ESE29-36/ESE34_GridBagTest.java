import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*Creare una classe GridBugTest che estenda JFrame.
Il frame deve avere come layout manager un GridBagLayout .
Le componenti da inserire sono le stesse dei due esercizi 
precedenti, ma questa volta la "cella" centrale dovrà essere vuota
 (o contenere un JPanel vuoto), il JTextField dovrà occupare due 
 colonne mentre il BottoneB dovrà occupare due righe.
*/
public class ESE34_GridBagTest extends JFrame // ESE 34
{
	
	GridBagLayout gbl;
	GridBagConstraints constraints;
	
	public ESE34_GridBagTest()
	{
		super("GridBagTest");
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(450 , 250);
		
		gbl = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		this.setLayout(gbl);
		
		constraints.gridx = 0; 
        constraints.gridy = 0; 
        add(new JButton("Bottone A"), constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 2; 
        constraints.gridy = 1; 
        constraints.gridheight = 2; 
        constraints.fill = GridBagConstraints.VERTICAL; 
        add(new JButton("Bottone B"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1; 
        constraints.gridy = 0; 
        add(new JLabel("Label 1"), constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 2; 
        constraints.gridy = 0; 
        add(new JLabel("Label 2"), constraints);
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0; 
        constraints.gridy = 1; 
        add(new JLabel("Label 3"), constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0; 
        constraints.gridy = 2; 
        constraints.gridwidth = 2; 
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(new JTextField("Testooo"), constraints);
        
        
        validate();
	}
	
	public static void main(String [] args) 
	{
		ESE34_GridBagTest b = new ESE34_GridBagTest();
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
