/* 1. Problema della classifica del campionato .
Input: matrice quadrata in cui righe e colonne corrispondono a delle squadre (di calcio?) 
    e gli elementi m(i,j) a valori -1, 0 oppure 1 che corrispondono al fatto che la partita 
    tra i e j è stata persa, pareggiata o vinta.
vettore di stringhe della stessa dimensione della matrice che contiene i nomi delle squadre.
Scrivere un programma che produce in output la classifica delle squadre con i punteggi corrispondenti 
(ottenuti sommando per ogni partita : 0 = perdita, 1 = pareggio, 3 = vincita). 
Utilizzare le strutture dati di supporto che si ritengono più adeguate.
Utilizzare come base di partenza il programma provaCampionato.c visto a lezione. */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define righe 9

int main()
{
    srand(time(NULL));
    int i, j;
    int max1, max2;

    struct squadre
    {
        char * nome;
        int punteggio;
    };
    typedef struct squadre Squadra;
    //definisco un array di stringhe cioè char *
    char * nomi[righe]={"sq1","sq2","sq3","sq4","sq5","sq6","sq7","sq8","sq9"};
    // definisco un array di "squadre"
    Squadra Campionato[10];
    //Partite
    int partite[righe][righe];
    int risultato;
    for(int i=0; i<righe; i++)
    {
       for(int j=0; j<righe; j++)
        {
            if(i==j)
                partite[i][j] = 2;
            else 
            {
                risultato = rand()%2;
                if(risultato == 0)
                {
                    partite[i][j] = 0;
                    partite[j][i] = 0;

                }
                else
                {
                    partite[i][j] = 1;
                    partite[j][i] = -1;
                }
            }

        } 
    }
    
    //inizializzazione
    for(j=0; j<righe; j++)
    {
        Campionato[j].nome=nomi[j];
        Campionato[j].punteggio = 0;
        for(int i=0; i<righe;i++)
        {
            if(partite[j][i]==1)
                Campionato[j].punteggio += 3;
            else 
                if (partite[j][i]==0)
                   Campionato[j].punteggio += 1;
        }
    }

    //stampa
    printf("    ");
    for(int k=0; k<righe;k++)
    {
        printf("%3s ",nomi[k]);
    }
    for(int i=0; i<righe; i++)
    {
        printf("\n%3s ",nomi[i]);
       for(int j=0; j<righe; j++)
        {
            printf("%3d ",partite[i][j]);
        }
    }
    printf("\nClassifica campionato\n");

    for(j=0; j<righe; j++)
    {
       printf("%s : %d\n", Campionato[j].nome, Campionato[j].punteggio);
    }

    //calcolo vincitore
    max1=0;
    for(j=1; j<righe; j++)
    {
        if (Campionato[j].punteggio > Campionato[max1].punteggio)
            max1 = j;
    }
    
    printf("\n\nLa squadra che ha vinto il campionato e': %s  con %d punti\n", Campionato[max1].nome, Campionato[max1].punteggio);

}
