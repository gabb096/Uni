/*Scrivere un programma che richiede l'inserimento di una serie di numeri interi positivi;
 l'inserimento termina quando l'utente inserisce 0 o un valore negativo. 
 Al termine dell'inserimento, sullo schermo viene scritta la somma e la media dei numeri inseriti.
*/
#include <stdio.h>
int main()
{
    printf("Inserisci numeri positivi, con numeri <=0 uscirai\n");

    int x=1, c=1, somma=0, numero;

    while(x==1)
    {
        printf("%d°: ",c);
        scanf("%d",&numero);

        if(numero>0)
        {
            somma+=numero;
            c++;
        }
        else
        { 
            x=0; 
        }
    }
    printf("La somma è %d\nLa media è %d\n",somma,somma/c);

    return 0;
}