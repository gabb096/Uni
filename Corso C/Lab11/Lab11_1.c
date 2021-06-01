/*Ordinamento di Vettori
Scrivere una funzione int SelectMinSort(int v[], int s) 
    che ordina un vettore v in modo crescente utilizzando l'algoritmo di SelectionSort 
    mediante successivi calcoli del minimo. La funzione deve restituire il numero di confronti 
    effettuati tra elementi del vettore.
Scrivere una funzione int SelectMvxSort(int v[], int s) 
    che ordina un vettore v (sempre in modo crescente) utilizzando l'algoritmo di SelectionSort 
    mediante successivi calcoli del massimo. La funzione deve restituire il numero di confronti 
    effettuati tra elementi del vettore.
Scrivere una funzione int BubbleSort(int v[], int s) 
    che ordina un vettore v (sempre in modo crescente) utilizzando l'algoritmo di BubbleSort.
    La funzione deve restituire il numero di confronti effettuati tra elementi del vettore.
Scrivere un programma (funzione main) che genera un vettore random di 40 interi tra 11 e 99 
    e lo ordina utilizzando le funzioni sopra definite. Il progrvmma stampa i vettori prima e 
    dopo l'ordinvmento e il numero di confronti tra elementi del vettore effettuati. 
    Eseguire anche il programma cambivndo la dimensione del vettore v 4000 e valutare il numero di 
    confronti effettuati (per vettori così grandi si consiglia di non stamparli sullo schermo). 
    Completare l'esercizio lab11_1 aggiungendo gli algoritmi di InsertionSort e Mergesort.

Produrre una tvbella per il numero dei confronti del tipo :
  n    | conf selection | conf bubble | conf insertion | conf merge 
  30   |                |             |                |           
  200  |                |             |                |
  500  |                |             |                |
  2000 |                |             |                |
  10000|                |             |                |                                    */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 40

int SelectMinSort(int v[], int s);    // crescente
int SelectMaxSort(int v[], int s);    // decrescente
int BubbleSort(int v[], int s);       // crescente
int Merge(int v[], int low, int mid, int high);                          
int Mergesort(int v[], int low, int high); // decrescente
int InsertionSort(int v[], int s);    // crescente
void stampaVettore(int v[],int s); 

int main()
{
    srand(time(NULL));
    /*
    int n[5]={30,200,500,2000,10000};

    
    int confronti;
    
    int vect1[n[0]];
        for(int k = 0; k<n[0]; k++)    
            vect1[k]=rand()%89+11;
    int vect2[n[1]];
        for(int k = 0; k<n[1]; k++)    
            vect2[k]=rand()%89+11;
    int vect3[n[2]];
        for(int k = 0; k<n[2]; k++)    
            vect3[k]=rand()%89+11;
    int vect4[n[3]];
        for(int k = 0; k<n[3]; k++)    
            vect4[k]=rand()%89+11;
    int vect5[n[4]];
        for(int k = 0; k<n[4]; k++)    
            vect5[k]=rand()%89+11;

    printf("n    | conf selection | conf bubble | conf insertion | conf merge |\n");
    printf("30   |%16d|%13d|%16d|%12d|\n",SelectMaxSort(vect1,n[0]),BubbleSort(vect1,n[0]),Mergesort(vect1,0,n[0]),InsertionSort(vect1,n[0]));
    printf("200  |%16d|%13d|%16d|%12d|\n",SelectMaxSort(vect2,n[1]),BubbleSort(vect2,n[1]),Mergesort(vect2,0,n[1]),InsertionSort(vect2,n[1]));
    printf("500  |%16d|%13d|%16d|%12d|\n",SelectMaxSort(vect3,n[2]),BubbleSort(vect3,n[2]),Mergesort(vect3,0,n[2]),InsertionSort(vect3,n[2]));
    printf("2000 |%16d|%13d|%16d|%12d|\n",SelectMaxSort(vect4,n[3]),BubbleSort(vect4,n[3]),Mergesort(vect4,0,n[3]),InsertionSort(vect4,n[3]));
    printf("10000|%16d|%13d|%16d|%12d|\n",SelectMaxSort(vect5,n[4]),BubbleSort(vect5,n[4]),Mergesort(vect5,0,n[4]),InsertionSort(vect5,n[4]));
*/

    int n=10;
    int vect[]= {50, 37, 41, 82, 53, 93, 58, 17, 17, 99};
    for(int k = 0; k<n; k++)    
            vect[k]=rand()%89+11;
    InsertionSort(vect,n);

    return 0;
}

