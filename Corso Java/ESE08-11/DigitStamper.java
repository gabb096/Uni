/*Creare una classe DigitStamper che abbia:
- un campo intero di nome numero (sempre compreso tra 10000 e 99999 )
- un campo intero di nome id (sempre compreso tra 0 e 9)
- campo char o String di nome: c
*/
import java.util.Random;

public class DigitStamper 
{
	int numero, id;
	char c;
	Random ran = new Random();
  // il costruttore deve inizializzare i valori di partenza facendoseli passare come argomenti 
  // (non un costruttore senza parametri insomma)
	public DigitStamper() 
	{
		
	} 
  
	// un metodo maskedStamp() che stampa a schermo il valore di numero sostituendo tutte le cifre uguali a id con il valore di c
	
	public void maskedStamp(char c)
	{
		String s1 = Integer.toString(numero);
		id=ran.nextInt(9);
		
		System.out.println("Numero mascherato :"+id+"=>"+s1.replace(Integer.toString(id).charAt(0), c));

	}
	// un metodo toString() che restituisca una stringa contenente "Numero = " seguito dal valore di numero
	
	public String toString() 
	{
		return "Numero = " + numero;
	}
	
	// un metodo Randomize() che cambi il valore di numero in maniera casuale 
    // (mantenendolo sempre nell'intervallo [10000,99999] )
	
	public void Randomize() 
	{
		numero = ran.nextInt(89999)+10000;
	}
	
	// un metodo stamp() che stampa a schermo il valore restituito dal metodo toString()
	
	public void stamp() 
	{
		System.out.println(this.toString());
	}
}

