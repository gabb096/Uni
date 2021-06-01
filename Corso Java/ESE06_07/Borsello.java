/*
 -2) Creare una classe Borsello che implementi l'interfaccia Valutabile
Deve contenere tre membri privati di tipo int : monete_oro, monete_argento, 
monete_bronzo Il metodo valuta() dovra' restituire il totale del valore delle monete sapendo che
ogni moneta d'oro vale 100 ogni moneta d'argento vale 10 ogni moneta di bronzo vale 1
aggiungere un costruttore che prenda e assegni i valori a questi membri
*/
public class Borsello implements Valutabile
{

	private int monete_oro, monete_argento, monete_bronzo;
	
	public double valuta() 
	{
		return (monete_oro*100)+(monete_argento*10)+monete_bronzo;
	}
	
	public int getMonete_oro() {
		return monete_oro;
	}

	public void setMonete_oro(int monete_oro) {
		this.monete_oro = monete_oro;
	}

	public int getMonete_argento() {
		return monete_argento;
	}

	public void setMonete_argento(int monete_argento) {
		this.monete_argento = monete_argento;
	}

	public int getMonete_bronzo() {
		return monete_bronzo;
	}

	public void setMonete_bronzo(int monete_bronzo) {
		this.monete_bronzo = monete_bronzo;
	}

	public Borsello(int oro, int argento, int bronzo) 
	{
		this.monete_oro = oro;
		this.monete_argento = argento;
		this.monete_bronzo = bronzo;
	}
}
