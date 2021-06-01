import java.util.Scanner;
import java.util.Random;

public class Eser03 
{
	static Scanner key = new Scanner(System.in);
	
	public static int generaNumeroManuale() 
	{
		
		System.out.println("inserisci il numero che vuoi chiamare");
		int num = key.nextInt();
		return num;
	}
	
	public static int generaNumeroCasule() 
	{
		Random ran = new Random();
		
		int pre = ran.nextInt(3);
		int numero=0;
		switch(pre) 
		{
		case 0:  numero = 333*1000000+ran.nextInt(999999);
		System.out.println(+numero);
			break;
		case 1:  numero = 348*1000000+ran.nextInt(999999);
		System.out.println(numero);

			break;
		case 2:  numero = 389*1000000+ran.nextInt(999999);
		System.out.println(numero);

			break;
		}
		return numero;
	}

	public static void main(String [] args) 
	{
		Smartphone SM = new Smartphone("Moto", "Android",6.5,33);
		
		int cod=1;
		
		while(cod!=0)
		{
			System.out.println("premi 1 se vuoi fare 3 chiamate random");
			
			System.out.println("premi 2 se vuoi chiamare un numero manualmente");
			
			System.out.println("premi 3 per vedere le app installate");
			
			System.out.println("premi 4 per eliminare un app");
			
			System.out.println("premi 5 installare un app");
			
			System.out.println("premi 6 per vedere le ultime chiamate");
			
			System.out.println("premi 7 per vedere i numeri preferiti");
			
			System.out.println("premi 0 per uscire");
			
			cod = key.nextInt();
			
			switch (cod) 
			{
			case 1 : 
				SM.chiama(generaNumeroCasule());
				SM.chiama(generaNumeroCasule());
				SM.chiama(generaNumeroCasule());
				break;
			case 2 :
				SM.chiama(generaNumeroManuale());
				break;
			case 3 :
				System.out.println("ecco le tue app");
				SM.stampaApp(SM.apps);
				break;
			case 4 :
				System.out.println("quale app vuoi eliminare?");
				int g = key.nextInt();
				SM.eliminaApp(g);
				break;
			case 5 :
				System.out.println("quale app vuoi installare?");
				String s= key.nextLine();
				s= key.nextLine();
				SM.installaApp(s);
				break;
			case 6 :
				System.out.println("ecco le ultime chiamate");
				for(int i=0;i<SM.ultimeChiamate.length;i++) 
					{
					System.out.println(SM.getChiamataRecente(i));
					}
				break;
			case 7 :
				System.out.println("ecco i numeri preferiti");
				for(int i=0;i<SM.numeriPreferiti.length;i++) 
				{
					if(0!=SM.getNumeroPreferito(i)) 
					{
						System.out.println(SM.getNumeroPreferito(i));
					}
				}
				break;
			case 0 :
				System.out.println("Ciao Ciao");
				break;
			}
		}
	}
}
