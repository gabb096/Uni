/*Cambiamo le parole
Scrivere un programma che
1. Data una stringa in input la restituisce modificando tutte le a in e.
2. Data una stringa in input e un dato carattere, restituisce la stringa dove 
    tutte le occorrenze del carattere scelto sono state cancellate.
Non utilizzare le funzioni predefinite sulle stringhe. 
Le stringhe devono essere effettivamente modificate e non solo stampate sullo schermo.*/

#include <stdio.h>

int main()
{
    int i;
    int len = 30;
    char stringa[len];
    char del; 
    printf("Inserisci una stringa max %d caratteri\n",len-1);
    for (i=0; ((stringa[i]=getchar())!='\n')&& i<len-1; i++);
        
    stringa[i]='\0';
    printf("ora inserisci un carattere da eliminare\n");
    scanf("%c",&del);
    for(i=0; i<len-1;i++)
        if(stringa[i]==del)
            stringa[i]=' ';
    printf("%s\n",stringa);
}