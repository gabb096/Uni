/*
Creare una classe Eser05 con un main che genera un array di Dolci 
(scegliete voi le quantità di ciascuno purché ce ne sia almeno uno per tipo)
 e un ciclo che stampi tutti i toString() dei vari dolci
*/
public class Ese_05 
{

	public static void main(String [] args) 
	{

		String [] ingredienti = {"cioccolato", "Farina", "Uova", "Latte", "Vaniglia"};
		
		Dolce [] arrayDolci = {	new Merendina("Kinder Bueno","Kinder",1), 
								new Ciambellone("Ciambellone al cioccolato", ingredienti), 
								new Cioccolatino("cioccolatino al cioccolato","marconi",2,12)		};
		
		for(int i=0; i<arrayDolci.length;i++) 
		{
		
			System.out.println(""+ (i+1) + ") "+arrayDolci[i].toString());
		}
		
		

	}

}
