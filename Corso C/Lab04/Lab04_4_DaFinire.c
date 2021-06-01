/*Scrivere un programma che calcola quanti sono i triangoli rettangoli 
con lati interi ≤ 500.
Opzionale : produrre in output tutte le terne pitagoriche trovate.*/

#include <stdio.h>
#include <math.h>

int main()
{
    double x;
    for(double i=0;i<500;i++)
    {
        for(double j=0;j<500;j++)
        {
            x=sqrt(i*i+j*j);
            if(x)
            {
                printf("");
            }
        }
    }
    
    return 0;
}