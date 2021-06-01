/*Def.: un numero si dice perfetto se è uguale alla somma dei suoi divisori 
(escluso il numero stesso). 
Scrivere una funzione che, dato un numero intero positivo, calcola se e' un numero perfetto 
(non stampa messaggio ma restituisce valore booleano). Scrivere poi un programma, 
che utilizza questa funzione, che scrive sullo schermo tutti i numeri perfetti <10000. */

#include <stdio.h>
#include <stdbool.h>

bool isPerfetto(int);

int main()
{
    int i;
    int c=0;
    int n=10000;
    for(i=1;i<n;i++)
    {
        if(isPerfetto(i))
        {
        printf("%d è un numero perfetto\n",i);
        c++;
        }
    }
    printf("Ci sono %d numeri perfetti inferiori a %d\n",c,n);
    return 0;
}


bool isPerfetto(int a)
{
    int i;
    int somma=0;
    for(i=1;i<=a/2;i++)
    {   
        if(a%i == 0)
        somma+=i;
    }
    if(somma == a)
    return true;
    else
    return false;
}

