/* Scrivere un programma che genera (utilizzando un a funzione apposita)1000 
numeri random compresi tra -100 e 100 e scrive in output: 
quanti sono rispettivamente i numeri positivi/negativi/nulli 
quanti sono rispettivamente i numeri pari/dispari 
quante coppie di numeri consecutivi uguali sono state generate */

#include <stdio.h>
#include <time.h>

int random();

int main()
{
    srand(time(NULL));
    int positivi=0, nulli=0, negativi=0, pari=0, dispari=0, consecutivi=0;
    int a,b=900,t;
    for(int i=0;i<1000;i++)
    {
        a=random();

        if(a>0) 
            positivi++;
        else   
            if(a==0) 
                nulli++;
            else 
                negativi++;

        if(a%2==0) 
            pari++;
        else 
            dispari++;

        if(a==b)
            consecutivi++;
        b=a;
    }
    printf("Di 1000 numeri generati abbiamo :\n");
    printf("%d numeri positivi\n",positivi);
    printf("%d numeri nulli\n",nulli);
    printf("%d numeri negativi\n",negativi);
    printf("%d numeri pari\n",pari);
    printf("%d numeri dispari\n",dispari);
    printf("e sono usciti %d volte numeri consecutivi\n",consecutivi);

}

int random()
{
    return (rand()%201)-100;
}
