/* Nell'esercizio Lab09_1 aggiungere la funzione che calcola il valore max 
e il secondo max modificando i due parametri passati per riferimento. */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 35

void inizializzaVettore(int vettore[],int dimensione);
void stampaVettore(int vettore[],int dimensione);
int mediaVettore(int vettore[],int dimensione);
int elementiPariVettore(int vettore[],int dimensione);
int minimoVettore(int vettore[],int dimensione);
int consecutiviVettore(int vettore[],int dimensione);
int elementiDistintiVettore(int vettore[],int dimensione);
void dueMaxVettore(int vettore[],int dimensione, int* max1, int* max2);

int main()
{
    int v[SIZE];

    inizializzaVettore(v, SIZE);
    stampaVettore(v, SIZE);
    printf("La media del vettore è : %d\n",mediaVettore(v, SIZE));
    printf("Ci sono %d elementi pari\n",elementiPariVettore(v, SIZE));
    printf("Il minimo del vettore è : %d\n",minimoVettore(v, SIZE));
    int a = consecutiviVettore(v, SIZE);
    if(a != -1)
        printf("Gli indici %d e %d sono uguali\n", a, a+1);
    else 
        printf("Non ci sono elementi consecutivi uguali\n");
    if(elementiDistintiVettore(v, SIZE) == 1)
        printf("Tutti gli elementi del vettore sono distinti");
    else
        printf("Nel vettore ci sono elementi uguali");
    int m1, m2;
    dueMaxVettore(v, SIZE, &m1, &m2);
    printf("I due massimi valori sono %2d e %2d\n",m1,m2);
    return 0;
}
//-Genera un vettore random di 35 valori interi tra 15 e 85.
void inizializzaVettore(int vettore[],int dimensione)
{
    srand(time(NULL));
    for(int i=0;i<dimensione;i++)
    {
        vettore[i]=rand()%71+15;
    }
}
//Lo stampa sullo schermo (ben incolonnato con 7 numeri per riga).
void stampaVettore(int vettore[],int dimensione)
{
    printf("[");
    for(int i=0;i<dimensione;i++)
    {
        if(i>1 && i%7==0) 
            printf("\n");
        if(i==0)
            printf("%d,",vettore[i]);
        else 
            if(i!=dimensione-1)    
                printf(" %2d,",vettore[i]);
            else
                printf("%3d",vettore[i]);
        

    }
    printf("]\n");
}
//-Calcola la media (restituisce il valore corrispondente).
int mediaVettore(int vettore[],int dimensione)
{
    int somma = 0;

    for(int i=0;i<dimensione;i++)
    {
        somma = somma + vettore[i];
    }

    return somma/dimensione;
}
//-Calcola quanti valori pari sono stati generati.
int elementiPariVettore(int vettore[],int dimensione)
{
    int pari=0;
    for(int i=0;i<dimensione;i++)
    {
        if(vettore[i]%2==0)
            pari++;
    }
    return pari;
}
//-Calcola il valore minimo (restituisce l'indice).
int minimoVettore(int vettore[],int dimensione)
{
    int min = vettore[0];

    for(int i=1;i<dimensione;i++)
    {
        if(vettore[i]<min)
            min = vettore[i];
    }
    return min;
}
//-Controlla se ci sono due elementi consecutivi uguali.
//(restituisce l'indice del primo dei due oppure -1 se non ci sono).
int consecutiviVettore(int vettore[],int dimensione)
{
    for(int i=0; i<dimensione-1; i++)
    {
        if(vettore[i] == vettore[i+1])
        {
            return i;
        }
    }
    return -1;
}
//-Controlla se tutti gli elementi sono distinti (restituisce 1 oppure 0).
int elementiDistintiVettore(int vettore[],int dimensione)
{
    for(int i=0; i<dimensione-1; i++)
    {
        for(int j=i+1; j<dimensione;j++)
        {
            if(vettore[i] == vettore[j])
                return 0;
        }
    }
    return 1;
}
//calcola il valore max e il secondo max modificando i due parametri passati per riferimento.
void dueMaxVettore(int vettore[],int dimensione, int * max1, int * max2)
{

    *max1 = vettore[0];
    *max2 = vettore[1];

    for(int i=2; i<dimensione; i++)
    {
        if(vettore[i] >= *max1)
        {
            *max2 = *max1;
            *max1 = vettore[i];
        }
        else 
            if(vettore[i]>= *max2)
                *max2 = vettore[i];
    }
}
