/*cose varie con le liste*/

#include <stdio.h>

struct nodo
{
    char nome;
    int array [5];
    struct nodo * next;
};

typedef struct nodo Nodo; //non devo scrivere sempre struct nodo, ora basta Nodo
typedef  Nodo * PNodo; // idem per il puntatore a tipo nodo, non serve  *

void cazzoPuntatore(int * numero)
{
    *numero = 7;
}

int main()
{
    int g = 5;
    printf("prima S = %d\n",g);
    cazzoPuntatore(&g);
    printf("dopo  S = %d\n",g);
    
    return 0;
}