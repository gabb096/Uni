/* Si progetti una funzione in C che, data una lista P di punti del piano cartesiano, 
restituisce la sottolista di P contente solo i punti che si trovano all’interno del quadrato 
piu` piccolo con centro in (0, 0) contenente il primo punto della lista P.
1. Si definisca il tipo nodo lista adatto per la lista P.
2. Si implementi in C una funzione denominata InQuadrato, che prende in input la lista di punti P 
    e restituisce la lista P modificata come spiegato in precedenza. La funzione non deve creare nuovi 
    nodi ma deve utilizzare quelli della lista di input ed inoltre deve essere preservato l’ordinamento 
    dei nodi rispetto alla lista originale.
Suggerimento: si scorra la lista P e, dopo aver individuato il lato del quadrato, 
si cancellino tutti i nodi che non stanno all’interno del quadrato. */


//NON FUNZIONA


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct nodo
{
    int x;
    int y;
    struct nodo * next;
};

typedef struct nodo Nodo;
typedef  Nodo * PNodo;

void inserisciInTesta(PNodo primo, int Xval, int Yval)
{
    PNodo temp;
    temp = (PNodo)malloc(sizeof(Nodo));
    temp -> x = Xval;
    temp -> y = Yval;
    temp -> next = primo;
    primo = temp;
}

void stampaLista(PNodo p)
{
    if(p==NULL)
        printf("Lista vuota");
    else
        {
            printf("(%d,%d) -> ",p->x,p->y);
            p = p->next;
            while(p!=NULL)
            {
                printf("(%d,%d) -> ",p->x,p->y);
                p = p->next;
            }   
            printf("NULL\n");
        }   
}

void InQuadrato(PNodo p)
{
    int lato;
    PNodo pre = p, temp;
    if(p->x >= p->y)
        lato = p->x;
    else   
        lato = p->y;
    printf("Il lato del quadrato è %d\n",lato);
    p=p->next;
    while(p != NULL)
    {
        printf("Esamino il punto (%2d,%2d) ==>  ",p->x, p->y);
        if(p->x >= lato || p->y >= lato)
        {
            printf("Lo elimino\n");
            temp = p;
            pre->next = p->next;
            p = p->next;
            free(temp);
        }
        else
        {
            printf("Vado avanti\n");
            pre = p;
            p = p->next;
        }
    }
}

int main()
{
    PNodo pstart = NULL;
    int len = 5;
    int max = 11;
    srand(time(NULL));

    for(int i=0; i<len; i++)
    {  inserisciInTesta(pstart, rand()%max,rand()%max);  }
    
    stampaLista(pstart);
    InQuadrato(pstart);
    printf("\n");
    stampaLista(pstart);

    
    return 0;
}