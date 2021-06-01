#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void stampaVettore(int v[],int s)
{
    printf("[");
    for(int i=0;i<s;i++)
    {
        if(i>1 && i%11==0) 
            printf("\n");
        if(i==0)
            printf("%d,",v[i]);
        else 
            if(i!=s-1)    
                printf(" %2d,",v[i]);
            else
                printf("%3d",v[i]);
    }
    printf("]\n");
}

int SelectMinSort(int v[], int s) // crescente
{
int i, j, MinIndex, t, con=0;
stampaVettore(v,s);
    printf("\n");
    for( i=0; i<s-1; i++)
    {
        MinIndex = i;
        for( j=i+1; j<s; j++)
        {
            if(v[j]<v[MinIndex])
            {
                MinIndex = j;
                con++;
            }
            else
                con++;
        }
        t = v[MinIndex];
            v[MinIndex] = v[i];
            v[i] = t;
            con++;
        stampaVettore(v,s);
    }
    return con;
}


int main()
{
    srand(time(NULL));
    int n=10;
    int vect[]= {50, 37, 41, 82, 53, 93, 58, 17, 17, 99};
    
    SelectMinSort(vect,n);
}