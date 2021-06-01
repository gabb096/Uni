/*Scrivere un programma che prende in input un numero positivo N 
e scrive in output l' N-esimo numero di Fibonacci. 
Il programma deve utilizzare una funzione ricorsiva int Fibon(int) per calcolare tale numero.
*/

#include <stdio.h>

int fibo(int); 

int main()
{
    int n;
    printf("Calcolo l' N-esimo numero di Fibonacci\n");
    printf("Inserisci un numero --> ");
    scanf("%d", &n);
    while(n<=0)
    {   
        if(n==0)
        printf("zeresimo?");

        printf("Deve essere maggiore di 0, riprova --> ");
        scanf("%d", &n);
    }
    printf("L'%d° numero di Fibonacci è : %d\n", n, fibo(n));
}

int fibo(int n)
{
    if(n<=2)
        return 1;
    else
        return fibo(n-1)+fibo(n-2);
}