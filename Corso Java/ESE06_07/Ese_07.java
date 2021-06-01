/*
 Modificare il main dell'esercizio precedente, dopo aver creato i due oggetti di tipo Bottino e Borsello deve:
-1) creare un oggetto di tipo Valutabile (scegliete voi il nome) usando una classe anonima che implementi 
l'interfaccia Valutabile. Il metodo valuta() di questa classe anonima deve restituire sempre 0
-2) creare un array di oggetti di tipo Valutabile che contenga 4 elementi. I primi tre elementi 
dovranno essere i tre oggetti precedentemente instanziati.
-3) inizializzare il quarto elemento dell'array con un'altra classe anonima che estende Borsello 
e fa un override del metodo valuta() in modo tale che i valori delle monete siano rispettivamente:
ogni moneta d'oro vale 125 ogni moneta d'argento vale 25 ogni moneta di bronzo vale 5
-4) esegue un ciclo sull'array passando ogni suo elemento al metodo MostraValore*/
public class Ese_07
{
	public static void main(String [] args) 
	{
		Borsello borsello = new Borsello(23 , 544 , 89);
		Bottino bottino = new Bottino(123 , 1.45);
		Valutabile qualcosa = new Valutabile()
			{
				public double valuta() {return 0 ;}
			};
		Valutabile[] array = new Valutabile[4];
		array[0]= borsello;
		array[1]= bottino;
		array[2]= qualcosa;
		array[3]= new Borsello(13,43,678) 
			{ public double valuta() 
				{
				 return (getMonete_oro()*125)+(getMonete_argento()*15)+(getMonete_bronzo()*5); //fai i getters
				}
			};		
	
		MostraValore(borsello);
		MostraValore(bottino);
	
	}
	
	public static void MostraValore(Valutabile v) 
	{
		System.out.println(v.valuta() );
	}
}