int SelectMinSort(int v[], int s) // crescente
{
    int i,  j, MinIndex, t, con=0;

    for( i=0; i<s-1; i++)
    {
        MinIndex = i;

        for( j=i+1; j<s; j++)
        {
            if(v[j]<v[MinIndex])
            {
                MinIndex = j;
                con++;
            }
            else
                con++;
            if(MinIndex!=i)
            {
                t = v[MinIndex];
                v[MinIndex] = v[i];
                v[i] = t;
                con++;
            }
            else    
                con++;
        }
    }
    return con;
}

int SelectMaxSort(int v[], int s) // decrescente
{
    int MaxIndex, t, con=0;

    for(int i=0; i<s-1; i++)
    {
        MaxIndex = i;

        for(int j=i+1; j<s; j++)
        {
            if(v[j]>v[MaxIndex])
            {
                MaxIndex = j;
                con++;
            }
            else
                con++;
            if(MaxIndex!=i)
            {
                t = v[MaxIndex];
                v[MaxIndex] = v[i];
                v[i] = t;
                con++;
            }
            else    
                con++;
        }
    }
    return con;
}

int BubbleSort(int v[], int s)    // crescente
{
    int con=0,t;
    for(int i=1; i<s; i++)
    {
        for(int j=0; j<s-1; j++)
        {
            if(v[j]>v[j+1])
            {
                t = v[j];
                v[j] = v[j+1];
                v[j+1] = t;
            }
            con++;
        }
    }
    return con;
}

int Merge(int v[], int low, int mid, int high) // decrescente 
{
    int con =0, k = 0, b[high-low];
    int i = low, j = mid+1;

    while (i<=mid && j<=high) 
    {
        if (v[i]>v[j]) 
        b[k++] = v[i++];
        else 
        b[k++] = v[j++];
        con+=2;
    }
    while (i <= mid) 
    {
        b[k++] = v[i++];
        con++;
    }
    while (j <= high) 
    {
        b[k++] = v[j++];
        con++;
    }
    for (k=low; k<=high; k++)
    {
        v[k] = b[k-low];
        con++;
    }
      
  return con;
}

int Mergesort(int v[], int low, int high)     
{
    int con=0, mid;
    if(low<high)
    {
        mid = (low+high)/2;
        con+=Mergesort( v, low, mid);
        con+=Mergesort( v, mid+1, high);
        con+=Merge(v, low, mid ,high);
    }
    
 return con;
}

void stampaVettore(int v[],int s)
{
    printf("[");
    for(int i=0;i<s;i++)
    {
        if(i>1 && i%11==0) 
            printf("\n");
        if(i==0)
            printf("%d,",v[i]);
        else 
            if(i!=s-1)    
                printf(" %2d,",v[i]);
            else
                printf("%3d",v[i]);
    }
    printf("]\n");
}

int InsertionSort(int v[], int s)// crescente
{
    int con=0,t,j;
    stampaVettore(v,s);
    for(int i=1;i<s;i++)
    { 
        t=v[i]; 
        for(j=i-1; j>=0 && v[j]>t; j--, con+=2)
            v[j+1]=v[j];
        v[j+1]=t;
        stampaVettore(v,s);
	}
 return con;
}

