/*
 Creare una classe Incrocio che deve avere:
- un metodo generaTarga() che restituisce una stringa composta da "RM" seguita da 
tre cifre randomiche
- il main deve costurire due Queue di stringhe di nomi stradaA e stradaB 
e chiedere all'utente di inserire un numero compreso tra 5 e 10 
(controllando che sia effettivamente in queso range) ed eseguire il 
ciclo descritto qui di seguito un numero di volte pari al valore inserito dall'utente:
ogni iterazione del ciclo deve usare generaTarga() per generare un numero 
casuale di targhe (tra 3 e 5) e aggiugnerlo alla stradaA, stessa cosa per 
la stradaB (scegliendo un altro numero casuale tra 3 e 5), stampando di 
volta in volta a schermo una stringa composta da:
VALORETARGA + " si e' aggiunta alla coda sulla strada " + (A o B in base ai casi)
dopodiché dovrà rimuovere dalla stradaA un numero casuale di targhe (compreso tra 1 e 3)
 [ovviamente seguendo l'ordine della fila, la prima che arriva è la prima che se ne va],
  stessa cosa per la stradaB (scegliendo un altro numero casuale tra 1 e 3), 
  stampando di volta in volta a schermo una stringa composta da:
VALORETARGA + " esce dalla coda sulla strada " + (A o B in base ai casi)
Alla fine del ciclo dovrà per ciascuna delle due strade dovrà essere stampata la stringa
"Restano in fila sulla strada " + (A o B in base ai casi)
seguita dall'elenco delle targhe ancora in coda nella strada (rimuovendole di volta in volta)
*/
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_Ese_14 
{
	  static Random ran = new Random();
	  static Scanner key = new Scanner(System.in);

	  
	public static void main(String [] args) 
	  {
		  Queue<String> StradaA = new LinkedList<String>(); 
		  	
		  Queue<String> StradaB = new LinkedList<String>(); 
		  
		  Incrocio in = new Incrocio();
		  int ra, rb,ea,eb,n = 0;
		  while(n < 4 || n > 11)
		  {
		  System.out.println("Inserisci un numero tra 5 e 10");
		  n = key.nextInt();
		  if(n < 4 || n > 11)
			  System.out.println("NOPE\n");
		  }
		  
    System.out.println();
	  
		  for(int i=0; i<n;i++) 
		  {
			  ra = ran.nextInt(2)+3;
			  rb = ran.nextInt(2)+3;
			  ea = ran.nextInt(2)+1;
			  eb = ran.nextInt(2)+1;
			  
			  for(int j=0;j<ra;j++) 
			  {
				String s = in.generaTarga();
				StradaA.add(s);
				System.out.println(s+" si e' aggiunta alla coda sulla strada A");
			  }
			  
	 System.out.println();

			  for(int j=0;j<rb;j++) 
			  {
				String  s = in.generaTarga();
				StradaB.add(s);
				System.out.println(s+" si e' aggiunta alla coda sulla strada B");	
			  }
			  
	System.out.println();

			  for(int j=0;j<ea;j++) 
			  {
				  String s = StradaA.peek();
				  if(s!=null) 
				  {
					  System.out.println(s+" esce dalla coda sulla strada A");
					  StradaA.remove();
				  }
				  else
					  System.out.println("__ ___");
					  
			  }
			  
	System.out.println();

			  for(int j=0;j<eb;j++) 
			  {
				 String s = StradaB.peek();
				 if(s!=null) 
				  {
					  System.out.println(s+" esce dalla coda sulla strada B");
					  StradaB.remove();
				  }
				  else
					  System.out.println("__ ___");
			  }
			  
	System.out.println();

			  int max = StradaA.size();
			  
			  if(max<StradaB.size())
				  max=StradaB.size();
	System.out.println("STRADA A  |  STRADA B");
		  for(int r=0;r<max;r++) 
		  {
			String sa,sb;
			sa=StradaA.poll();
			sb=StradaB.poll();
			if(sa==null) 
				  sa ="__ ___";	
			if(sb==null) 
				  sb ="__ ___";
			System.out.println(sa+"\t  |\t"+sb);
			}
	  System.out.println();
	  System.out.println();
	  System.out.println();

		  }
	  
	  }	
}
