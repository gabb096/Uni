/*Def.: Un numero naturale n si dice quadratoso se è un quadrato ed inoltre cancellando 
ad n una delle sue cifre si ottiene ancora un quadrato.
Ad esempio 1369 è quadratoso infatti 1369=37^2 e, cancellando la cifra 3, si ottiene 169=13^2 . 
Analogamente 2025= 45^2 è quadratoso infatti eliminando la prima cifra si ottiene 
025 = 25 = 5^2 .
Scrivere una funzione che, dato un numero intero positivo, calcola se e' un numero quadratoso 
(non stampa messaggio ma restituisce valore booleano). 
Scrivere poi un programma che scrive in output tutti i numeri quadratosi di 4 cifre.
*/

#include <stdio.h>
#include <math.h>
#include <stdbool.h>

bool isQuadratoso(int);

int main()
{
    int i;
    int c=0;
    int n=100;
    for(i=1;i<n;i++)
    {
        if(isQuadratoso(i))
        {
        printf("%d è un numero quadratoso\n",i);
        c++;
        }
    }
    printf("Ci sono %d numeri quadratosi inferiori a %d\n",c,n);
    return 0;
}

bool isQuadratoso(int a)
{
    if(sizeof(sqrt(a)) == sizeof(int))
    return false;
}