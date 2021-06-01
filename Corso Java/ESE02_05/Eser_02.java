/*
 Creare una classe Eser02 che contenga:
1) un metodo statico generaNumero() che restituisce un intero casuale di 9 cifre formato nella seguente maniera: 
le prime tre cifre devono essere scelte casualmete tra 333, 348 e 389 le seguenti 6 cifre devono essere 
completamente casuali
2) un main() che crea un'istanza della classe Telefono (scegliete voi i valori da passare al costruttore)
poi esegue 15 chiamate a numeri casuali generati tramite il metodo generaNumero() dopo ogni chiamata stampa 
il numero cui ha telefonato
ogni 5 chiamate permette all'utente di rivedere un numero di quelli tra le ultimeChiamate 
(stampando tale numero telefonico) facendogli inserire l'indice della chiamata in questione
*/
import java.util.Random;
import java.util.Scanner;

public class Eser_02 
{

	public static void main(String [] args) 
	{
		Telefono tel = new Telefono("Moto", "Android",6.5,33);
		Scanner key = new Scanner(System.in);
		for(int j=0; j<3; j++) 
		{
			for(int i=0; i<5;i++) 
			{
				int num = generaNumero();
				tel.chiama(num);
			}
			System.out.println("Vuoi vedere una delle ultime chiamate fatte?");
			int n = key.nextInt();
			System.out.println(n+" chiamate fa hai chiamato : " + tel.getChiamataRecente(n));
			
		}
	}
	
	public static int generaNumero() 
	{
		Random ran = new Random();
		
		int pre = ran.nextInt(3);
		int numero=0;
		switch(pre) 
		{
		case 0:  numero = 333*1000000+ran.nextInt(999999);
		System.out.println(+numero);
			break;
		case 1:  numero = 348*1000000+ran.nextInt(999999);
		System.out.println(numero);

			break;
		case 2:  numero = 389*1000000+ran.nextInt(999999);
		System.out.println(numero);

			break;
		}
		return numero;
	}
}
