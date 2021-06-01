/*Scrivere un programma che richiede all'utente di inserire 5 numeri interi 
e poi scrive sullo schermo la somma e la media.
*/
#include <stdio.h>

int main()
{
    int x = 5;
    int numero;
    int somma = 0;

    while(x>0)
    {
    printf("Inserisci il %d° numero ",6-x);
    scanf("%d",&numero);
    somma += numero; 
    printf("\n");
    x--;
    }
    printf("La somma è %d\nLa media é %d\n", somma, somma/5);
    return 0;
}