/*Scrivere un programma che prende in input un numero positivo N
e scrive in output il valore di n!. 
Il programma deve utilizzare una funzione ricorsiva int fatt(int) per calcolare tale numero.*/

#include <stdio.h>

int fattoriale(int);

int main()
{
    int n;
    printf("Inserisci un numero positivo e ne calcolo il fattoriale\n");
    scanf("%d",&n);
    while(n<0)
    {
        printf("%d non è positivo, try again",n);
        scanf("%d",&n);
    }
    printf("%d! = %d\n",n,fattoriale(n));
}

int fattoriale(int n)
{
    if(n<2)
        return 1;
    else 
        return n*fattoriale(n-1);
}