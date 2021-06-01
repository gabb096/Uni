/*Cambiamo le parole 2
Scrivere un programma che chiede all'utente di inserire una stringa 
e poi esegue su essa le seguenti funzioni:
ContaMaiuscole che data una stringa conta il numero di lettere maiuscole.
DopoPunto che dato un testo trasformi in maiuscole le lettere dopo il punto (se risultano minuscole).
Rafforza data una stringa (testo) in input ne crea un'altra raddoppiando 
    tutte le consonanti 'b', 'p,' e 't' che si trovano come inizi di parole.
Alla fine riscrive la stringa modificata sullo schermo.
*/

#include <stdio.h>
#define len 20
int ContaMaiuscole(char s[]);
void DopoPunto(char s[]);
void Rafforza(char s[], char s2[]);

int main()
{
    char stringa [len];
    printf("Inserisci una stringa, lunghezza massima %d\n",len);
    gets(stringa);
    printf("Nella tua stringa ci sono %d lettere MAIUSCOLE\n",ContaMaiuscole(stringa));
    DopoPunto(stringa);
    printf("Applico funzione DopoPunto\n%s\n",stringa);
    char stringa2 [len*2+1];
    Rafforza(stringa,stringa2);
    printf("Applico funzione Rafforza\n%s\n",stringa2);
    return 0;
}

int ContaMaiuscole(char s[])
{
    int i = 0,c=0;
    while(s[i]!='\0')
    {
        if(s[i]>='A' && s[i]<='Z')
            c++;
        i++;
    } 
    return c;
}
void DopoPunto(char s[])
{
    int i = 0,c=0;
    while(s[i]!='\0')
    {
        if(s[i] == '.' && s[i+1]>='a' && s[i+1]<='z')
            s[++i] -= 32;
        else 
            i++;
    }
}
void Rafforza(char s[], char s2[])
{
    int i, k = 0;
    for(i = 0; i < len; i++)
    {
        if(s[i] == 'b' || s[i] == 'p' || s[i] == 't'|| s[i] == 'B' || s[i] == 'P' || s[i] == 'T')
        {
            s2[k] = s[i];
            s2[k+1] = s[i];
            k += 2;
        }
        else
        {
            s2[k] = s[i];
            k++;
        }
    }
    s2[k] = '\0';
}