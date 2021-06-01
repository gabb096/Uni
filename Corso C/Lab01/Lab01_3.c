/*Scrivere un programma che legge da tastiera 5 numeri interi 
e scrive sullo schermo la loro somma e la loro media. 
Il programma dovra' utilizzare solo 2 variabili .
*/
#include <stdio.h>
int main()
{
    int numero;
    int somma = 0;
    printf("Inserisci 5 numeri e ti dirò somma e media\n");
    for(int i=0; i<5; i++)
    {
        printf("Inserisci un numero\n");
        printf("%d° : ",i+1);
        scanf("%d",&numero);
        somma += numero;
    }
    printf("La somma è: %d\nla media è: %d\n",somma,somma/5);
    return 0;
}