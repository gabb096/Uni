/* Scrivere un programma che simula una partita a dadi fra il computer e l'utente. 
Scrivere una funzione int lancia2Dadi() Che simula il lancio di 2 dadi e 
restituisce il risultato (la somma dei 2 dadi).
Il main consiste in una partita di 7 turni. Ad ogni turno, si simula un tiro 
(richiamando la funzione lancia2Dadi) dell'utente e un tiro del computer 
e si visualizzano i risultati. Alla fine viene "proclamato" il vincitore che 
è ovviamente colui che ha vinto più turni. */

#include <stdio.h>
#include <time.h>

int lancioDadi(int );

int main()
{
    srand(time(NULL));
    int numeroDadi = 2;
    int pv1=0, pv2=0, r1, r2;
    for(int i=1;i<8;i++)
    {
        printf("- - - - - - - - - - - - - - - %d° turno \n",i);
        r1=lancioDadi(numeroDadi);
        r2=lancioDadi(numeroDadi);

        printf("User ha fatto %d\nIl Pc ha fatto %d\n",r1,r2);
        
        if(r1>r2)
            pv1++;
        else if(r2>r1)
            pv2++;

        printf("Siamo User %d - %d Pc\n\n",pv1,pv2);
    }

    printf("E il vincitore è ....");
    if(pv1>pv2)
        printf("USER");
    else
        printf("PC");

}

int lancioDadi(int n)
{
    return n+rand()%(n*5+1);
}
