/*Numeri di Fibonacci. I numeri di Fibonacci, f1, f2, ... fn sono definiti ricorsivamente come segue: 
f1=1 
f2=1 
... 
fn = fn-1 +fn-2 
Scrivere un programma che prende in input un numero positivo N e scrive in output l'N-esimo numero di Fibonacci. 
(ATTENZIONE! Testare solo per numeri piccoli)*/
#include <stdio.h>

int main()
{
    int n;
    int t=0;
    int f1=1,f2=1,fn;
    printf("Io prendo in input un numero positivo N e scrivo in output l'N-esimo numero di Fibonacci\n");
    printf("Prego : ");
    scanf("%d",&n);
    while(n<0 || n>50)
    {
        printf("%d non mi piace, try again : ",n);
        scanf("%d",&n);

        if(n>0 && n<50)
        {
             printf("Ah mo si\n");
        }
    
    }

    if(n==1)
        printf("Il primo numero di Fibonacci è 1\n");
    else if(n==2)
        printf("Il secondo numero di Fibonacci è 1\n");
    else
    {
         while(t<n)
        {
            fn=f1+f2;
            f1=f2;
            f2=fn;
            t++;
        }
        printf("Il %d°  numero di Fibonacci è %d\n",n,fn);
    }    
   

    return 0;
}