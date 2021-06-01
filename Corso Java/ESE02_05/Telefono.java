/*
 Creare una classe Telefono che contenga:
1) le variabili stringa modello e sistemaOperativo, la variabile float dimensioneSchermo, 
la variabile intera memoria, un array di 10 interi ultimeChiamate.
2) metodi get e set per ciascun campo (eccetto ultimeChiamate). 
Assicurarsi che i valori di dimensionSchermo e memoria non siano mai pari a zero o negativi (valore minimo 1, ad esempio).
3) un costruttore che prenda in input un parametro per ogni campo di campo di classe 
(eccetto ultimeChiamate) e li assegni usando i metodi set ed infine inizializzi l'array ultimeChiamate
4) un metodo getChiamataRecente() che prende in input un intero e restituisce 
l'elemento di ultimeChiamate relativo all'indice ricevuto come parametro
5) un metodo chiama() che prende in input un intero e lo assegna come primo elemento 
dell'array ultimeChiamate (facendo scalare di posizione tutti gli altri)
*/

public class Telefono 
{
	
	String modello, sistemaOperativo;
	double dimensione;
	int memoria;
	int[] ultimeChiamate = new int [10];
	
	public Telefono(String m, String os, double dim, int mem) 
	{
		modello = m;
		sistemaOperativo = os;
		if(dim>0)
		dimensione = dim;
		else dimensione = 5.7;
		if(mem>0)
		memoria = mem;
		else memoria = 16;
	}

	
	public void chiama(int numero) 
	{
		
		for(int j=ultimeChiamate.length-1;j>0;j--)
		{
			ultimeChiamate[j] = ultimeChiamate[j-1];
		}
		ultimeChiamate[0]=numero;
	}
	
	
	public int getChiamataRecente(int i) 
	{
			return ultimeChiamate[i];
	}
	
	public String getModello() 
	{
		return modello;
	}

	public void setModello(String mod)
	{
		this.modello = mod;
	}

	public String getSistemaOperativo() 
	{
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String OS) 
	{
		this.sistemaOperativo = OS;
	}

	public double getDimensione() 
	{
		return dimensione;
	}

	public void setDimensione(double dim) 
	{
		if(dim>0)
		this.dimensione = dim;
		else dimensione = 4.7;
	}

	public int getMemoria() 
	{
		return memoria;
	}

	public void setMemoria(int mem) 
	{
		if(mem>0)
		this.memoria = mem;
		else memoria=32;
	}

	
	
	
}
