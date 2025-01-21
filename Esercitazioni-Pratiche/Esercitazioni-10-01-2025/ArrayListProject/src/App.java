/*
 * L'argomento di oggi sono le ArrayList (equivalenti alle liste di c#)
 * Le ArrayList sono anche loro classi generiche, quindi va definito il tipo di dato che dovranno accogliere (Possono accogliere un solo tipo di dato, sono anche loro omogenee)
 * Per la loro definizione si usa la stessa sintassi delle liste: ArrayList<String> nomeLista = new ArrayList<Stringa>();
 * Per inizializzare la lista con già dei valori dovrò usare la classe Arrays ed il metodo asList in questo modo:
    ArrayList<Integer> nomeLista = new ArrayList<>(Arrays.asList(1,2,3,4,5,)); (oppure aggiungere tra le graffe, dopo il costruttore, una serie di add.)
 * Per la manipolazione dei dati posso usare i metodi get(), set(), remove(), clear(), size().
 * Tranne clear e size gli altri prendono come parametro l'indice di dove voglio svolgere l'operazione e poi il valore (se devo sostituirlo o inserirlo per la prima volta)
 * Utilizzando il metodo add() su una cella che ha già un contenuto, questa verrà slittata avanti di uno per fare posto al dato che sto inserendo
 * Se non specifico le dimentsioni della lista, questa avrà una dimensione di 10 celle di base.
 * Abbiamo anche un metodo per controllare se nella lista c'è un determinato valore, ovvero Contains(valore/stringa), esso restituisce un boolean se c'è o meno l'elemento  
 * Il metodo isEmpty() ci permette di controlla se c'è almeno una cella (potrebbe essere anche vuota)
 * Il metodo indexOf(elemento) restituisce il primo index dell'elemento che stai cercando, se non trova nulla restituisce -1
 * L'interfaccia per le operazioni di base su una lista è la List<E>.
 * 
 * Implementa anche altre interfacce:
 *  RandomAccess: rende efficiente l'accesso tramite indice nella lista
 *  Clonable: Permette di creare una copia della lista tramite il metodo clone()
 *  Serializable: permette di salvare la lista in uno stream di byte per metterla in un file o mandare via internet (necessario per salvare su memoria permanente)
 *  AbstractList<E> : Per l'implementazione di liste, ci da lo scheletro di base
 * 
 * Gli ArrayList possono contenere solo i tipi boxati (conversione in oggetti, ma non è super inefficiente?), a quanto pare esistono anche in trove ed eclipse delle arraylist fatte
 * con dei valori primitivi (questi permettono di essere leggermente più veloci, ma sono da usare solo se necessario)
 * In java non possiamo usare i tipi primitivi nella creazione delle ArrayList perchè sono una funzionalità aggiunta dopo, inoltre la jvm cancella i dati relativi ai tipi generici al runtime.
 * 
 * Possiamo stampare direttamente l'intera ArrayList per vederne i valori usando il nome dell'ArrayList (immagino una sovrascrizione del ToString() ?) -> Si sovrascrive il ToString a partire dalla classe astratta 
 * AbstractCollection (è leggermente diverso da c# in cui le specifiche sono direttamente nella classe List<T>)
 * 
 * Per togliere un intero con il remove() da una cella devo fare una conversione esplicita ad un (Integer) oppure utilizzare il Integer.valueOf(int).
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("A quanto pare siamo liberi per il pomeriggio. Passo a studiare gli eventi in C#!"); 
    }
}
