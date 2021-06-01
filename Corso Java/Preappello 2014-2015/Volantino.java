
public class Volantino
{
	int l =5;
	Articolo[] sconto15 = new Articolo[l];
	
	Articolo promo3x2 = new Articolo();
	
	public Volantino(Articolo[] a, Articolo p)
	{
		this.sconto15 = a;
		
		for(int i=0;i<a.length;i++) 
		{
			if( a[i].getNome().equalsIgnoreCase(p.getNome()) )
			{
				System.out.println("L'articolo in promo è gia presente nei prodotti scontati.");
				System.out.println("Inserire nuovo articolo in promo 3x2");
				this.promo3x2 = new Articolo();
			}
			else
				this.promo3x2 = p;
		}
		
	}
	
	
	public void setSconto15(Articolo[] a) 
	{
		sconto15 = a;
	}
	
	public void setPromo3x2(Articolo p) 
	{
		promo3x2 = p;
	}


	public Articolo[] getSconto15() 
	{
		return sconto15;
	}
	
	public Articolo getPromo3x2() 
	{
		return promo3x2;	
	}
	
	public String toString() 
	{
		String s = "Gli articoli in sconto del 15% sono:\n";
		for(int i=0;i<sconto15.length;i++) 
		{
			s+= sconto15[i].toString()+"\n";
		}
		s+="In oltre abbiamo la promozione prendi 3 paghi 2 con \n" + promo3x2.getNome() +" che costa " +promo3x2.getPrezzo()+"\n\n";
		return s;
	}
}
