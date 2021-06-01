/*Nel linguaggio enigmistico un lucchetto è un gioco caratterizzato dallo schema XY + Y Z ⇒ XZ. 
In pratica si trovano due parole w1 e w2 in cui l’ultima parte (un suffisso) di w1 è uguale 
alla prima parte (un prefisso) di w2. Eliminando le parti in comune e leggendo il restante 
si ottiene la terza parola w3 che si chiama ”lucchetto”.
Per esempio:
CANE/NERO = CARO; VELA/LANA = VENA; CRISTALLO/STALLONE = CRINE; RISCHIO/SCHIOCCO = RICCO;
MAGGIO/GIOIA = MAGIA; CARATO/ATOMI = CARMI; CAST/TERME = CASERME; MATCH/CHADOR = MATADOR.
•Scrivere una funzione int lungh( char s[]) che restituisce la lunghezza della stringa s;
•Scrivere una funzione int suff_pref( char s[], char t[], int n) che restituisce 1 se il suffisso
    di lunghezza n della stringa s `e uguale al prefisso di lunghezza n della stringa t e restituisce 0 
    in caso siano diversi. 
    (Essenzialmente la stringa s deve essere controllata a partire dalla posizione lungh(s)−n).
•Scrivere un programma che legge due stringhe e utilizzando la funzione precedente verifica se le due
    stringhe possono creare un lucchetto.
•(opzionale +3 punti) Il programma scrive un lucchetto tra le due parole (che ovviamente non deve
    necessariamente avere un senso come parola in italiano) .*/

#include <stdio.h>
#define max 20

int lungh( char s[])
{
    int i;
    for(i=0; s[i]!='\0'; i++);
    return i;
}

int suff_pref( char s[], char t[], int n)
{
    int m = lungh(s);
    for(int i=0; i<n;i++)
    {
        printf("%c___%c\n",s[m-n+i],t[i]);
        if(s[m-n+i] != t[i])
            return 0;
    }
    return 1;
}

int main()
{
    printf("LUCCHETTO\n");
    printf("Inserisci una parola\n");
    char str1[max];
    int i;
    for (i=0; ((str1[i]=getchar())!='\n')&& i<max-1; i++);
    str1[i]='\0';
    printf("Inseriscine un'altra con il prefisso uguale al suffisso di %s\n",str1);
    char str2[max];
    for (i=0; ((str2[i]=getchar())!='\n') && i<max-1; i++);
    str2[i]='\0';
    printf("Da quante lettere sono composti prefisso e suffisso?\n");
    scanf("%d",&i);
    int c = suff_pref(str1, str2, i);
    if(c==1)
    { 
        int l1 = lungh(str1), l2 =lungh(str2);
        printf("Le parole possono creare un lucchetto\nEccolo qui : ");
        for(int j=0; j<(l1-i); j++)
        {
            printf("%c",str1[j]);
        }
        for(int j=i; j<l2; j++)
        {
            printf("%c",str2[j]);
        }
        printf("\n");
    }
    else    
        printf("Le parole non possono creare un lucchetto\n");
    return 0;
}