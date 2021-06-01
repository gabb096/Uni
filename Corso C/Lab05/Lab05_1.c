/*Scrivere un programma che chiede all’utente di inserire tre numeri interi 
giorno, mese, anno corrispondenti ad una data e poi controlla se si tratta 
di una data valida. 
(Il giorno del mese deve essere "compatibile" con il mese secondo la nota 
filastrocca e non dimenticare gli anni bisestili!) 
Usare una istruzione switch .
Se la data è valida la riscrive, scrivendo il mese "a parole". 
Se la data non è valida, sullo schermo si scrive anche il perchè.
(Da realizzare utilizzando l' istruzione switch . )
Si ricorda che gli anni bisestili sono quelli divisibili per 4, 
con eccezione dei secoli che devono essere divisibili per 8 
(ad esempio il 1900 non è stato bisestile). 
Assumiamo valori di anno validi a partire dall'inizio del calendario gregoriano 
1582 e fino al 2100.*/

#include <stdio.h>

int main()
{
    int x=1;
    int giorno, mese, anno;
    printf("Inserisci il giorno : ");
    scanf("%d",&giorno);
    printf("Inserisci il mese : ");
    scanf("%d",&mese);
    printf("Inserisci l'anno : ");
    scanf("%d",&anno);
while(x==1)
    {
        if(anno<1582)
        {
        printf("Anno non disponibile\nCalendario non ancora inventato\n");
        printf("Inserisci l'anno giusto : ");
        scanf("%d",&anno);
        }
        else if(anno>2100)
        {
        printf("Il pianeta non arriverà così lontano... \nNon te lo calcolo nemmeno\n");
        printf("Inserisci l'anno giusto : ");
        scanf("%d",&anno);
        }
        else
        {
            switch (mese)
            {
                case 1:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Gennaio non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Gennaio %d\n",giorno,anno);
                            x=0;                
                        }
                        
                    break;
                case 2:
                        if(giorno<0 || (anno%4==0 && giorno>29) || (anno%4!=0 && giorno>28))
                        {
                            printf("Febbraio non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Febbraio %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case 3:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Marzo non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Marzo %d\n",giorno,anno);
                            x=0;                
                        } 
                        break;
                case 4:
                        if(giorno<0 || giorno>30)
                        {
                            printf("Aprile non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Aprile %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case 5:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Maggio non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Maggio %d\n",giorno,anno);
                            x=0;                
                        }
                     break;
                case 6:
                       if(giorno<0 || giorno>30)
                        {
                            printf("Giugno non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else
                        {
                            printf("Hai inserito %d Giugno %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case 7:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Luglio non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Luglio %d\n",giorno,anno);
                            x=0;                
                        }
                    break; 
                case 8:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Agosto non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Agosto %d\n",giorno,anno);
                            x=0;                
                        }
                    break; 
                case 9:
                       if(giorno<0 || giorno>30)
                        {
                            printf("Settembre non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Settembre %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case 10:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Ottobre non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Ottobre %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case 11:
                       if(giorno<0 || giorno>30)
                        {
                            printf("Novembre non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Novembre %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case 12:
                        if(giorno<0 || giorno>31)
                        {
                            printf("Dicembre non ha %d giorni zi...\n",giorno);
                            printf("Inserisci un giorno decente : ");
                            scanf("%d",&giorno);
                            break;
                        }
                        else 
                        {
                            printf("Hai inserito %d Dicembre %d\n",giorno,anno);
                            x=0;                
                        }
                    break;
                case -1: 
                        x=0;
                    break;  
                default:
                        printf("Dude... Uncool\n");
                        printf("Metti un mese decente : ");
                        scanf("%d",&mese);
                    break;
            }
        }
    }
    return 0;
}