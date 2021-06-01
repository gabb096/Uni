/*Scrivere un programma che richiede l'inserimento di 10 numeri interi e 
alla fine scrive sullo schermo il valore massimo che e' stato inserito.*/

#include <stdio.h>
int main()
{
    int c=10;
    int numero, max;
    printf("Inserisci 10 numeri\n");
    while(c>0)
    {
        printf("%2d° : ", 11 - c);
        scanf("%d",&numero);
            if(c==10)
                max=numero;
            if(numero>max)
                max=numero;
        c--;
    }
    printf("Il massimo è %d\n",max);
    return 0;
}