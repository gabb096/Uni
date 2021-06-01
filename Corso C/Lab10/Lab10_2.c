/*Crivello di Eratostene
Implementare una funzione che simula il crivello di Eratostene per il calcolo dei numeri primi. 
Utilizzarla per calcolare tutti i numeri primi tra 2 e 1000.
La funzione int Crivello(int C[], int n) sarà definita su un array booleano C di dimensione n tale che
C[i] = 1 significa che i è primo e C[i] = 0 significa che i NON è primo
All’inizio pongo C[i] = 1 per ogni i
Realizzo n-1 cicli che iniziano ogni volta dall’elemento che contiene il primo 1
Se un ciclo comincia da C[i] allora assegno 0 a tutti i C[j] tale che j è un multiplo di i */

#include <stdio.h>

#define Max 100
#define min 2

int Crivello(int C[], int n);

int main()
{
    int numeri [Max];
    int c=1;
    for(int i = 0; i<Max;i++)
    {
        numeri[i]=1;
    } 

    Crivello(numeri,Max);

    printf("Ecco i numeri primi tra 2 e %d calcolati con il Crivello di eratostene\n",Max);
    for(int i=min; i<Max; i++)
    {
        if(numeri[i]==1)
            {
                if(c%8==0)
                    printf(" %3d\n",i);
                else 
                    printf(" %3d,",i);
                c++;
            }
    }
}

int Crivello(int C[], int n)
{
    for(int i=2;i<n/2;i++)
    {
        for(int j=2; i*j<=n; j++)
        {
                C[i*j]=0;
        }
    }
    return 0;
}