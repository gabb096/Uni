
public class Acquisto extends Articolo
{

	int numero;
	
	public Acquisto() 
	{
		super();
		numero=0;
	}
	
	public Acquisto(String n, double p, int q) 
	{
		super(n,p);
		numero=q;
		
	}
	
	public int getNumero() 
	{
		return numero;
	}
	
	public void setNumero(int n) 
	{
		numero = n;
	}
	
	public String toString() 
	{
		return super.toString() + " ne hai presi " + numero;
	}
}
