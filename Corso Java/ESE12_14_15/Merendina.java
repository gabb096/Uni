/*
 Creare una classe Merendina che estende Dolce
- deve avere una variabile stringa marca e una int prezzo
- deve implementare descrizione() in modo tale da farsi restituire una stringa contenente il nome, 
  la marca e il prezzo della Merendina
- deve fare un override del metodo toString() in modo tale che restituisca la stringa generata dal metodo descrizione()
- deve avere un costruttore che prenda in input due stringhe e un intero, richiami il costruttore della classe madre e 
  assegni le altre due variabili ai relativi campi
  */
public class Merendina extends Dolce
{

	String marca;
	int prezzo;
	
	public Merendina(String n, String m, int p) 
	{
		super(n);
		marca = m;
		prezzo = p;
	}

	public String descrizione() 
	{
		String s = "La merendina si chiama "+nome+" è della marca "+marca+" e costa "+prezzo+" €";
		return s;
	}

	
	public String toString() 
	{
		return descrizione();
	}
 
}
