        /* Esercizio: VacanzeJava    ===========================================
Creare un programma che calcoli il prezzo dei biglietti dell'aereo 
in base all'input dell'utente

Chiedere:
1) Quante persone andranno in vacanza.
2) Quanti persone minori di 14 anni
    (Segnalare errore in caso risulti essere maggiore del totale delle persone)
3) La destinazione
4) Il mese di partenza

Il prezzo base cambia a seconda della destinazione:
europa: 300 €
africa: 500 €
asia: 600 €
america: 700 €
altro: 800 €

a seconda del mese di partenza c'è un moltiplicatore diverso al prezzo base:
dicembre-gennaio-febbraio:
* 1.2
marzo-aprile-maggio:
* 1.5
altro:
* 1.8

*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner userInput = new Scanner(System.in);
        float ticketPrice = 0.0f;
        float ticketMulti = 0.0f;
        String month;
        float priceForAll;
        float priceForOne;
        float priceForOneMinor;
        String meta;
        int numberOfPeople;
        int peopleUnderAge;

        System.out.println("Quante persone verranno in vacanza?");
        numberOfPeople = userInput.nextInt();

        System.out.println("Quante di queste hanno più di 14 anni?");
        peopleUnderAge = numberOfPeople - userInput.nextInt();

        while(peopleUnderAge < 0)
        {
            System.out.println("errore");
            System.out.println("Il numero dei maggiorenni non può essere superiore al numero dei passeggeri, riprovare:");
            peopleUnderAge = numberOfPeople - userInput.nextInt();
        }

        System.out.println("""
            Selezionare la meta:
            -> Europa
            -> Africa
            -> Asia
            -> America
            -> Altro                  
        """);
        meta = userInput.next();

        while(ticketPrice == 0.0f)
        {
        if(meta.equalsIgnoreCase("europa"))
        {
             ticketPrice = 300F;
        }
        else if (meta.equalsIgnoreCase("africa"))
        {
            ticketPrice = 500F;
        }
        else if (meta.equalsIgnoreCase("asia"))
        {
            ticketPrice = 600F;
        }
        else if (meta.equalsIgnoreCase("america"))
        {
            ticketPrice = 700F;
        }
        else if (meta.equalsIgnoreCase("altro"))
        {
            ticketPrice = 800F;
        }
        else 
        {
            System.out.println("Seleziona una meta valida");
            meta = userInput.next();
        }
        }

        System.out.println("""
            In quale mese vorreste partire?
            Gennaio
            Febbraio
            Marzo
            Aprile
            Maggio
            Giugno
            Luglio
            Agosto
            Settembre
            Ottobre
            Novembre
            Dicembre
        """);

        month = userInput.next();

        while(ticketMulti == 0.0f)
        {
        if(month.equalsIgnoreCase("gennaio") || month.equalsIgnoreCase("febbraio") || month.equalsIgnoreCase("dicembre"))
        {
            ticketMulti = 1.2f;
        }
        else if (month.equalsIgnoreCase("marzo") || month.equalsIgnoreCase("aprile") || month.equalsIgnoreCase("maggio"))
        {
            ticketMulti = 1.5f;
        }
        else
        {
            System.out.println("Inserire un mese valido, riprova:");
            month = userInput.next();

        }
    }

    priceForOne = ticketMulti * ticketPrice;
    priceForOneMinor = (ticketMulti * ticketPrice)/2;

    priceForAll = (priceForOneMinor * peopleUnderAge) + ((numberOfPeople - peopleUnderAge) * priceForOne);

    System.out.println(String.format("""
            Il prezzo per un minore è: %s.
            Il prezzo per un adulto è: %s.
            Il prezzo totale è: %s.
    """, priceForOneMinor, priceForOne, priceForAll));


    }
}
