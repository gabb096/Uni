
public class Cliente 
{
	String nome;
	Acquisto [] carrello = new Acquisto[4];
	
	public Cliente(String n, Acquisto[] a) 
	{
		nome = n;
		carrello = a;
	}
	
	
	public Cliente() 
	{
		nome = "Clientone";
		for(int i=0; i<carrello.length;i++) 
		{
			carrello[i]= new Acquisto();
		}
	}
	
	public void setNome(String n) 
	{
		nome = n;
	}
	
	public void setCarrello(Acquisto[] a) 
	{
		carrello = a;
	}
	
	
	public String getNome() 
	{
		return nome;
	}
	
	public Acquisto[] getCarrello() 
	{
		return carrello;
	}
	
	public String toString() 
	{
		String s="Il cliente " +nome+" ha nel suo carrello :\n";
		for(int i=0;i<carrello.length;i++) 
		{
			s+=carrello[i].toString()+"\n";
		}
		return s;
	}
	
	
	
	
}
