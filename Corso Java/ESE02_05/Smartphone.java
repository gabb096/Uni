
public class Smartphone extends Telefono
{

	String [] apps = new String [10];
	int [] numeriPreferiti = new int [5];
	
	public Smartphone(String m, String os, double dim, int mem) 
	{
		super(m, os, dim, mem);
		
		for(int i=0; i<apps.length;i++) 
		{
			apps[i] = "_._";
		}
	}

	public int getNumeroPreferito(int k) 
	{
			return numeriPreferiti[k];	
	}
	
	public void stampaApp(String[] s) 
	{
		for(int i=0; i<s.length;i++) 
		{
			System.out.println("app "  + i +" = " + s[i]);
		}
	}
	
	public void installaApp(String nome) 
	{
		int c=1;
		for(int i=0; i<apps.length;i++) 
		{
			if(apps[i] == "_._")
				{
				apps[i] = nome;
				break;
				}
			
			else c++;
		}
		if( c == apps.length )
			System.out.println("App non installata");
		else 
			System.out.println("App installata con successo");
	}
	
	public void eliminaApp(int k) 
	{
		apps[k]="_._";
	}
	
	public void chiama(int num) 
	{		
		boolean uc = isInUltimeChiamate(num);
		boolean np = isInNumeriPreferiti(num);
		if(uc==true && np==false) 
		{
			scendiNumeri(numeriPreferiti);
			numeriPreferiti[0]=num;
		}
		scendiNumeri(ultimeChiamate);
		ultimeChiamate[0]=num;
	}
	
	public void scendiNumeri(int [] a) 
	{
		for(int j = a.length-1;j>0;j--)
		{
			a[j] = a[j-1];
		}
		a[0] = 0;
	}
	
	public boolean isInNumeriPreferiti(int n) 
	{
		boolean b=false;
		
		for(int i=0; i<numeriPreferiti.length;i++) 
		{
			if(n == numeriPreferiti[i])
			{
			return true;
		    }   
		}
		return b;
	}
	
	public boolean isInUltimeChiamate(int n) 
	{
		boolean b=false;
		
		for(int i=0; i<ultimeChiamate.length;i++) 
		{
			if(n == ultimeChiamate[i])
				{
			    return true;
			    }   
		}
		
		return b;
	}
}
