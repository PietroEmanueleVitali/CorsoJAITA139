/*
 * Oggi vedremo in aggiunta il ciclo while.
 * Il ciclo while è molto simile al do{...}while(condizione). 
 * Ci torna utile quando dobbiamo fare dei cicli solo nella presenza di una determinata condizione.
 * La sintassi è while(condizione)
 */
/* 
Scrivere un programma che chiede all'utente di inserire una serie di numeri positivi.
Se il numero inserito Ã¨ negativo, segnalare tramite una stampa che il numero non va bene
e non considerarlo nei calcoli.
Per terminare l programma indicare all'utente di scrivere 0.
Il programma deve:

- fare la somma dei numeri inseriti
- fare la somma dei numeri pari, solo i pari.
- contare qunti numeri dispari scrive l'utente

BONUS: trovare il numero maggiore inserito dall'utente.
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        int loop;
        int userNumber;
        int sumEvenNumbers = 0;
        int unevenNumbers = 0;
        int sumTotal = 0;
        int higherNumber = 0;

        do {
            System.out.println("Inserire un numero positivo per svolgere le operazioni o 0 per concludere:");
            userNumber = userInput.nextInt();

            while (userNumber < 0) {
                System.out.println("Numbero non valido, riprova:");
                userNumber = userInput.nextInt();
            }

            sumTotal += userNumber;
            sumEvenNumbers += ((userNumber % 2) == 0) ? userNumber : 0 ;
            unevenNumbers += ((userNumber % 2) == 1) ? 1 : 0;
            higherNumber = (higherNumber < userNumber) ? userNumber : higherNumber;

            System.out.println(String.format("""
                Somma totale: %s.
                Somma numeri pari: %s.
                Contatore numeri dispari: %s.
                Numero più alto: %s.

            """, sumTotal, sumEvenNumbers, unevenNumbers, higherNumber));


            }while(userNumber != 0);

    }
}
