/*
Creare un array int di N elementi (dove N è un valore inserito da terminale dall'utente) 
(nella heap) con valori rndomici tra 1 e 30 e utilizzare una funzione 
(che prende in input un puntatore e la dimensione dell'array) 
per stampare a schermo i valori dell'array e la quantità di numeri pari in esso contenuti.*/

#include <iostream>
#include <stdlib.h>
using namespace std;

int numPari(int* p ,int dim);

int numPari(int* p ,int dim)
{

srand(time(NULL));

int pari=0;

for(int i=0; i<dim; i++) 
{

    p[i]=(rand()%30)+1;    
    
        if(p[i]%2==0)
            pari++;
}

return pari;
}

int main()
{
    
int d;

cout<<"inserisci la dimensione dell'array\n";

cin>>d;
int array[d];  
int r = numPari(array,d);

for(int i=0; i<d; i++) 
{
    cout<<"[ "<<array[i]<<" ] ";
}

cout<<"\nCi sono "<< r <<" numeri pari"<<endl;

return 0;
}