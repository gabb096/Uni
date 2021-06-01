import java.util.Random;

public class Java_Matrice 
{
	
	
	static void Genera(int[][] v, int RIG, int COL)
	{
		Random ran = new Random();	
		int i,j;
		for(i=0;i<RIG;i++)
		{
			for(j=0;j<COL;j++)
			{
				v[i][j]= ran.nextInt(11)+700;
			}
		}
	}
	
	static int PiccoLocale(int [][] v, int x, int y)
	{
		int c=0;
		
		if(y < v.length-1&& v[x][y]==v[x][y+1])
			c++;
		if(y>0 && v[x][y] == v[x][y-1])
			c++;
		if(x>0 && v[x][y]==v[x-1][y])
			c++;
		if(x < v.length-1 && v[x][y]==v[x+1][y])
			c++;
		
		if(c>1)
			return v[x][y];
		else
			return -1;
	   
	}
	
	
	static void PicchiMassimi(int [][] v)
	{
		int i,j,r=0;
		int max1=PiccoLocale(v,0,0),max2,temp;
		int x1=0,x2=0,y1=0,y2=0,t1,t2;
		int s=0;
		for(i=0;i<v.length;i++)
		{
			for(j=0;j<v.length;j++)
			{
				s=PiccoLocale(v,i,j);
				if(s !=-1)
				{
					r++;
					
					max2 = s;
					x2=i;
					y2=j;
					
					if(max1<=max2)
					{
						temp=max1;
						max1=max2;
						max2=temp;
						
						t1=x1;
						x1=x2;
						x2=t1;
						
						t2=y1;
						y1=y2;
						y2=t2;
					}
					
				}
			
				
			}
		}
		if(r==1)
		{	System.out.println("In questo territorio c'è un solo picco locale");
		    System.out.println("Il picco massimo è "+v[x1][y1]+" alle coordinate ["+y1+"]["+x1+"]");
		}
		else
		if(r>1)
		{	
		System.out.println("In questo territorio ci sono "+r+" picchi");
		System.out.println("Il picco massimo è "+v[x1][y1]+" alle coordinate ["+y1+"]["+x1+"]");
		System.out.println("Il secondo picco massimo è "+v[x2][y2]+" alle coordinate ["+x2+"]["+y2+"]");
		}
		else
		{
			System.out.println("Non ci sono picchi locali in questo terreno");
		}
		
	}
	
	static void stampaMatrice(int [][] v)
	{
		int i,j;
		for(i=0;i<v.length;i++)
		{
			for(j=0;j<v.length;j++)
			{
				System.out.print("["+v[i][j]+"]  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args)
	{
		int r=10,c=r;
		
		int[][] matrice = new int [r][c];
		Genera(matrice,r,c);
		stampaMatrice(matrice);
		PicchiMassimi(matrice);
	}
}
