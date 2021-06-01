/*Creare una classe Gestore che implementa ActionListener
- deve avere un campo di tipo DigitStamper di nome dstamper
- il metodo actionPerformed() deve richiamare i metodi Randomize() 
  e Stamp() dell'oggetto di tipo DigitStamper
- il costruttore deve inizializzare dstamper
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestore implements ActionListener
{
	DigitStamper dstamper;
	
	public Gestore() 
	{
		dstamper = new DigitStamper();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		dstamper.Randomize();
		dstamper.stamp();
		dstamper.maskedStamp('*');
	}

}
