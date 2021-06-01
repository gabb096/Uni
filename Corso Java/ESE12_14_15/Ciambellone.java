/*
 Creare una classe Ciambellone che estende Dolce
- deve avere un'array di stringhe ingredienti
- deve implementare descrizione() in modo tale che restituisca una stringa contenente il nome seguito 
dall'elenco dei suoi ingredienti (possibilmente ogni ingrediente su una riga diversa)
- deve fare un override del metodo toString() in modo tale che restituisca la stringa generata dal metodo descrizione()
- deve avere un costruttore che prenda in input una stringa e un array di stringhe, 
richiami il costruttore della classe madre e assegni l'altra variabile

*/
public class Ciambellone extends Dolce
{
	
	String [] ingredienti;
	
	public Ciambellone(String n, String[] ing)
	{
		super(n);
		ingredienti=ing;
	}
	
	public String descrizione() 
	{
		String s = "La ciambellone è fatto con : \n";
		for(int i=0; i<ingredienti.length;i++) 
		{
			s += ingredienti[i]+"\n";
		}
		return s;
	}

	
	public String toString() 
	{
		return descrizione();
	}
 
}
