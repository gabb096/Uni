/*
 Creare una classe astratta Dolce
- deve avere due variabili stringa nome
- un metodo astratto descrizione() che restituirà una stringa
- un override del metodo toString() che restituisca una stringa contenente il nome 
- un costruttore che prenda in input una stringa e la assegni a nome
*/
 public abstract class Dolce 
{

	String nome;
	
	public abstract String descrizione(); 
	
	public abstract String toString();
	
	public Dolce(String n) 
	{
		this.nome = n;
	}
}