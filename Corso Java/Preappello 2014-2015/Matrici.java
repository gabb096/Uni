
import java.util.Random;
import java.util.Scanner;

public class Matrici 
{
	static Random ran = new Random();
	static Scanner key = new Scanner(System.in);
	
	public static void main(String [] args) 
	{
		int[][] matrice = new int[10][6];
		
		matrice = Matrice(matrice);
		StampaMatrice(matrice);
		
		System.out.println("inserisci l'indice della prima riga da controllare ");
		System.out.println("il numero deve essere comprese tra 0 e 9! ");
		int h = key.nextInt();
		System.out.println("inserisci l'indice della seconda riga da controllare ");
		System.out.println("il numero deve essere comprese tra 0 e 9! ");
		int k = key.nextInt();

		boolean b = elementiInComune(matrice,h,k);
		System.out.println("risultato : " + b);
		
		
	}
	
	public static boolean elementiInComune(int[][] m,int h,int k) 
	{
		for(int i=0;i<m[h].length;i++) 
		{
			for(int j=0;j<m[k].length;j++) 
			{
				if(m[h][i]==m[k][j]) 
					return true;
			}
		}
		return false;
	}
	
	public static int[][] Matrice(int[][] s) 
	{
		for(int i=0; i<s.length;i++) 
		{
			for(int j=0; j<s[i].length; j++)
			{
				s[i][j] = 50+ran.nextInt(70);
			}
		}
		return s;
	}
	public static void StampaMatrice(int [][] s) 
	{
		
		for(int i=0; i<s.length;i++) 
		{
			for(int j=0; j<s[i].length; j++)
			{
				System.out.print("\t"+s[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
		
}

