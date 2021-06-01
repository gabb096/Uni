/*
 Creare una classe Grattacielo che deve avere:
Un main che genera una Hashtable in cui le chiavi sono int e i valori sono stringhe,
 chiamandola piani (dove gli int rappresentano il numero del piano e le stringhe 
 cosa vi è contenuto, tipo uffici di questa o quella azienda, un ristorante, 
 una palestra, appartamenti, insomma quel che vi pare). 
 Al piano 0 deve esserci la "Hall".
Deve poi iniziare un ciclo che chiede all'utente il numero di quale piano vuole utilizzare, 
assicurandosi che il numero sia compreso tra 1 e 99.
Se il piano selezionato è 0, si esce dal ciclo.
Negli altri casi se il piano è vuoto (non c'è nessun elemento nell'Hashtable 
con la medesima chiave) allora viene chiesto all'utente con cosa vuole allestirlo 
ed inserire la stringa scritta dall'utente come valore della chiave del piano inserito.
Altrimenti si avverte l'utente del precedente allestimento 
(avvertendolo di cosa vi sia contenuto) e si chiede all'utente se vuole scambiare 
l'elemento attuale con un altro.
Se accetta, si dovrà sostituire quell'elemento con la stringa scritta dall'utente; 
inoltre si deve chiedere all'utente su quale piano vuole posizionare il precedente allestimento,
 se l'utente inserisce -1 quell'allestimento non verrà riposizionato. 
 Se inserisce un valore compreso tra 1 e 99 allora si deve controllare se il piano è vuoto,
  in tal caso si inserisce il nuovo elemento nella Hashtable, altrimenti... 
  (riprendere a leggere dall' altrimenti in rosso ).
Una volta concluso il ciclo si dovranno stampare tutti gli elementi del 
Grattacielo seguendo il formato
"Piano " + numero del piano + " : " + cosa è contenuto in quel piano
*/

import java.util.Hashtable;
import java.util.Scanner;
public class Main_Ese_15 
{

	public static void main(String [] args) 
	{
		Scanner key = new Scanner(System.in);
		Hashtable<Integer,String> piani = new Hashtable<Integer,String>();
		
		piani.put(0, "HALL");
		
		System.out.println("Abbiamo 99 piani");
		System.out.println("Quale vuoi occupare? premi 0 per uscire");
		int c = key.nextInt();
		
			
		while(c!=0) 
		{
			if(c<1 || c>99)
			{
			System.out.println("numero errato");
			c = key.nextInt();
			}
			
			if(piani.containsKey(c)) 
			{
				System.out.println("Il piano è gia occupato da "+ piani.get(c));
				System.out.println("Vogliamo cambiarlo con un altro negozio?");
				System.out.println("1 = si      0 = no");
				int t = key.nextInt();
				if(t == 1) 
				{
					String g = piani.get(c);
					System.out.println("Cosa ci mettiamo?");
					piani.put(c,  key.next());
					System.out.println("dove mettiamo "+ g +"?");
					System.out.println("inserisci -1 per non ricollocarlo");
					int p = key.nextInt();
					if(p == -1) 
					{
						System.out.println(g + " é stato eliminato");
					}
					else
						{
						System.out.println("a che piano lo spostiamo?");
						c = key.nextInt();
						piani.put(c, g);
						}
				}
				else
					System.out.println("Lasciamo così va");
			}
			else 
			{
				System.out.println("Cosa ci mettiamo?");
				piani.put(c, key.next());
			}
			System.out.println("ora  a che piano andimao? 0 per smettere");
			c = key.nextInt();
			
		}
	
		for(int i=0; i<100;i++) 
		{
			if(piani.get(i)==null)
			System.out.println("Piano : "+i+" contiene\t _________");
			else
				System.out.println("Piano : "+i+" contiene\t " +piani.get(i));

		}
	}
}
