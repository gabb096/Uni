/*Scrivere una funzione ricorsiva int fatt(int) per calcolare il fattoriale di un numero.
Usando la formula e = 1 + 1/1! + 1/2! + .... 1/n! .... , 
Scrivere un programma che calcola una approssimazione di e con errore a scelta dell'utente. 
L'utente dovrà inserire un errore tipo 0,0001 e il programma dovrа selezionare i termini 
della serie in base all'errore fissato. 
Tale programma utilizza la funzione fattoriale sopra descritta. 
(non usare la libreria matematica).*/

#include <stdio.h>

int fattoriale(int );

int main()
{
    double n;
    printf("Approssimiamo e\n");
    printf("Quanto vuoi approssimare? es. 0.0001\n");
    scanf("%lf",&n);
    while(n<0)
    {
        printf("Numero positivo grazie\n");
        printf("Quanto vuoi approssimare? es. 0.0001\n");
        scanf("%lf",&n);
    }

    double apr = 1.0;
    double e = 0;
    int c = 0;
    while(apr>n)
    {
        apr = 1.0/(double)fattoriale(c);
        e = e + apr;
        c++;
    }
    printf("e = %lf\n",e);
}

int fattoriale(int n)
{
    if(n<2)
        return 1.0;
    else 
        return n*fattoriale(n-1);
}