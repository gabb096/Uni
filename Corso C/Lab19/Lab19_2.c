/*Ripetere l'esercizio precedente in modo che il programma chieda 
in input un file di testo, lo stampi sullo schermo e poi lo riscriva 
cambiando i numeri da cifre a lettere. 
Alla fine il nuovo file dovrà essere stampato sullo schermo. */


#include <stdio.h>
int main()
{
    FILE *fp;
    char *c;
    char str[20];
    fp = fopen( "Input.txt" , "r" );
    c=fgets(str ,20, fp );
    while (c!='\0')
    {
        printf("\n ho letto dal file: %s   ",str);
        c=fgets(str ,20, fp );
    }
    fclose(fp);
    return(0);
}
