import java.util.ArrayList;
import java.util.Scanner;
public class Main_Ese_12 
{
	static Scanner key = new Scanner(System.in);
    static ArrayList<Dolce> lista = new ArrayList(); 

	public static void main(String [] args) 
	{
		boolean boo = true;
		
		String nome, marca;
		int prezzo, dimensione;
		
		while(boo)
		{
			System.out.println("Cosa vuoi fare?");
			System.out.println("0 per uscire");
			System.out.println("1 per inserire una Merendina");
			System.out.println("2 per inserire un Ciambellone ");
			System.out.println("3 per inserire un Cioccolatino ");
			System.out.println("4 per stampare tutta la lista");
			System.out.println("5 per stampare un solo oggetto della lista");
			System.out.println("6 per eliminare un oggetto dalla lista");
			int scelta = key.nextInt();


			switch(scelta)
			{
			case 0 : boo = false;
				break;
			case 1 :
				System.out.println("inserisci il nome della merendina");
				 nome = key.next();
				System.out.println("inserisci la marca della merendina");
				 marca = key.next();
				System.out.println("inserisci il prezzo della merendina");
				 prezzo = key.nextInt();
				aggiungi(new Merendina(nome, marca, prezzo));
				break;
			case 2 :
				System.out.println("inserisci il nome del ciambellone");
				 nome = key.next();
				System.out.println("quanti ingredienti ha il ciambellone?");
				 int n = key.nextInt();
				 System.out.println("inserisci gli ingredienti del ciambellone");
				String [] ingredienti = new String[n];
				 for(int i=0; i<n;i++) 
				 {
					 ingredienti[i]=key.next();
				 }
				 aggiungi(new Ciambellone(nome, ingredienti));
				break;
			case 3 :
				System.out.println("inserisci il nome del cioccolatino");
				 nome = key.next();
				System.out.println("inserisci la marca del cioccolatino");
				 marca = key.next();
				System.out.println("inserisci il prezzo della confezione");
				 prezzo = key.nextInt();
				 System.out.println("inserisci il numero di pezzi nella confezione");
				 dimensione = key.nextInt();
				 aggiungi(new Cioccolatino(nome, marca, prezzo,dimensione));
				break;
			case 4 :
				System.out.println("ecco la lista dei dolci");
				for (int i=0; i<lista.size();i++)
				{
					 System.out.println(i+") "+lista.get(i));
				}
				break;
			case 5 :
				System.out.println("quale indice vuoi stampare?");
				 int i = key.nextInt();
				 System.out.println(i+") "+lista.get(i));
				break;
			case 6 :
				System.out.println("quale dolce vuoi eliminare?");
				  i = key.nextInt();
				  lista.remove(i);
				System.out.println(i+") "+lista.get(i) +" eliminato!");
				break;
			default: 
				System.out.println("RITENTA");
				break;
			}
			
		
		}
	}	
	public static void aggiungi(Dolce e) 
	{
		boolean b = true;
		do 
		{
		System.out.println("Vuoi inserirlo alla fine? 1 = si , 0 = no ");
		 int n = key.nextInt();
		 if(n==1)
			 {
			 lista.add(e);
		     b = false;
			 }
		 	else if(n==0)
		 	{
		 		System.out.println("A quale indice vuoi inserire il dolce?");
		 		int i = key.nextInt();
		 		if(i>=lista.size()) 
		 		{
		 			System.out.println("Indice troppo grande!");
		 		}
		 		else
		 			{
		 			lista.remove(i);
		 			lista.add(i, e);
		 			b = false;
		 			}
		 	}
		} while(b);
	}

}

