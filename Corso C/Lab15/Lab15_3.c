/*Scrivere un programma che legge un file dove e' scritta una poesia 
(la vostra preferita!) e la riscrive sullo schermo dopo aver applicato 
le funzioni dell'esercizio precedente.
VARIANTE: invece di scriverla sullo schermo, la riscrive così modificata su un altro file.*/

#include <stdio.h>

int main()
{
    FILE * fp; 
    fp = fopen("/Users/gab/Desktop/STM Mac/VSCODE/ProgC/Poesia.txt", "r");


    fclose(fp);
    return 0;
}
