/*Il Triangolo di Floyd è definito come un triangolo costruito utilizzando numeri naturali 
consecutivi con righe di lunghezza crescente (la riga i-esima contiene i numeri). 
Ad esempio qui di sotto è definito il triangolo di Floyd di 5 righe.
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
Scrivere un programma che prende in input un numero positivo N compreso tra 3 e 33 
(inserire controllo input!) e disegna in output il triangolo di Floyd di N righe.*/
#include <stdio.h>

int main()
{
    int n, c=1;
    printf("TRIANGOLO DI FLOYD");
    printf("Inserisci un numero compreso tra 3 e 33\n");
    scanf("%d",&n);
    while(n<3 || n>33)
    {
        printf("Inserisci un numero compreso tra 3 e 33\n");
        scanf("%d",&n);
    }

    for(int i=0; i<n+1;i++)
    {
        for(int j=i; j>0;j--)
        {
            if(c<10)
            printf("0%d ",c);
            else
            printf("%2d ",c);
            c++;
        }
        printf("\n");
    }
}