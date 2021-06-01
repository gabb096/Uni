/*
Creare un array int di N elementi (dove N è un valore inserito da terminale dall'utente) 
(nella heap) con valori incrementali (il primo elemento vale 0, il secondo 1, il terzo 2..) .
Creare un metodo (che prende in input un puntatore e la dimensione dell'array) per stampare a schermo
i valori dell'array e la quantità di numeri pari in esso contenuti.
Creare un metodo che prende in input un puntatore, la dimensione dell'array e un altro intero 
che dovra' essere la nuova dimensione dell'array. Questo metodo dovra' restituire l'array ingrandito 
(o rimpicciolito), se vengono aggiunti nuovi elementi i loro valori 
dovranno anch'essi essere incrementali, ma l'incremento dovrà essere pari a 2 
(ad esempio se l'array iniziale fosse stato di tre elementi con a[2] = 2, 
il quarto elemento dovrà valere a[3] = 4 ) 
Nel main generare il primo array, stamparlo, cambiarne la dimensione 
(prendendo in input dall'utente la nuova dimensione) e stamparlo di nuovo. */

#include <iostream>

void StampaPariArray(int * pArray, int size);
int* ModificaArray(int * pArray, int oSize, int nSize);

void StampaPariArray(int * pArray, int size)
{
    std::cout<< "Stampo l'array \n";
    int pari = 0;

    for(int i=0; i<size; i++)
    {
    std::cout<< "[ "<<pArray[i]<<" ]  ";
    if(pArray[i]%2==0) ++pari;
    }
    std::cout<<"\nindirizzo 1° elemento "<< &pArray[0] <<"\n";
    std::cout<< "\nAl suo interno ci sono "<<pari<<" numeri pari \n\n";
}

int* ModificaArray(int* pArray, int oSize, int nSize)
{
    pArray = new int [nSize];

    if(oSize<nSize)//nuovo array più grande
    {
        for(int i=0; i<nSize;i++)
        {
            if(i<=oSize)
                pArray[i]=i; 
            if(i>oSize)
            pArray[i] = pArray[i-1] + 2;
        }
    } 

    if(oSize>=nSize)//nuovo array più piccolo
    {
        for(int j=0; j<nSize; j++)
        {
          pArray[j]=j;
        }
    } 

    delete  [] pArray; //dealloca, non cancella 
    
    return pArray;
}

int main()
{
    using namespace std;
    
    int N=10;

    cout<<"Inserisci un numero\n";
    cin>>N;

    int * array = new int[N];

    for(int i=0; i<N;i++) { array[i]=i; }

    StampaPariArray(array,N);

    cout<<"Inserisci la nuova lunghezza dell'array\n";
    
    int nuovo;
    cin>>nuovo; 
    int vecchio=N;

    cout<<"Hai inserito "<<nuovo<<"\n\n";

    array=ModificaArray(array,vecchio,nuovo);

    StampaPariArray(array,nuovo);
    
    vecchio=nuovo;
    cin>>nuovo;
    

    cout<<"Inserisci la nuova lunghezza dell'array\n";
    cout<<"Hai inserito "<<nuovo<<"\n\n";
    array = ModificaArray(array,vecchio,nuovo);

    StampaPariArray(array,nuovo);

    return 0;
}