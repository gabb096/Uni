/*Scrivere un programma che simula il gioco IndovinaNumero discusso a lezione 
in cui si deve indovinare un numero da 1 a 100 a seguito di risposte 
"troppo alto" o "troppo basso". Il programma, oltre ad eventuali funzioni ausiliarie, 
dovrà contenere 2 funzioni ComputerVsUtente e UtenteVsComputer che restituiscono il numero di tentativi 
necessari per indovinare il numero. Il programma principale si compone poi delle due chiamate di funzione 
e della "proclamazione" del vincitore.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

int ComputerVsUtente();
int UtenteVsComputer();

int main()
{
    bool b;
    int gioco;
    printf("Facciamo un gioco :D\n");
    
    b = true;
    while(b)
    {
        printf("Inserisci 1 per indovinare il numero a cui sto pensando\n");
        printf("Inserisci 2 e io provo ad indovinare il numero a cui stai pensando\n");
        printf("Inserisci 0 se non vuoi giocare\n");
        scanf("%d",&gioco);
        if(gioco == 1)
        {
            int a = ComputerVsUtente();
            if(a != 0)
                printf("Complimenti hai vinto!\nCi hai messo %d turni\nGiochiamo ancora?\n",a);
            else 
                printf("Rivincita?\n");
        }
        else 
            if(gioco == 2)
            {
                int a = UtenteVsComputer();
                if(a != 0)
                    printf("Hai vinto tu... \nGiochiamo ancora?\n");
                else 
                    printf("Rivincita?\n");
            }
            else
            {
                b = false;
                printf("GG WP\n");
            }
    }
    return 0;
}

int UtenteVsComputer()
{
    srand(time(NULL));
    int min = 1, max = 100, turni = 1, r=3, guess = min+(max-min)/2;
    printf("Pensa ad un numero tra 1 e 100 compresi, provo ad indovinarlo\n");
    printf("Inserisci 0 se ho indovinato\n1 se il mio numero è più basso del tuo\n2 se il mio numero è più alto del tuo\n");
    printf("Proviamo con %d\n",guess);
    while(turni <= 6)
    {
        printf("Ho indovinato? --> ");
        scanf("%d",&r);
        if(r == 1)
        {
            min = guess;
            guess = min+(max-min)/2;
            printf("Proviamo con %d\n",guess);
            turni++;        
        }
        else 
            if(r == 2)
            {
                max = guess;
                guess = min+(max-min)/2;
                printf("Proviamo con %d\n",guess);
                turni++;
            }
            else    
            {
                printf("Daje! Ci ho messo %d turni\n",turni);
                return turni;
            }
    }
    return 0;
}

int ComputerVsUtente()
{
    srand(time(NULL));
    int num = rand()%100+1;
    int guess;
    int turni=1;
    printf("Sto pensando ad un numero tra 1 e 100\n");
    while(turni<=6)
    {   
        printf("--> ");
        scanf("%d",&guess);
        if(guess==num)
        {
            if(turni==1)
            {
                printf("Alla prima botta... Che c**o!\n");
                return 1;
            }
            else
            {
                printf("Esatto pensavo proprio a %d\n",num);
                return turni;
            }
        }
        else
        {
            if(guess>num)
                printf("Troppo alto...\n");
            else
                printf("Troppo basso...\n");
            printf("Tentativi rimasti..%d\n",6-turni);
        }
        turni++;
    }
    printf("Ci hai metto troppo, pensavo a %d\n",num);
    return 0;
}