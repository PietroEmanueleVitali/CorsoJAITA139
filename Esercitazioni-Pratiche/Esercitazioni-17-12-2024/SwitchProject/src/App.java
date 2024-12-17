/*
 * Switch: è un selettore che permette di organizzare il flusso del codice per dei casi speicifici (in caso sia noto che una variabile possa avere un certo numero di valori).
 * La sintassi è 
 
  Switch(variabile) {
        case [valore1], [valore2], [valore3], ...[] :
        azioni...
        break;
        default:
  }
 
  Due nuovi metodi per le stringhe: 
    Stringa.isEmpty() -> ritorna un boolean, se pieno ritorna FALSE e se vero ritorna TRUE
    Stringa.toLowerCase() -> prende tutti i char della stringa e li converte nella versione lowercase così che la stringa sia costituita solo da lettere minuscole

    Esercizio:
 // Lavorate in una biglietteria a Vezio.
// Sapete che il biglietto intero costa 10 euro.
// Sapete anche che il museo applica i seguenti sconti (non cumulabili)
// - I residenti a Vezio e a Como entrano gratis
// - Gli studenti hanno diritto al 30% di sconto
// - Gli under 12 e gli over 65 hanno diritto al 50% di sconto
// - I militari e i medici hanno diritto al 65% di sconto

// Scrivere un programma che chieda i dati all'utente e calcoli il prezzo del suo biglietto
 
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner userInput = new Scanner(System.in);
        String answers;
        int age;
        float price = 10f;
        float discount = 1f;
        
        System.out.println("Benvenuto alla biglietteria di Vezio, premere un tasto per continuare");
        System.in.read();

        System.out.println("Sei uno studente? Rispondi con si o con no");
        answers = userInput.next();

        if(answers.equalsIgnoreCase("si"))
        {
            discount = 0.70F;
        }

        System.out.println("Quanti anni hai?");
        age = userInput.nextInt();

        discount = (age <= 12 || age >= 65) ? 0.50f : discount;

        System.out.println("Qual è la tua professione?");
        answers = userInput.next();

        switch(answers.toLowerCase())
        {
            case "medico", "militare":
                discount = 0.45f;
            break; //negli altri casi il discount è già fissato ad 1
        }
        
        System.out.println("Dove sei residente?");
        answers = userInput.next();

        switch(answers.toLowerCase())
        {
            case "como", "vezio":
                discount = 0.0f;
            break; //negli altri casi il discount è già fissato ad 1
        }

        price = price * discount;

        if(price == 0.0f)
        {
            System.out.println("""
                Per lei il biglietto è gratuito.
                Sta per essere rimandato alla pagina per il download del biglietto..
                """);
        }
        else 
        {
            System.out.println(String.format("""
            La ringranziamo del suo tempo, 
            Il prezzo del biglietto è: %s
            """, price));
        }



    }
}
