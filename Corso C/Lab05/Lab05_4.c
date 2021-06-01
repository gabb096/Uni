/*Scrivere un programma che chiede all'utente di inserire un numero intero x 
e poi scrive in output quanti sono i divisori di x (escluso 1 e x stesso). 
Se non ci sono divisori non banali scrive sullo schermo che x è un numero primo.*/

#include <stdio.h>

int main()
{
    int n,t=0;

    printf("Inserisci un numero e calcolo quanti divisori ha\nprego : ");
    scanf("%d",&n);

    for(int i=2;i<n/2;i++)
    {
        if(n%i==0)
        {
            t++;
            printf("%d è divisore di %d\n",i,n);
        }
    }
    if(t==0)
    printf("%d è un numero primo!\n",n);
    else
    printf("%d ha %d divisori\n",n,t);
    return 0;
}