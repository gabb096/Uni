/*rivere un programma che, utilizzando degli asterischi, 
disegna sullo schermo un quadrato (pieno) di lato 8 e poi 
sotto un triangolo rettangolo (pieno) di altezza 8.*/

#include <stdio.h>
int main()
{
    printf("Un quadrato di lato 8\n");

    printf("\n");

    for(int i=0; i<8; i++)
    {
            for(int j=0; j<8; j++)
            {
                printf("* ");
            }
        printf("\n");
    }
    printf("\nUn triangolo rettangolo alto 8\n");
    for(int i=0; i<8; i++)
    {
        for(int j=0; j<i; j++) 
        {   
            printf("* ");
        }
    printf("\n");
    }
    return 0;
}