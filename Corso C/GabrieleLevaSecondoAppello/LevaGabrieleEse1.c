/* Gabriele Leva */
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define righe 5
#define colonne 5

#define MAX 3
#define MIN 0

void GeneraMat(int m[][colonne])
{
    srand(time(NULL));

    //inizializzo la matrice
    for(int i=0; i<righe; i++)  
    {
        for(int j=0; j<colonne; j++)
        {
            m[i][j]=rand()%MAX+MIN;
        /*  Per controllare che non ci siano numeri consecutivi uguali ne sulle righe ne sulle colonne
            divido il problema in base alla posizione (i,j) che sto inizializzando.
            Se i=0 => La prima colonna non ha elementi "a sinistra" quindi controllo solo "sopra"
            Anaglogamente per j=0 => La prima riga non ha elementi "sopra" quindi controllo solo "a sinistra"
            Sempre facendo attenzione a non "uscire" dai limiti della matrice
        */
            if(i==0 && j!=0)                          
            {
                while(m[i][j]==m[i][j-1])
                    m[i][j]=rand()%MAX+MIN;
            }     
            else 
                if(j==0)
                {
                    while(i!=0 && m[i][j]==m[i-1][j])
                        m[i][j]=rand()%MAX+MIN;
                }
                else 
                    //while(m[i][j]==m[i-1][j-1]) versione sbagliata, consegnata al compito
                    while(m[i][j] == m[i-1][j] || m[i][j] == m[i][j-1] ) //Versione corretta
                        m[i][j]=rand()%MAX+MIN;
        } 
    }
}

int SommaRigCol(int m[righe][colonne],int * n1,int * n2)
{
    int sRighe [righe], sCol, t=0;
    //Creo un array dove l'elementi i-esimo contiene la somma della i-esima riga della matrice passata
    for(int i=0; i<righe; i++)
    {
        sRighe [i]=0;
        for(int j=0; j<colonne; j++)
        {
            sRighe[i]+=m[i][j];
        }
    }
    for(int j=0; j<colonne; j++)
    {
        sCol = 0;
        //Calcolo la somma della colonna j-esima
        for(int i=0; i<righe; i++)
        {
            sCol+=m[i][j];
        }
        //Confronto tale somma con ogni elemento dell'array contenente le somme delle righe
        for(int k=0; k<righe; k++)
        {
        //Se la condizione richiesta è soddisfatta restituisco i valori di interesse
            if(sCol>=sRighe[k])
            {
                *n1=k;
                *n2=j;
                return sRighe[k];
            }
        }
    }
    return -11;
/*          Commento sul costo della funzione  (aggiunto dopo aver consegnato)
Per essere precisi la funzione lavorando con matrici rettangolari avrebbe un costo asintotico del tipo
r*c+c*2r = O(c*r) con 'r' per le righe e 'c' per le colonne
in altre parole possiamo dire che il costo è O(n^2)
*/
}

void StampaMatrice(int m [righe][colonne])
{
    for(int i=0; i<righe; i++)
    {
        printf("| ");
        for(int j=0; j<colonne; j++)
        {
            printf("%3d ",m[i][j]);
        }
        printf(" |\n");
    }
}

int main()
{
    int matrice[righe][colonne];
    GeneraMat(matrice);
    StampaMatrice(matrice);
    int n1, n2;
    int r = SommaRigCol(matrice,&n1,&n2);

    if(r>-11)
        printf("La somma della riga %2d = %3d è minore o uguale della somma della colonna %d\n",n1,r,n2);
    else
        printf("Non ci sono righe la cui somma è inferiore a quella di qualche colonna\n");
    
    return 0;
}