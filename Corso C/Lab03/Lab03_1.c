/*Scrivere un programma che richiede l'inserimento di 10 numeri interi 
e alla fine scrive sullo schermo il valore massimo e il secondo più grande che sono stati inseriti. 
Usare un solo ciclo while .*/
#include <stdio.h>

int main()
{   
    int x=10, numero;
    printf("Inserisci 10 numeri\nTi dirò i due massimi\n");

    printf("%2d°: ",11-x);
    scanf("%d",&numero);
    int max1=numero;
    int max2=numero;
    x--;
    while(x>0)
    {
        printf("%2d°: ",11-x);
        scanf("%d",&numero);

            if(max1<numero && max2!=numero)
            {
                max2=max1;
                max1=numero;
            }
            else if(max1>numero && (max2<numero || max2==max1))
            {
                max2=numero;
            }
        
        x--;
    }

    if(max2==max1)
        printf("Hai inserito solo %d\n",max1);
    else
        printf("\nIl 1° massimo è %d, il secondo è %d\n",max1,max2);
    return 0;
}