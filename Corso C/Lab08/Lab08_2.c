/*Scrivere un programma che: simula una successione di lanci di moneta (Testa o Croce); 
continua a generare lanci di moneta fino a che è verificata la seguente condizione 
di terminazione : la sequenza generata contiene almeno 5 esiti uguali consecutivi 
(es: 5 volte Testa, oppure 5 volte Croce). Il programma deve stampare "testa" o "croce" 
relativa ad ogni lancio e alla fine restituire il numero di lanci di moneta c
he sono stati necessari per verificare la condizione di terminazione. */

#include <stdio.h>
#include <time.h>

int main()
{
    int lanci = 1, esitiUguali = 0, risultato, vecchio;
    
    srand(time(NULL));

    risultato = rand()%2;
    if(risultato == 0)
            printf("T ");
        else
            printf("X ");
    
    while(esitiUguali < 5)
    {
        vecchio=risultato;
        risultato = rand()%2;

        if(risultato == 0)
            printf("T ");
        else
            printf("X ");

        if(vecchio == risultato)
            esitiUguali++;
        else 
            esitiUguali = 1;
        
        lanci++;
        
        if(lanci%10 == 0)
            printf("\n");
    }

    printf("\nSono serviti %d lanci",lanci);
    
}