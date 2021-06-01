/*Riscrivere l'esercizio Lab04_1 utilizzando la funzione vista a lezione:
void stampaRiga(char simb, int lung)
 {   int i;
     for ( i= 1; i <= lung; i++)
         printf("%c", simb);
 }*/

#include <stdio.h>

void stampaRiga(char, int);

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
    for(int j=0;j<n;j++)
    {
       
        stampaRiga('o',j);
        stampaRiga('*',n-j);
        printf("\n");
    }
    printf("\n\n");
return 0;
}


void stampaRiga(char simb, int lung)
{   
    int i;
    
    for ( i = 1; i <= lung; i++)
        printf("%c  ", simb);
}