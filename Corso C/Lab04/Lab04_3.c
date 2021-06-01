/*Scrivere un programma che stampa tutti i numeri interi tra 1 e 300 in righe 
contenenti 15 numeri ciascuna. I numeri devono essere ben incolonnati. 
Inoltre, se il numero termina per 7 oppure è divibile per 7 NON deve essere 
stampato ed nel suo posto deve essere scritto BUM.*/

#include <stdio.h>

int main()
{
    for(int i=1;i<301;i++)
    {
        if(i%16==0)
        printf("\n");
        else if( i%7==0 || i%10==7 || i%100==7)
        printf("BUM ");
        else
        printf("%3d ",i);
    }
    return 0;
}