/*
Creare un array int di 10 elementi (nella stack) con valori randomici tra 1 e 30 
ed eseguire un ciclo che trova i valori di massimo e di minimo. 
Stampare a schermo l'array e questi due valori.
*/
#include <iostream>
#include <stdlib.h>
using namespace std;

#define lenght 10

int main()
{
    int array[lenght];
    int min = 31;
    int max = 0;

    srand(time(NULL));

    for(int i=0; i<lenght; i++) //riempio l'array con numeri tra 1 e 30
    {
        array[i]=(rand()%30)+1;
        if(min > array[i]) 
            min = array[i];
        if(max<array[i])
        max=array[i];
    }
    //stampo
    
    cout<<"Stampo array:"<<endl;
     for(int i=0; i<lenght; i++) 
    {
        cout<<"[ "<<array[i]<<" ] ";
    }

    cout<<"\nIl minimo è "<<min<<"\nIl massimo è "<<max<<endl;


    return 0;
}