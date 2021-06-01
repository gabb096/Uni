/* Una relazione binaria R su un insieme A `e un sottoinsieme del prodotto cartesiano A × A. 
Conveniamo di scrivere, come sempre, R(x, y) per indicare che la coppia (x, y) è nella relazione R, 
cioè (x, y) ∈ R. Una matrice quadrata di interi MR di dimensione n × n contenente valori 0, 1 può 
rappresentare una relazione binaria R su un insieme finito di n elementi A = {a0, ...an−1} 
stipulando che MR[i][j] = 1 se e solo se R(ai,aj) vale. Ricordiamo che R è transitiva se ∀x, y, z, 
R(x, y) ∨ R(y, z) ⇒ R(x, z). Vista sulla matrice, per tutte le terne di indici, ogni qualvolta nella 
matrice di input si abbia MR[i][j] = 1 e MR[j][k] = 1 allora anche MR[i][k] = 1.
Scrivere una funzione int Transitiva(int M[][SIZE], int * n1, int *n2, int *n3) che, 
prende in input la matrice corrispondente alla relazione, e verifica se la relazione `e transitiva 
(restituisce 1 oppure 0). Nel caso in cui non sia transitiva, le variabili n1, n2 ed n3 dovranno 
contenere una tripla di elementi per cui non vale la proprietà.
• Scrivere un programma in C che:
1. Genera una matrice 15x15 a valori interi random tra 0,1
2. Stampa la matrice ben formattata sullo schermo.
3. Utilizza la funzione Transitiva e scrive se la matrice generata corrisponde ad una relazione
transitiva o, nel caso contrario scrive sullo schermo una terna di elementi x, y, z per cui non vale
la proprietà transitiva.
4. Modifica la matrice M in modo che la relazione sia valida per le tre coppie (x, y), (y, z), (x, z).
5. (opz) Ripete i punti 3. e 4. finchè la matrice non rappresenti una relazione transitiva.
6. (opz) Ristampa la matrice, scrivendo quante modifiche sono state apportate alla matrice originaria. */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 5

void inizializzaMatrice(int m[][SIZE],int dim)
{
    srand(time(NULL));
    for(int i=0; i<dim; i++)
    {
        for(int j=0; j<dim; j++)
        {
            m[i][j] = rand()%2;
        }
    }
}

void stampa(int m[][SIZE],int dim)
{
    for(int i=0; i<dim; i++)
    {
        printf("|");
        for(int j=0; j<dim; j++)
        {
            printf("%3d",m[i][j]);
        }
        printf(" |\n");
    }
}

int Transitiva(int m[][SIZE], int *n1, int *n2, int *n3)
{
    for(int x=0; x<SIZE; x++)
    {
        for(int y=0; y<SIZE && y!=x; y++)
        {
            for(int z=0; z<SIZE && z!=y; z++)
            {
                if( ( m[x][y]==1 || m[y][z]==1 ) && m[x][z]==1)
                {
                    *n1 = x;
                    *n2 = y;
                    *n3 = z;
                }
                else
                {
                    *n1 = x;
                    *n2 = y;
                    *n3 = z;
                    return 0;
                }
            }
        }
    }
    return 1;
}

void RendiTransitiva(int m[][SIZE])
{
    int x,y,z;
    int c=0;
    int a = Transitiva(m, &x, &y, &z);
    while(a==0)
    {
        if(m[x][y]==1 || m[y][z]==1)
            m[x][z]=1;
        else 
            if(m[x][y]==0 || m[y][z]==0)
                m[x][y]=1;

        a = Transitiva(m, &x, &y, &z);
        c++;
        if(c>200)
            {
                printf("c=%d\n",c);
                a=1;
            }
    }
}

int main()
{
    int matrice[SIZE][SIZE];
    inizializzaMatrice(matrice, SIZE);
    stampa(matrice, SIZE);
    int n1, n2, n3;
    int a = Transitiva(matrice, &n1, &n2, &n3);
    if(a==0)
        printf("La matrice non è transitiva\nEcco 3 coppie che lo dimostrano\n");
    else
       printf("La matrice è transitiva\nEcco 3 coppie che lo dimostrano\n");
    
    printf("x=%d, y=%d, z=%d\n",n1,n2,n3);
    printf("(%d,%d) = %d\n",n1,n2,matrice[n1][n2]);
    printf("(%d,%d) = %d\n",n2,n3,matrice[n2][n3]);
    printf("(%d,%d) = %d\n",n1,n3,matrice[n1][n3]);
    if(a==0)
    {
        printf("\nOra la rendiamo transitiva\n");
        RendiTransitiva(matrice);
        a = Transitiva(matrice, &n1, &n2, &n3);
        stampa(matrice, SIZE);
        if(a==0)
            printf("La matrice non è transitiva\nEcco 3 coppie che lo dimostrano\n");
        else
            printf("La matrice è transitiva\nEcco 3 coppie che lo dimostrano\n");
        
        printf("x=%d, y=%d, z=%d\n",n1,n2,n3);
        printf("(%d,%d) = %d\n",n1,n2,matrice[n1][n2]);
        printf("(%d,%d) = %d\n",n2,n3,matrice[n2][n3]);
        printf("(%d,%d) = %d\n",n1,n3,matrice[n1][n3]);
    }
    return 0;
}