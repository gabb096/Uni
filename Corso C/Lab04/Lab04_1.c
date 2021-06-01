/*Scrivere un programma che legge da tastiera un numero intero x (positivo) 
e stampa sullo schermo un quadrato (pieno) di lato x costituito da simboli "*" 
nelle posizioni sopra la diagonale e simboli "o" sotto la diagonale. 
(Utilizzare istruzioni for e non utilizzare istruzioni if)*/
#include <stdio.h>

int main()
{
    int n;
    printf("Inserisci un numero positivo\nPrego :");
    scanf("%d",&n);
    if(n<0)
    {
        while(n<0)
        {
            printf("%d non mi piace, try again : ",n);
            scanf("%d",&n);
        }
        printf("Ah mo si\n\n");
    }
    printf("Lé, ecco un bel quadrato di lato %d\n",n);
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i<=j)
            printf("*    ");
            else
            printf("o    ");
        }
        printf("\n\n");
    }
    return 0;
}