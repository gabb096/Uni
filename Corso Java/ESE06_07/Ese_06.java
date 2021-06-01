/* 
-4) Creare una classe principale di nome MainClass
-5) Creare un metodo statico di nome MostraValore della classe MainClass che prenda 
come argomento un oggetto che implementi Valutabile e che deve semplicemente stampare 
il valore dell'oggetto utilizzando il metodo dell'interfaccia
-6) Strutturare il metodo main di MainClass
deve creare un oggetto di tipo Bottino ed un oggetto di tipo Borsello
(passando nei costruttori dei valori inseriti direttamente nel codice, a vostra scelta) 
e poi utilizzare il metodo MostraValore per far stampare il valore totale dei due oggetti
*/
public class Ese_06 
{
	public static void main(String [] args) 
	{
		Borsello borsello = new Borsello(23 , 544 , 89);
		Bottino bottino = new Bottino(123 , 1.45);
		
		MostraValore(borsello);
		MostraValore(bottino);
	
	}
	
	public static void MostraValore(Valutabile v) 
	{
		System.out.println(v.valuta() );
	}
}
