/* Gabriele Leva */
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define len 13

int Contiene(char Smaxi[], char Smini[])
{
    int c=0, i=0, u=0;
    int lenMaxi=0, lenMini=0;
    for(;Smini[i]!='\0';i++,lenMini++); /* Corretto dopo la consegna */
    //Controllo se Smini si trova in Smax
    for(i=0; Smaxi[i]!='\0'; i++)
    {
        //Devo rivederla meglio
        int k=i;
        for(int j=0; Smaxi[k]!='\0' && Smini[j]!='\0'; j++,k++)
        {
            /* Aggiunto dopo la consegna */
           if(Smaxi[k]==Smini[j])
            u++;
        }
        if(u==lenMini)
            c++;
        u=0;
    }
    return c;
}

int lunghezza(char s[])
{
    int lun=0;
    int i;
    for (i=0; s[i]!='\0'; i++)
    {
        lun++;
    }
    return lun;
}

 /* Aggiunto dopo la consegna */
void instringa(char sMaxi[], char sMini[])
{
    int count = 0, stringMini = 0;
    for(int j = 0; j < lunghezza(sMaxi); j++)
    {
        int k = j;
        for(int i = 0; i < lunghezza(sMini); i++)
        {
            if(sMini[i] == sMaxi[k])
            {
                count++;
                k++;  // Controllo che lettere consecutive di sMaxi siano uguali alla stringa sMini
            }
        }
        if(count == lunghezza(sMini))  // Se il commento prima risulta vero, allora incremento una variabile
        {                              // stringMini che tiene conto di quante volte count è stato uguale alla lunghezza di sMini
            stringMini++;
            count = 0;
        }
        else
        {
            count = 0;
        }
    }
    printf("La stringa %s compare %d volte nella stringa %s\n", sMini, stringMini, sMaxi);
}

int main()
{
    char max [5], min [5], end[5]="fine\0";
   
    int i, b=0;
    do
    {
        printf("Inserisci due volte la parola \"fine\" per uscire\n");

        printf("Inserisci la parola Smaxi\n");
        for (i=0; ((max[i]=getchar())!='\n')&& i<len-1; i++);
        max[i]='\0';

        printf("Inserisci la parola Smini\n");
        for (i=0; ((min[i]=getchar())!='\n')&& i<len-1; i++);
        min[i]='\0';

        for (i=0; i<4; i++)
        {
            if(min[i]!=end[i] || max[i]!=end[i])
            b=1;
            else b=0;
        }
        if(b==1)
            {
            int s = Contiene(max,min);
            printf("La parola \"%s\" sta in \"%s\" esattamente %d volte\n",min,max,s);
             /* Aggiunto dopo la consegna */
            printf("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-\n\n");
            /*instringa(max,min); // chiamata alla funzione di Fra */  

            }
        else 
            printf("Ciao ciao\n");
    }
    while(b);
    return 0;
}