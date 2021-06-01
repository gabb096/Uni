/*Scrivere un programma che prende in input dei valori interi positivi 
( l'immissione termina quando l'utente inserisce il valore 0) 
e restituisce in output quanti tra quelli inseriti sono > 100, 
quanti sono >50 e <= 100 e quanti sono <=50. 
Il programma dovrà utilizzare soltanto 4 variabili e istruzioni if-else annidate e 
dovrà ignorare gli input negativi segnalandolo all'utente.
*/
#include <stdio.h>

int main()
{
    int n=1;
    int min=0,tra=0,mag=0;
    printf("Inserisci un numero intero positivo\n");
    while(n!=0)
    {
        printf("Prego : ");
        scanf("%d",&n);
        if(n<0)
        printf("I numeri negativi non li considero...\n");
        else if(n<=50 && n>0)
        min++;
        else if(n>100)
        mag++;
        else
        tra++;
    }
    printf("\n\nHai inserito %d numeri minori di 50\n",min);
    printf("Hai inserito %d numeri compresi tra 50 e 100\n",tra);
    printf("Hai inserito %d numeri maggiori di 100\n",mag);
    return 0;
}