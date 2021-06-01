/* Gabriele Leva
programma base per liste
*/
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

 struct nodo 
 {
    int info;
    struct nodo *next;
 };

  typedef struct nodo Nodo;
  typedef  Nodo* PNodo;

PNodo crea_lista_rand() 
{
  Nodo *p, *start;
  int i, n;
  srand(time(NULL));

  start = NULL;
  printf("Numero di elementi? ");
  scanf("%d", &n);

  for (i=0; i<n; i++) 
  {
    p = malloc(sizeof(struct nodo));
    p->info=rand()%50+1;
    p->next = start;
    start = p;
  }
  return start;
}

PNodo crea_lista_inser() 
{
  Nodo *p, *start;
  int i, n, elem;

  start=NULL;

  printf("\nAttenzione\nL'inserimento avviene in testa,\n");
  printf("L'ordine è inverso a quello di inserimento\n");
    
  printf("Numero di elementi?\n");
    
  scanf("%d", &n);
    
  for (i=0; i<n; i++) 
  {
    p = malloc(sizeof(struct nodo));
    printf("\nInserisci elemento:  ");
    scanf("%d", &elem);
    p->info=elem;
    p->next = start;
    start = p;
  }

  return(start);
}

void stampa_lista(Nodo *p) 
{
  while (p != NULL) 
  {
    printf("%d --> ", p->info);
    p = p->next;
  }
  printf("NULL\n");
}

int controlloSottolista(Nodo *p1, Nodo *p2)
{
  while(p1!=NULL && p2!=NULL)
  {
    if(p1->info == p2->info)
    {
      //p1=p1->next; volendo non serve (Correzione)
      p2=p2->next;
      if(p2==NULL)
        return 1;
    }
    //else    volendo non serve (Correzione)
      p1=p1->next;
  }
  return 0;
}

int main() 
{
  Nodo  *l1, *l2, *l3;
  int i,j;
  l1 = crea_lista_rand();
  printf("\nLa lista generata e':\n");
  stampa_lista(l1);
  l2=crea_lista_inser();
  printf("\nLa lista generata e':\n");
  stampa_lista(l2);
  if(controlloSottolista(l1,l2)==1)
    printf("Ottimo, la tua lista è sottolista della lista random\n\n");
  else 
  printf("La tua lista non è sottolista della lista random\n\n");

  return 0;
}
