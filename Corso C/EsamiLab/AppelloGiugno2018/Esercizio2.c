/* Data una matrice quadrata di dimensione n × n a valori in un insieme {0, 1, . . . , k}, 
il carico di una posizione (i,j), indicato con c(i,j), è dato dalla differenza tra la somma 
degli elementi della riga i e la somma degli elementi della colonna j. 
1. Scrivere una funzione caricoNullo che prende una matrice e la sua dimensione n e restituisce 
    il numero di elementi di carico nullo. L’algoritmo deve utilizzare memoria aggiuntiva costante. 
    Discutere la complessità di tempo dell’algoritmo utilizzato.
2. Mostrare un’altra funzione caricoNullo2 con complessità di tempo inferiore che però utilizza 
    memoria aggiuntiva O(n). */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 4

void StampaMatrice(int m [][SIZE])
{
    for(int i=0; i<SIZE; i++)
    {
        printf("| ");
        for(int j=0; j<SIZE; j++)
        {
            printf("%2d ",m[i][j]);
        }
        printf(" |\n");
    }
}

int caricoNullo(int matrix[][SIZE], int size)
{
    int sommaRiga [size], sommaColonna [size];
    int c=0;
    for(int i=0; i<size;i++)
    {
        sommaRiga[i]=0;
        sommaColonna[i]=0;
        for(int j=0; j<size;j++)
        {
            sommaRiga[i] += matrix[i][j];
            sommaColonna[i] += matrix[j][i];
        }
    //  printf("Somma  Riga   %d = %d\n",i,sommaRiga[i]);
    //  printf("Somma Colonna %d = %d\n",i,sommaColonna[i]);
    }
    for(int k=0; k<size; k++)
    {
        for(int d=0;d<size;d++)
        {
            if(sommaRiga[k]==sommaColonna[d])
                c++;
        }
    }
    return c;
    /*COSTO DELLA FUNZIONE n = size 
    3 assegnamenti +
    n+1 controlli e n incrementi
    n cicli 
        2  assegnamenti per ciclo
        1 assegnamento per ciclo
        n+1 controlli e n incrementi per ciclo 
        n cicli per ciclo
            2 assegnamenti per ogni ciclo 
    1 assegnamento
    n+1 controlli e n incrementi
    n cicli 
        1 assegnamento per ciclo
        n+1 controlli e n incrementi per ciclo 
        n cicli per ciclo
            1 controllo per ciclo
            1 assegnazione per ciclo (nel caso pegggiore
    ovvero :
    3+n+1+n+n*(2+1+n+1+n*2)+1+n+1+n+n*(1+n+1+n+n*(1+1)) =
    4+2n+n(4+3n)+2+2n+n(2+2n+2n) =
    6+4n+n(2+4n)+4n+3n^2 =
    6+8n+2n+4n^2+3n^2 =
    6+10n+7n^2 = O(n^2)
    */
}

int main()
{
    srand(time(NULL));
    int matrice [SIZE][SIZE];

    for(int i=0; i<SIZE; i++)
    {
        for(int j=0; j<SIZE; j++)
        {
            matrice[i][j] = rand()%3;
        }
    }
    StampaMatrice(matrice);
    int a = caricoNullo(matrice, SIZE);

    if(a==0)    
        printf("Non ci sono punti c(i,j) con carico nullo\n");
    else
        printf("Ci sono %d punti c(i,j) con carico nullo\n",a);
    return 0;
}