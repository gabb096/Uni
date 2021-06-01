/*Scrivere un programma che prende in input 3 numeri interi inseriti da tastiera 
e li scrive in output in ordine crescente utilizzando in totale soltanto 3 confronti 
(con operatore <= ) tra i numeri stessi all'interno di istruzioni if-else annidate. 
No variabili supplementari (solo 3 variabili per i 3 numeri).*/

#include <stdio.h>

int main()
{
    int a,b,c;
    printf("Inserisci un numero\nprego : ");
    scanf("%d",&a);
    printf("Inserisci un numero\nprego : ");
    scanf("%d",&b);
    if(b<=a)
    {
        c=b;
        b=a;
        a=c;
    }
    printf("Inserisci un numero\nprego : ");
    scanf("%d",&c);
    if(b<=c)
    {
        printf("\nHai inserito questi numeri eccoli in ordine crescente\n");
        printf("%d - %d - %d\n",a,b,c);
    }
    else if(c<=a)
    {
        printf("\nHai inserito questi numeri eccoli in ordine crescente\n");
        printf("%d - %d - %d\n",c,a,b);
    }
    else
    {
        printf("\nHai inserito questi numeri eccoli in ordine crescente\n");
        printf("%d - %d - %d\n",a,c,b);
    }
    return 0;
}