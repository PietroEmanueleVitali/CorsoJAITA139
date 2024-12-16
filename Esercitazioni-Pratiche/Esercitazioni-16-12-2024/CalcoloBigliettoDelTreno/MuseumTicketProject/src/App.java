/*
 *  Scrivere un programma che calcoli il prezzo del biglietto che un utente deve pagare per accederee alle sale di un museo (al MOMA).
 *  Il prezzo intero è di 30$.
 *  È possibile offrire riduzioni del prezzo del biglietto a seconda di determinate condizioni (gli sconti sono cumulabili):
        -> Cliente residente a new york, entra gratis
        -> Cliente sotto i 12 anni o sopra i 65 anni, diritto ad uno sconto del 50%
        -> Cliente studente, diritto ad uno sconto di 5$
    Calcolare il prezzo del biglietto cercando di offrirgli il prezzo più conveniente.
 */
/*
 * Gli if piatti (indipendenti gli uni dagli altri), sono utilizzati quando è necessario verificare ogni condizione presente.
 * In sequenza gli if piatti possono essere efficaci, ma se una condizione mi permette di saltare le altre, è meglio non farlo.
 * 
 * Operatorie ternario: funzione che permette, in base ad una condizione, di aggiornare i valori di una variabile (o settarla).
 * La sintassi è: condizione ? valoreSeVero : valoreSeFalso;
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        String userName;
        int age;
        float price = 30F;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Benvenuto nel sito del nostro museo, inserisca il suo nome:");
        userName = userInput.next();

        System.out.println(String.format("Grazie %s, ora ti porremo qualche domanda (premere invio per continuare)", userName));
        System.in.read();
        
        System.out.println("Sei residente a New York? Rispondi con si o con no");
        price = (userInput.next().equalsIgnoreCase("si")) ? (price = 0) : price;

        if(price != 0)
        {
            System.out.println("Quanti anni hai?");
            age = userInput.nextInt();
            price = age <= 12 || age >= 65 ? (price/2) : price;

            System.out.println("Sei uno studente? Rispondi con si o con no");
            price = (userInput.next().equalsIgnoreCase("si")) ? (price - 5) : price;

            System.out.println(String.format("Grazie %s per le tue risposte, il prezzo per l'ingresso è %s$", userName, price));
            System.out.println("Premere per andare al pagamento");
            System.in.read();
        }
        else 
        {
            System.out.println(String.format("Grazie %s, per lei l'accesso al museo è gratuito.", userName));
            System.out.println("Premere per continuare");
            System.in.read();
        }
        
        




        

        



    }
}
