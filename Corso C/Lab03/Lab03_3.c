/*Scrivere un programma che legge un valore di tipo double, uno di tipo char 
e poi ancora uno di tipo double e infine fa in modo che: 
se il carattere letto è '+' allora stampa la somma dei due valori numerici; 
se il carattere è '*' allora stampa il prodotto dei due valori numerici; 
se è un altro carattere allora stampa un messaggio di errore.
(Utilizzare l'istruzione if..else) ATTENZIONE a svuotare il buffer dopo l'immissione dell'int.*/
#include <stdio.h>

int main()
{
    double num1;
    char op, buf;
    double num2;

    printf("Inserisci un numero double (es. 3.5 no con la virgola)\n");
    printf("Primo numero : ");
    scanf("%lf",&num1);
    printf("Inserisci + per sommare o * per moltiplicare)\n");
    printf("Operazione : ");
    scanf("%c",&buf);
    scanf("%c",&op);
    
    while(op != '+' && op != '*')
    {

        printf("Nope\nInserisci + per sommare o * per moltiplicare)\n");
        printf("Operazione : ");
        scanf("%c",&buf);
        scanf("%c",&op);
    }
     printf("Inserisci un altro numero double\n");
    printf("Secondo numero : ");
    scanf("%lf",&num2);

    if(op=='+')
    printf("Hai selezionato la somma\n%lf + %lf = %lf\n",num1,num2,num1+num2);

    else if(op=='*')
    printf("Hai selezionato la moltiplicazione\n%lf x %lf = %lf\n",num1,num2,num1*num2);
    

    
    printf("\n");
    return 0;
}