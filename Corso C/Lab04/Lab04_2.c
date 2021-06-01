/*Scrivere un programma (Utilizzare istruzioni for e non utilizzare istruzioni if) 
che chiede all’utente di inserire un intero x , 3 ≤ x ≤ 30 , 
e disegna un rombo di lato x come nel seguente esempio: (esempio per x=4 e c=o)
   o           
  ooo          
 ooooo
ooooooo        
 ooooo
  ooo
   o
*/

#include <stdio.h>

int main()
{   
    int n;
    char c;
    printf("Inserisci un numero tra 3 e 30\nprego : ");
    scanf("%d",&n);
    if(n<3 || n>30)
    {
        while(n<3 || n>30)
        {
            printf("%d non mi piace, try again : ",n);
            scanf("%d",&n);
        }
        printf("Ah mo si\n\n");
    }
    printf("Inserisci carattere\nprego : ");
    
    scanf("%c",&c);
    scanf("%c",&c);
    
    printf("Lé, ecco un bel rombo fatto da tanti %c\n",c);

    for(int i=1; i<=n;i++)
    {
        for(int j=n-i; j>=1;j--)
        {
            printf(" ");
        }
        for(int k=0;k<2*i-1;k++)
        {
            printf("%c",c);
        }
        printf("\n");
    }
    //seconda parte
    for(int i=0; i<n-1;i++)
    {
        for(int j=0; j<i+1;j++ )
        {
            printf(" ");
        }
        for(int k=2*i;k<2*n-3;k++)
        {
            printf("%c",c);
        }
        printf("\n");
    }
    return 0;
}