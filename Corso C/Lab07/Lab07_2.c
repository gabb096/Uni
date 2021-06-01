/*Scrivere un programma che prende in input un numero positivo B e un numero positivo N 
e scrive in output il valore della potenza N-esima di B. 
Il programma deve utilizzare una funzione ricorsiva int pot(int,int) 
per calcolare tale numero.
*/

#include <stdio.h>

int potenza(int, int);

int main()
{
    int base, esponente;
    printf("Calcolo la potenza N-esima di un numero\nInserisci la Base --> ");
    scanf("%d",&base);
    while(base<=0)
    {
        printf("Capo la base positiva--> ");
        scanf("%d",&base);
    }
    printf("Inserisci l'esponente--> ");
    scanf("%d",&esponente);

    while(esponente<=0)
    {
        printf("Capo l'esponente positivo--> ");
        scanf("%d",&esponente);
    }

    printf("%d^%d = %d\n",base,esponente,potenza(base,esponente));
}

int potenza(int b, int p)
{
    if(p>1)
        return b*potenza(b,p-1);
    else 
        if(p==1)
            return b;
        else
            return 1;
}