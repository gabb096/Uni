/*
 -3) Creare una classe Bottino che implementi l'interfaccia Valutabile
Deve contenere due membri privati
uno di tipo int : quantita ed uno di tipo double : rarita
Il metodo valuta() dovra' restituire il totale del valore ottenuto moltiplicando quantita' per rarita' .
Aggiungere un costruttore che prenda e assegni i valori a questi membri
*/
public class Bottino implements Valutabile
{
	private int quantita;
	private double rarita;
	
	public Bottino(int q, double r) 
	{
		this.quantita = q;
		this.rarita = r;
	}
	
	public double valuta() 
	{
		return quantita*rarita;
	}
}
