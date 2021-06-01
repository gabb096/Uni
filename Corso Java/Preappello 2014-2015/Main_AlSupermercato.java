
public class Main_AlSupermercato
{	
	public static void main(String [] args) 
	{
		Articolo latte= new Articolo("Latte",0.90);
		Articolo uova= new Articolo("Uova",0.60);
		Articolo biscotti= new Articolo("Biscotti",3.90);
		Articolo carne= new Articolo("Carne",9.90);
		Articolo pesce= new Articolo("Pesce",13.90);
		Articolo verdura= new Articolo("Verdura",0.90);
		Articolo acqua= new Articolo("Acqua",0.20);
		Articolo vino= new Articolo("Vino",6.90);

		Articolo[] lista = {latte,carne,pesce,vino,};
		Acquisto[] spesa = new Acquisto[4];
		
		spesa[0] = new Acquisto(carne.nome,carne.prezzo,4);
		spesa[1] = new Acquisto(vino.nome,vino.prezzo,2);
		spesa[2] = new Acquisto(verdura.nome,verdura.prezzo,5);
		spesa[3] = new Acquisto(biscotti.nome,biscotti.prezzo,3);
		
		Volantino volantino = new Volantino(lista,biscotti);
		
		Cliente mario = new Cliente("mario", spesa);
		
		double totale=0,risparmio=0;
		
		
		
		for(int i=0; i<spesa.length;i++) 
		{
			totale += spesa[i].getPrezzo()*spesa[i].getNumero();
		}
		// i calcoli sono da rivedere
		for(int j=0;j<lista.length;j++)
		{
			for(int i=0; i<spesa.length;i++) 
			{
				if(lista[i].getNome().equalsIgnoreCase(spesa[j].getNome()))
					{
					risparmio+=(spesa[i].getPrezzo()*spesa[i].getNumero()*0.15);
					System.out.println(risparmio);
					}
					
			}
			if(spesa[j].getNome().equalsIgnoreCase(volantino.getPromo3x2().getNome())) 
			{
				int numPagati = spesa[j].getNumero()-(spesa[j].getNumero()/3);
				risparmio += volantino.getPromo3x2().getPrezzo()*numPagati;						
				System.out.println(risparmio+" "+numPagati);

			}
		}
		
		
		
		
		System.out.println(volantino.toString());
	
		System.out.println(mario.toString());
		System.out.println(mario.getNome()+" avrebbe pagato "+totale+" €");
		System.out.println("ma con le promozioni di oggi ha risparmiato "+(risparmio)+" €");



	}
}
