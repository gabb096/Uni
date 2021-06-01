/*Scrivere una funzione che, dato un numero intero positivo, 
calcola se e' un numero primo (non stampa messaggio ma restituisce valore booleano). 
Scrivere poi un programma, che utilizza questa funzione, che scrive sullo schermo 
tutti i numeri primi <1000.*/

#include <stdio.h>
#include <stdbool.h> 

bool isPrimo(int);

int main()
{
    int i;
    int c=0;
    int n=1000;
    for(i=0;i<n;i++)
    {
        if(isPrimo(i))
        {
        printf("%d è un numero primo\n",i);
        c++;
        }
    }
    printf("Ci sono %d numeri primi inferiori a %d\n",c,n);
    return 0;
}

bool isPrimo(int a)
{
    int c=3;
    if(a<=0)
    return false;
    else if(a%2==0)
    return false;
    else
    {
    while(c<=a/2)
    {
        if(a%c==0)
        return false;
        
        c++;
    }
    return true;
    }
}