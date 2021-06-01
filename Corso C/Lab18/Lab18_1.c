/*Aggiungere le seguenti funzioni al programma eseListaBase.cpp:
Cancellazione di TUTTE le occorrenze di un certo elemento nella lista.
    Nota: Fare attenzione al caso in cui dovranno essere eliminati "tanti" elementi iniziali.
Ricerca di un elemento nella lista : restituisce eventualmente la posizione
Inserimento in coda alla lista MA SOLO se l'elemento non è già presente
Eliminazione di tutti gli elementi DUPLICATI di una lista. 
    Alla fine ogni elemento deve essere presente al più una volta nella lista. 
    (per provarlo generare una lista lunga e con pochi valori random)*/
    
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <time.h>

  struct nodo {
  int info;
  struct nodo * next;
  };

  typedef struct nodo Nodo;
  typedef  Nodo * PNodo;
 // typedef  Nodo *Lista; un puntatore a un nodo � una lista!

void menu(void)
{
   printf("\nOperazioni possibili:\n"
        "   1 per inserire un elemento in testa\n"
        "   2 per inserire un elemento in coda\n"
        "   3 per cancellare un elemento\n"
        "   4 per cancellare tutte le occorrenze di un certo elemento\n"
        "   5 per cercare un elemento\n"
        "   0 per uscire\n");
}

int listaVuota(PNodo l)
{ 
    return l == NULL; 
}

void inizializza(PNodo *l) 
{
    *l = NULL; 
}

PNodo inizializzaA()
{
    return NULL; 
}

PNodo inserisciInTestaA(PNodo l, int el)
{
    Nodo *temp;
    temp = (PNodo) malloc(sizeof(Nodo));
    temp ->info = el;
    temp ->next = l;
    return temp;
}

void inserisciInTesta(PNodo *l, int el)
{
    PNodo temp;
    temp = (PNodo) malloc(sizeof(Nodo));
    temp->info = el;
    temp->next = *l;
    *l=temp;
}

void inserisciInTesta2(PNodo *l, int el) // versione con controllo disponibilit� memoria
{
    Nodo *temp;
    temp = (PNodo) malloc(sizeof(Nodo));
    if (temp != NULL) 
    {
        temp->info = el;
        temp->next = *l;
        *l=temp;
    }
    else
    printf("memoria esaurita!\n");
}

PNodo inserisciInCodaA(PNodo l, int el) 
{
    Nodo *temp, *p;
    temp = (PNodo) malloc(sizeof(Nodo));
    temp->info = el;
    temp->next = NULL;
    if (listaVuota(l))
        return temp;
    else
    {
        p = l;
        while(p->next!=NULL)
            p=p->next ;
        p->next=temp;
    return l;
    }
}

void inserisciInCoda(PNodo *l, int el) 
{
    Nodo *temp, *p;
    temp = (PNodo) malloc(sizeof(Nodo));
    temp->info = el;
    temp->next = NULL;
    if (listaVuota(*l))
        *l = temp;
    else 
    {
        p=*l;
        while(p->next!=NULL) // scorro la lista fino alla fine
            p=p->next ;
        p->next=temp;
    }
}

void inserisciInCoda2(PNodo *l, int el) // altra versione per inserisci in coda
{
    Nodo *p;
    if (listaVuota(*l)) 
    {
        *l = (PNodo) malloc(sizeof(Nodo));
        (*l)->info = el;
        (*l)->next = NULL;
    }
    else 
    {
        p=*l;
        while(p->next!=NULL) // scorro la lista fino alla fine
            p=p->next ;
        p->next = (PNodo)malloc(sizeof(Nodo));
        p->next->info = el;
        p->next->next = NULL;
    }
}

PNodo inserisciInCodaARicors(PNodo l, int el) //inserimento   alla fine della lista in versione ricorsiva alternativa
{   
    Nodo *temp;
    if (listaVuota(l)) 
    {
        temp = (PNodo) malloc(sizeof(Nodo));
        temp->info = el;
        temp->next = NULL;
        return temp;
    }
    else 
    {
        l->next = inserisciInCodaARicors(l->next, el);
    return l;
    }
}

void inserisciInCodaRicors(PNodo *l, int el) //inserimento   alla fine della lista in versione  ricorsiva
{
    if (listaVuota(*l)) 
    {
        *l = (PNodo) malloc(sizeof(Nodo));
        (*l)->info = el;
        (*l)->next = NULL;
    }
    else
        inserisciInCodaRicors( &((*l)->next), el);
}

