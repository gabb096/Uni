/*Scrivere un programma che richiede l'inserimento di 10 numeri interi 
e alla fine scrive sullo schermo quanti numeri pari sono stati inseriti.
*/
#include <stdio.h>
int main()
{
    int c=10;
    int pari = 0;
    int numero;
    printf("Inserisci 10 numeri, conto quanto sono pari\n");
    while(c>0)
    {
        printf("%2d° : ", 11 - c);
        scanf("%d",&numero);
        if(numero%2==0)
            pari++;
        c--;
    }

    printf("Ci sono %d numeri pari\n",pari);

    return 0;
}