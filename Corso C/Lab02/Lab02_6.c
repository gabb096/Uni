/*Scrivere un programma che richiede all'utente di inserire 10 numeri 
interi compresi tra 1 e 100 (estremi inclusi), ne calcola la somma e la scrive sullo schermo.
Attenzione: ogni volta che l'utente inserisce un valore errato (fuori dall'intervallo previsto) 
il programma dovra' segnalare l'errore e richiedere un altro numero... 
il ciclo di immissione termina SOLO quando sono stati immessi 10 numeri VALIDI*/
#include <stdio.h>

int main()
{
    printf("Inserisci 10 numeri tra 1 e 100\n");

    int x=1, c=1, somma=0, numero;

    while(x==1)
    {
        printf("%d°: ",c);
        scanf("%d",&numero);

        if(numero>0 && numero<101)
        {
            somma+=numero;
            c++;
        }
        else
        {
            printf("Numero non valido\n");
        }
        if(c==11)
        { 
            x=0; 
        }
    }
    printf("La somma è %d\n",somma);

    return 0;
}