PNodo cancellaA(PNodo l, int el) 
{
    Nodo *temp, *puntCorr , *puntPrec ;
    if(listaVuota(l)) 
        return l;
    if(l->info==el) 
    { //devo cancellare il primo elemento
        temp = l;
        l = l->next;
        free(temp);
    }
    else 
    { //non cancello il primo elemento
        puntPrec=NULL;
        puntCorr =l;
        while( puntCorr !=NULL && puntCorr->info!=el)
        {
            puntPrec = puntCorr;
            puntCorr=puntCorr->next;
        }
    }
    if(puntCorr!=NULL && puntCorr->info==el) 
    {
        temp=puntCorr;
        puntPrec->next = puntCorr->next;
        free(temp);
    }
    return l;
}

int cancella(PNodo *l, int val) //cancellazione del valore val dalla lista
{
   PNodo temp, q1,q2;
   if (val == (*l)->info) //se val è nel primo nodo
    {
        temp = *l;
        *l = (*l)->next;
        free(temp);/* libero la memoria del nodo cancellato */
        return 1;
    }
   else // val non era il primo nodo
   {
        q1 = *l;
        q2 = q1->next;

        while ((q2 != NULL) && (q2->info != val)) //vado avanti finche' trovo la posizione o fine lista
        {
            q1 = q2;
            q2 = q1->next;
        }
        if (q2 != NULL)  // sono uscito al while perché ho trovato val
        {    
            temp = q2;
            q1->next = q2->next;
            free(temp);             // libero la memoria del nodo cancellato
            return 1;
        }
       else
            return 0;  //non ho trovato il nodo con elemento da cancellare

   }
}

PNodo crea_lista(int s) 
{
    Nodo  *inizio; // o alternativamente PNodo inizio;
    int i, n;
    inizio = NULL;

    srand(time(NULL));

    for (i=0; i<s; i++) 
    {
        n=1 + rand()%100;
        inserisciInTesta(&inizio,n); //o inizio=inserisciInTestaA(inizio,n);
    }
    return(inizio);
}

void stampa_lista(PNodo p) 
{
    while (p != NULL) 
    {
        printf("%d --> ", p->info);
        p = p->next;
    }
        printf("NULL\n");
}

int ricorrenza_elemento(PNodo *l, int val)
{
    int c=0;
    PNodo temp = *l;
    while(temp->next != NULL || temp->next->next != NULL )
    {
        if(temp->info==val)
            c++;
        temp->next = temp->next->next;
    }
    return c;
}

int main()
{
   PNodo pstart = NULL;
   int scelta;
   int item;
   int s;

   printf("Quanti elementi vuoi inserire nella lista?:   ");
   scanf("%d",&s);

   printf("\n\nEcco una lista  di %d interi generata casualmente: \n ",s);

   pstart = crea_lista(s);
   stampa_lista(pstart);

   menu();
   printf("  _");
   scanf("%d", &scelta);

   while (scelta != 0) 
   {
      switch (scelta) 
      {
        case 1:
            printf("Inserisci un intero: ");
            scanf("\n%d", &item);
            inserisciInTesta(&pstart, item);
            stampa_lista(pstart);
            break;
        case 2:
            printf("Inserisci un intero: ");
            scanf("\n%d", &item);
            inserisciInCoda(&pstart, item);
            stampa_lista(pstart);
            break;
        case 3:
            if (!listaVuota(pstart)) 
            {
                printf("Inserisci un intero da cancellare: ");
                scanf("\n%d", &item);

                if (cancella(&pstart, item))
                {
                    printf("%d cancellato.\n", item);
                    stampa_lista(pstart);
                }
                else
                    printf("%d non presente.\n\n", item);
            }
            else
               printf("La lista e' vuota.\n\n");
            break;
        case 4:
            if (!listaVuota(pstart)) 
            {
                printf("Inserisci un intero da cancellare: ");
                scanf("\n%d", &item);
                int n=ricorrenza_elemento(&pstart,item);
                if(n!=0)
                {
                    while(n>0)
                        {
                            cancella(&pstart, item);
                            n--;
                        }
                    stampa_lista(pstart);
                }
                else
                    printf("%d non presente.\n\n", item);
            }
            else
               printf("La lista e' vuota.\n\n");
            break;
        default:
                printf("Scelta non valida.\n\n");
                menu();
            break;
        }
        printf("nuova scelta? ");
        scanf("%d", &scelta);
    }
    printf("arrivederci\n");
    return 0;
}