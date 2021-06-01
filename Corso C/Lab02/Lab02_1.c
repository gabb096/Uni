/*Scrivere un programma che richiede all'utente un numero intero x 
e poi scrive sullo schermo una linea composta da x asterischi.
*/
#include <stdio.h>

int main()
{
    int x;
    printf("Inserisci un numero\n");
    scanf("%d",&x);
    while(x>0)
    {
        printf("x");
        x--;
    }
    printf("\n");
    return 0;
}