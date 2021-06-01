/*Scrivere un programma per risolvere il seguente quesito: 
Esiste un numero formato da 8 cifre che moltiplicato per un altro numero 
dà come risultato un numero di 9 cifre uguali?*/
#include <stdio.h>

int main()
{
    int x=2;
    int n=111111111;
    int num9=n;
    double num8;
    for(int i=1;i<10;i++)
    {
        num9=n*i;
        do
        {
            num8=num9/x;
            if( sizeof(num8) == sizeof(long) )
            {
                printf("Abbiamo che %d x %d fa %d\n",num8,x,num9);
            }
            x++;
        }
        while( (num8)/1000000 >= 1 );
        x=2;
    }
    return 0;
}