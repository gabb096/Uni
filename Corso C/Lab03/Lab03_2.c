/*Scrivere un programma che legge da tastiera una sequenza di numeri interi positivi. 
L'immissione termina quando l'utente inserisce il valore 0. 
In output viene riportato il numero di volte che nella sequenza compaiono due numeri consecutivi uguali. 
Esempio: nella sequenza 5 6 6 5 3 3 4 compaiono due volte due numeri consecitivi uguali; 
nella sequenza 3 3 3 4 2 2 compaiono tre volte due numeri consecutivi uguali.*/
#include <stdio.h>

int main()
{
    int x;
    int pre;
    int con=0;

    printf("Inserisci un numero, 0 per uscire\n");
    printf("In : ");
    scanf("%d",&x);
    pre=x;
    
    while(x!=0)
    {
        printf("In : ");
        scanf("%d",&x);
        if(x == pre)
            con++;
        pre=x;
    }

    printf("Hai inserito %d volte due numeri cosecutivi uguali\n",con);
    return 0;
}