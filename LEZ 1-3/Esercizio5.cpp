/*
Creare un namespace di nome pog contenente una variabile intera "finoA" 
e una funzione "numeriPrimi()" che calcola tutti i numeri primi fino a "finoA"
Fuori dal namespace programmare un main() che fa inserire il valore di finoA 
all'utente e poi richiama la funzione numeriPrimi().
*/
#include <iostream>

namespace pog
{
    int finoA;

    int numeriPrimi()
    {
        int j;
        int c = 0;
    //considero solo i dispari, i pari sono per definizione divisibili per 2
       for(int i=1; i<finoA; i+=2) 
        {
           j=2;
          while(j<=i)
         {
             if(i%j == 0)
                break;
             else 
                ++j;
         }
            if(j==i)
                c++;
       }

       if( finoA<2)
            return 1;
       else 
            if(finoA>=2 && c>1)
            return c +2; // +2 perchè non calcolo se 1 e 2 sono primi
       else 
            return 0;
    }
}

int main()
{
    int a=100;
    std::cout<<"Inserisci un numero e vediamo quanti numeri primi ci sono più piccoli di lui\n";
    
    //std::cin>>a;

    pog::finoA=a;

    std::cout<<"\nCi sono "<<pog::numeriPrimi()<<" numeri primi minori di "<<pog::finoA;
    std::cout<<"Questo programma considera anche 1 un numero primo!";
    return 0;
}