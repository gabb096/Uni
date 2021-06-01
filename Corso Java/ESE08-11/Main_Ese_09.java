
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Scanner;

public class Main_Ese_09 
{
	public static void main(String [] args) 
	{
		Scanner key = new Scanner(System.in);
		
		System.out.println("inserisci il tempo del primo cronometro");
		int a1= key.nextInt();
		
		System.out.println("inserisci il tempo del secondo cronometro");
		int a2= key.nextInt();
		
		System.out.println("inserisci il tempo del terzo cronometro");
		int a3= key.nextInt();
		
		Timer t1 = new Timer(a1*10,new CronometroV_2(a1));
		Timer t2 = new Timer(a2*10,new CronometroV_2(a2));
		Timer t3 = new Timer(a3*10,new CronometroV_2(a3));
		
		t1.start();
		t2.start();
		t3.start();
		
		JOptionPane.showMessageDialog(null, "OH!");
		System.exit(0);


	}

}
