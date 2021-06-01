/*
 Creare una classe MainClass contenente il metodo main che inizializza 
 un oggetto di tipo Gestore ed un Timer (intervallo a vostra scelta) 
 che abbia Gestore come suo ActionListener, infine il main deve creare un 
 JOptionPane (come negli esempi della scorsa lezione) per non far chiudere 
 instantaneamente il programma.*/

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Main_Ese_11 
{
	public static void main(String [] args) 
	{
		Timer t = new Timer(1000,  new Gestore());
		t.start();
		
		JOptionPane.showMessageDialog(null, "OH!");
		System.exit(0);
	}
}
