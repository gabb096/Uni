/*Scrivere un programma che chiede all'utente di inserire da tastiera un numero intero di 5 cifre 
e lo riscrive "in verticale" cioe' mettendo un accapo dopo ogni cifra. 
(Sugg. usare l'operatore % che calcola il resto della divisione intera.)
*/
#include <stdio.h>
int main()
{
    int numero;
    int somma = 0;
    printf("Inserisci 5 numeri\n");
    scanf("%d",&numero);
    somma += numero*10000;
    scanf("%d",&numero);
    somma += numero*1000;
    scanf("%d",&numero);
    somma += numero*100;
    scanf("%d",&numero);
    somma += numero*10;
    scanf("%d",&numero);
    somma += numero;    
    printf("Il numero %d diventa:\n",somma);
    printf("%d\n",somma%100000/10000);
    printf("%d\n",somma%10000/1000);
    printf("%d\n",somma%1000/100);
    printf("%d\n",somma%100/10);
    printf("%d\n",somma%10);
    return 0;
}