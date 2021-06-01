/*
Una lista non è altro che un insieme di oggetti (di una qualche class o struct vostra) che tra le variabili membro hanno un puntatore 
ad un altro oggetto del suo stesso tipo. Questo puntatore solitamente si chiama next e punta all'oggetto successivo all'interno della lista.
Per scorrere una lista quindi basta sapere l'indirizzo del primo elemento, da questo elemento si può trovare il successivo 
utilizzando il puntatore next, da questo nuovo elemento si potrà trovare il successivo ancora utilizzando questo nuovo next, 
e così via fino a trovare un next nullo, il che vorrà dire che la lista è terminata.

Creare una struttura Stage che contenga i campi interi id e difficulty e un puntatore ad un oggetto di tipo Stage di nome next.
La struttura dovrà avere un costruttore che prende in input i valori da assegnare a id e difficulty e settare next a nullptr.
Nel main instanziare uno Stage (nella heap) con id pari a -1 e difficulty 0 assegnandolo ad un puntatore di nome head.
Dichiarare poi un puntatore ad un oggetto di tipo Stage (non assegnategli alcun valore per ora) di nome iter.
Inserire un loop infinito che chiede all'utente di inserire un char per selezionare una scelta tra:
a ---> "add a new stage"
r ---> "remove a stage"
q ---> "quit"
default ---> (non fa nulla)
*/
#include <iostream>


struct Stage
{
    int id;
    int dif;
    Stage* next;

    Stage(int i, int d)
    {
        id   = i;
        dif  = d;
        next = nullptr;
    }
}; //remembra il punto e virgola alla fine!

int main()
{
    using namespace std;

    bool loop = true;
    char input;
    int idIn;
    int difIn;
    int idToRemove;
    int len;

    Stage* FirstStage = new Stage(-1,0);//Se creo nella Heap deve essere un puntatore a sinistra
                                        //pStage sarà il puntatore al primo elemento
    Stage* iter;
    while(loop)
    {
        cout<<"Cosa vuoi fare?\na-> add a new stage \nr -> remove a stage \nq -> quit\n";
        cin>>input;
        switch (input)
        {
/*Nel caso (a) si richiede all'utente di inserire due interi, il primo per l'id e il secondo per la difficulty da assegnare al nuovo Stage. 
Bisognerà dunque scorrere tutta la lista con un ciclo (sfruttando il puntatore iter) e una volta arrivati alla fine aggiungere 
un nuovo elemento (assegnando il suo indirizzo al puntatore dell'ormai ex-ultimo elemento).
*/
        case 'a':
                cout<<"Adding new Stage, enter ID\n";
                cin>>idIn;
                cout<<"Adding new Stage, enter Difficulty\n";
                cin>>difIn;
                cout<<"Creating new Stage\n";
                iter=FirstStage;
                while (iter->next != nullptr) 
                {
                iter = iter->next;
                }
                iter->next = new Stage(idIn, difIn);
            break;
/*Nel caso (r) si richiede all'utente di inserire un intero indicante l'indice dell'elemento della lista da rimuovere. 
Bisognerà dunque scorrere tutta la lista con un ciclo (sfruttando il puntatore iter) e una volta arrivati all'indice interessato 
(ammesso e non concesso che sia possibile, se la lista è più corta stampare a schermo un messaggio "Elemento non trovato") 
ed eliminare tale elemento (assegnando il suo indirizzo al puntatore dell'ormai ex-ultimo elemento). Nel caso in cui l'indice sia zero, 
bisognerà eliminare l'elemento cui punta head. Ovviamente occorre prestare molta attenzione, se si elimina l'head, 
head dovrà puntare al "nuovo" primo elemento. Se si elimina l'elemento N, l'elemento N-1 dovrà puntare all'elemento N+1 !*/
        case 'r':
                cout<<"Enter id number to remove\n";
                cin>>idToRemove;
                iter=FirstStage;
                if(FirstStage->id==idToRemove)
                {
                    Stage* temp = FirstStage;
                    FirstStage = FirstStage->next;
                    delete temp;   
                }
                while(iter->next!=nullptr)
                {
                    if(iter->next->id != idToRemove)
                    iter=iter->next;
                    else if(iter->next->next!=nullptr)
                    {
                        Stage* temp = iter->next;
                        iter->next=iter->next->next;
                        delete temp;
                    }else //elimino l'ultimo elemento, quindi iter->next->next == nullptr
                    {
                        Stage* temp = iter->next;
                        iter->next=nullptr;
                        delete temp;
                    }
                }
            break;
/*Nel caso (q) bisognerà eliminare tutti gli elementi della lista.
Sia chiaro che quando scrivo "eliminare" intendo non solo rimuoverli dalla lista ma anche liberare la memoria con il delete*/
        case 'q':   
                iter=FirstStage;
                while(iter->next!=nullptr)
                {
                    Stage* temp = iter;
                    iter = iter->next;
                    delete temp;
                }
                delete FirstStage;
                loop=false;
            break;
        
        case 'l': // dovrebbe dire la lunghezza della lista
                iter=FirstStage;
                len=0;
                while(iter->next!=nullptr)
                {
                    iter=iter->next;
                    len++;
                }
                cout<<"Lunghezza lista: "<< len <<endl;
            break;

        default : 
            break;
        }
    }
iter=FirstStage;
len=0;
while(iter->next!=nullptr)
{
iter=iter->next;
len++;
}
cout<<"Lunghezza lista: "<< len <<endl;
cout<<"the end\n";
return 0;
}