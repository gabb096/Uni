
public class Articolo 
{
	String nome;
	double prezzo;
	
	public Articolo(String n, double p)
	{
		nome = n;
		prezzo = p;
	}
	
	public Articolo() 
	{
		nome = "nome articolo";
		prezzo = 1.0;
	}
	
	public void setNome(String n) 
	{
		nome = n;
	}
	
	public void setPrezzo(double p) 
	{
		prezzo=p;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}
	
	public String toString() 
	{
		return "L'articolo "+nome+" costa "+prezzo+" €";
	}
	
}
