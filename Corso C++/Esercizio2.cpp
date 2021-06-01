/*
Creare un array int di 10 elementi (nella stack) con valori randomici tra 1 e 30 e 
trovare i suoi valori di massimo e di minimo utilizzando una funzione che prende in input un puntatore 
e la dimensione dell'array. Stampare a schermo l'array e questi due valori.
*/

#include <iostream>
#include <stdlib.h>

using namespace std;

void minMax(int* p ,int dim);

#define lenght 10

void minMax(int* p ,int dim)
{
    int min=31;
    int max=0;

for(int i=0; i<dim; i++) 
    {
        if(min > p[i]) 
            min = p[i];
        if(max<p[i])
            max = p[i];
    } 

    cout<<"Stampo array:"<<endl;

     for(int i=0; i<dim; i++)  { cout<<"[ "<<p[i]<<" ] "; }

    cout<<"\nIl minimo è "<<min<<"\nIl massimo è "<<max<<endl;
}

int main()
{
    int array[lenght];

    srand(time(NULL));

    for(int i=0; i<lenght; i++) { array[i]=(rand()%30)+1; }

    minMax(array,lenght);
    return 0;
}