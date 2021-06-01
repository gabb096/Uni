/*
 Creare una classe Cioccolatino che estende Merendina
- deve avere una variabile int dimensioneConfezione
- deve fare un override di descrizione() in modo tale che componga una stringa formata da 
"Pacco da N di [" (dove N è il valore di dimensioneConfezione) 
seguita dalla stringa restituita dal metodo descrizione() 
della classe madre, seguita a sua volta dalla stringa "] 
Prezzo totale:" seguita a sua volta dalla moltiplicazione tra dimensioneConfezione e prezzo 
- deve avere un costruttore che prenda in input due stringhe e due interi, richiami il costruttore della classe madre 
e assegni la variabile mancante.
*/

public class Cioccolatino extends Merendina
{
	int dimensioneConfezione;
	
	public Cioccolatino(String n, String m, int p, int dim)
	{
		super(n,m,p);
		dimensioneConfezione = dim;
	}

	public String descrizione() 
	{
		
		return "Pacco da "+dimensioneConfezione+" di ["+super.descrizione()+"] \n Prezzo totale : "+(super.prezzo*dimensioneConfezione)+"€";
	}

}
