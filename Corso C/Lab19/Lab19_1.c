/*Si scriva una programma C che prende in input dall'utente una str1 a e ne ricopia il contenuto 
in una str1 b sostituendo ciascuna occorrenza dei numeri da 0 a 9 con il corrispondente numero 
scritto a parole ("zero", "uno", ...., "nove"). Stampare poi la str1 b .
Ad esempio, se la str1 a è la seguente:
      Ho avvistato 3 aquile e 2 falchi.
il programma deve inserire nella str1 b il testo
      Ho avvistato tre aquile e due falchi. */

#include <stdio.h>
int main()
{
    int i;
    int len = 30;
    char str1[len];
    char del; 
    printf("Inserisci una str1 max %d caratteri\n",len-1);
    printf("Cambio i numeri in lettere\n");
    for (i=0; ((str1[i]=getchar())!='\n')&& i<len-1; i++);

    str1[i]='\0';
    int c=0;
    for(i=0; i<len-1;i++)
        {
            switch (str1[i])
            {
            case '1': c+=3; break;
            case '2': c+=3; break;
            case '3': c+=3; break;
            case '4': c+=7; break;
            case '5': c+=6; break;
            case '6': c+=3; break;
            case '7': c+=5; break;
            case '8': c+=4; break;
            case '9': c+=4; break;
            default:
                break;
            }
        }
    
    char str2 [len+c];

    for(int i=0,k=0; i<len+c;i++)
    {
        switch (str1[i])
            {
            case '1':
                str2[k++]='u';str2[k++]='n';str2[k++]='o';
                break;
            case '2':
                str2[k++]='d';str2[k++]='u';str2[k++]='e';
                break;
            case '3':
                str2[k++]='t';str2[k++]='r';str2[k++]='e';
                break;
            case '4':
                str2[k++]='q';str2[k++]='u';str2[k++]='a';
                str2[k++]='t';str2[k++]='t';str2[k++]='r';str2[k++]='o';
                break;
            case '5':
                str2[k++]='c';str2[k++]='i';str2[k++]='n';
                str2[k++]='q';str2[k++]='u';str2[k++]='e';
                break;
            case '6':
                str2[k++]='s';str2[k++]='e';str2[k++]='i';
                break;
            case '7':
                str2[k++]='s';str2[k++]='e';str2[k++]='t';
                str2[k++]='t';str2[k++]='e';
                break;
            case '8':
                str2[k++]='o';str2[k++]='t';str2[k++]='t';str2[k++]='o';
                break;
            case '9':
                str2[k++]='n';str2[k++]='o';str2[k++]='v';str2[k++]='e';
                break;
            default:
                str2[k++]=str1[i];
                break;
            }    
    }
        printf("%s\n",str2);
}
