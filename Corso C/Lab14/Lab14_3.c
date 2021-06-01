/*Problema del Baricentro
Dato un vettore v di interi di dimensione n, definisco baricentro del vettore l’indice i tale che:
v[0] + v[1] + . . . + v[i] = v[i + 1] + . . . + v[n − 1]
Scrivere una funzione int baricentro(int v[], int n) che restituisce l'indice del baricentro 
del vettore v, se esiste, oppure restituisce -1 se non esiste un baricentro.
Qual è la complessità della funzione baricentro? Nell'ipotesi che tutti i valori del vettore 
siano positivi, l'algoritmo può essere realizzato in modo più efficiente?
Scrivere poi un programma (funzione main) che genera e stampa un vettore di dimensione 100 
di valori interi random tra -5 e 5 e poi, richiamando la funzione baricentro calcola il suo baricentro.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define dim 10
int baricentro(int v[], int s );

int main()
{
    srand(time(NULL));
    int vect [dim];

    printf("Vect = [ ");
    for(int i=0; i<dim; i++)
        printf("%2d ",vect[i]=(rand()%11)-5);  
    printf(" ]\n");

    int bari = baricentro(vect, dim);

    if(bari!=-1)
    {
        printf("          ");
        for(int i=0; i<bari; i++)
            printf("   ");
        printf("^\n");
        printf("          ");
        
        printf("Il baricentro si trova sul  %d° elemento\n",bari+1);
    }
    else
        printf("Baricentro inesistente\n");
    return 0;
}

int baricentro(int v[], int s )
{
    int media=0;
    int sommaDestra=0, sommaSinistra=0;
    for(int i=0; i<s; i++)
    {
        sommaDestra+=v[i];
        for(int j=i+1; j<s ;j++)
        {
            sommaSinistra+=v[j];
        }
        if(sommaDestra==sommaSinistra)
            return i;
        else
            sommaSinistra=0;
    }
    return -1;
}