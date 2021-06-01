/*Varie su Matrici
Scrivere un programma in C che:
Genera una matrice di dimensione 20x30 di numeri casuali compresi tra -10 e 10 (estremi inclusi)
Stampa la matrice sullo schermo
Verifica se esiste una riga della matrice la cui somma sia 0. 
    In caso affermativo stampa la riga sullo schermo.
Verifica se esiste una colonna della matrice la cui somma sia 0. 
    In caso affermativo stampa la colonna sullo schermo.
Identifica la riga della matrice la cui somma degli elementi è maggiore. 
    Stampa sullo schermo l'indice di tale riga.
Verifica se esiste una riga la cui somma degli elementi è uguale alla somma degli elementi di una colonna.
    In caso affermativo stampa tali indici di riga e colonna, 
    in caso negativo segnala che la condizione non è verificata. 
Sugg.: utilizzare un vettore di supporto.
Stampa l'indice di tutte le righe in cui la media aritmetica dei valori è maggiore 
della media aritmetica dei valori dell'intera matrice.
I vari punti devono essere svolti come funzioni*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define righe 5
#define colonne 5

void GeneraMatrice(int m [][colonne], int r, int c);
void StampaMatrice(int m [][colonne], int r, int c);
void SommaRigaZero(int m [][colonne], int r, int c);
void SommaColonnaZero(int m [][colonne], int r, int c);
int MaxSommaRiga(int m [][colonne], int r, int c);
void SommaRigaUgualeSommaColonna(int m [][colonne], int r, int c);
void MediaRigheMaxMediaMatrice(int m [][colonne], int r, int c);

int main()
{
    int matrice[righe][colonne];
    GeneraMatrice(matrice,righe,colonne);
    StampaMatrice(matrice,righe,colonne);
    SommaRigaZero(matrice,righe,colonne);
    SommaColonnaZero(matrice,righe,colonne);
    MaxSommaRiga(matrice,righe,colonne);
    SommaRigaUgualeSommaColonna(matrice,righe,colonne);
    MediaRigheMaxMediaMatrice(matrice,righe,colonne);
}


void GeneraMatrice(int m [][colonne], int r, int c)
{
    srand(time(NULL));
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            m[i][j] = (rand()%21)-10;
        }
    }
}
void StampaMatrice(int m [][colonne], int r, int c)
{
    for(int i=0; i<r; i++)
    {
        printf("| ");
        for(int j=0; j<c; j++)
        {
            printf("%4d ",m[i][j]);
        }
        printf(" |\n");
    }
}
void SommaRigaZero(int m [][colonne], int r, int c)
{
    int somma;
    for(int i=0; i<r; i++)
    {
        somma=0;
        for(int j=0; j<c; j++)
        {
            somma+=m[i][j];
        }
        if(somma==0)
           {
               printf("La riga %d ha somma zero\n[ ",i);
               for(int k=0; k<r-1; k++)
                    printf("%2d, ",m[i][k]);
                printf("%2d]",m[i][r-1]);
           } 
        
    }
}
void SommaColonnaZero(int m [][colonne], int r, int c)
{
    int somma;
    for(int j=0; j<c; j++)
    {
        somma=0;
        for(int i=0; i<r; i++)
        {
            somma+=m[i][j];
        }
        if(somma==0)
        {
            printf("La colonna %d ha somma zero\n[ ",j);
            for(int k=0; k<c-1; k++)
                    printf(" %2d,",m[k][j]);
                printf(" %2d]\n",m[c-1][j]);
        }
    }
}
int MaxSommaRiga(int m [][colonne], int r, int c)
{
    int somma=0, maxSomma=0, maxIndex;
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            somma+=m[i][j];
        }
        if(somma>maxSomma)
        {
            maxSomma = somma;
            maxIndex = i;
        }
        somma=0;
    }
    return maxIndex;
}
void SommaRigaUgualeSommaColonna(int m [][colonne], int r, int c)
{
    int sommaRiga [r];
    int sommaColonna, t=0;
    for(int i=0; i<r; i++)
    {
        sommaRiga [i]=0;
        for(int j=0; j<c; j++)
        {
            sommaRiga[i]+=m[i][j];
        }
    }
    for(int j=0; j<c; j++)
    {
        sommaColonna = 0;
        for(int i=0; i<r; i++)
        {
            sommaColonna+=m[i][j];
        }
        for(int k=0; k<r; k++)
        {
            if(sommaColonna==sommaRiga[k])
            {
                printf("La riga %d e la colonna %d hanno entrambe somma %d\n",k,j,sommaColonna);
                t++;
            }
        }
    }
    if(t==0)
    printf("Non ci sono righe e colonne con la stessa somma\n");
}
void MediaRigheMaxMediaMatrice(int m [][colonne], int r, int c)
{
    int mediaMatrice=0, mediaRighe;
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            mediaMatrice+=m[i][j];
        }
    }
    mediaMatrice=mediaMatrice/(r*c);
    printf("La media della matrice è %d\n",mediaMatrice);
    for(int i=0; i<r; i++)
    {
        mediaRighe=0;
        for(int j=0; j<c; j++)
        {
            mediaRighe+=m[i][j];
        }
        if((mediaRighe/r)>mediaMatrice)
            printf("La riga %d ha la media superiore alla media della matrice\n",i);
            
    }
}