/*Srivere un programma che legge da tastiera 5 numeri interi e scrive sullo schermo la loro somma.*/
#include <stdio.h>
int main()
{
    int numero;
    int somma = 0;
    printf("Inserisci 5 numeri e ti dirò la loro somma\n");
    for(int i=0; i<5; i++)
    {
        printf("Inserisci un numero\n");
        printf("%d° : ",i+1);
        scanf("%d",&numero);
        somma += numero;
    }
    printf("La somma è : %d\n",somma);
    return 0;
}