// AGENZIA VIAGGI

// Dovete organizzare un viaggio all'estero.
// Dal cliente (che è un agenzia viaggi) vi farete passare le seguenti informazioni:
// - destinazione
// - mezzo di locomozione
// - durata viaggio
// - numero partecipanti al viaggio

// Dovete creare una scheda ordinata con le informazioni che vi hanno passato e dovete calcolare il 
// prezzo del viaggio per i singoli partecipanti, sapendo che:




// Nella scheda ordinata del viaggio voglio vedere tutti i dati che sono stati passati dal cliente
// il prezzo complessivo del viaggio e il prezzo che paga la singola persona che partecipa al viaggio




import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner userInput = new Scanner (System.in);
        String name;
        String destination;
        String vehicle;
        int numberOfParticipants;
        int numberOfDays;
        float multiplierForGroups;
        String discountOrPenalty;

        // Ogni giorno di viaggio ha una base fissa di 10.50
        float priceForEveryDay = 10.5f;
        float priceforOne;
        float priceTotal;

        System.out.println("Benvenuto nella nostra agenzia di viaggio! Premi un tasto per iniziare.");
        System.in.read();

        System.out.println("Inserisca il suo nome");
        name = userInput.next();

// Il costo in base alla destinazione sarà:
//- Roma: 50
//- Dubai: 200
//- Tokyo: 500
//- Dublino: 150
//- Amsterdam: 90
//- altro: 1500
        System.out.println(String.format("Grazie %s, dove vorrebbe andare?", name));
        destination = userInput.next().toLowerCase();

        switch(destination)
        {
            case "roma":
                priceforOne = 50f;
            break;
            case "dubai":
                priceforOne = 200f;
            break;
            case "tokyo":
                priceforOne = 500f;
            break;
            case "dublino":
                priceforOne = 150f;
            break;
            case "amsterdam":
                priceforOne = 90f;
            break;
            default:
                priceforOne = 1500f;
            break;
        }

// Il costo in base al mezzo di locomozione sarà:
//- aereo: 500
//- treno: 300
//- traghetto: 450
//- pulman: 350
//- altro: 1000

        System.out.println("Con quale mezzo desidera viaggiare?");
        vehicle = userInput.next().toLowerCase();

        switch(vehicle)
        {
            case "aereo":
                priceforOne += 500f;
            break;
            case "treno":
                priceforOne += 300f;
            break;
            case "traghetto":
                priceforOne += 450f;
            break;
            case "pulman":
                priceforOne += 350f;
            break;
            default:
                priceforOne += 1000f;
            break;
        }

// Se il numero di partecipanti è inferiore a 10 si calcoli una penale aggiuntiva del 2%, 
// se sono tra 11 e 20, pagano una penale del 0.5%, 
// se sono più di 20 hanno diritto allo sconto comitiva del 5% sul totale        

        System.out.println("Quanti sarete per questa avventura?");
        numberOfParticipants = userInput.nextInt();

        if(numberOfParticipants < 10)
        {
            multiplierForGroups = 1.02f;
            discountOrPenalty = "Penale del 2%";
        }
        else if (numberOfParticipants >= 10 && numberOfParticipants <= 20)
        {
            multiplierForGroups = 0.995f;
            discountOrPenalty = "Sconto dello 0.5%";
        }
        else 
        {
            multiplierForGroups = 0.95f;
            discountOrPenalty = "Sconto del 5%";
        }
        
        System.out.println("Quanti giorni durerà il viaggio?");
        numberOfDays = userInput.nextInt();


    //Calcolo dei prezzi
    priceforOne = multiplierForGroups * (priceforOne + (numberOfDays * priceForEveryDay));
    priceTotal = priceforOne * numberOfParticipants;

 /* Esempio di output desiderato
 
SCHEDA VIAGGIO
Destinazione: Dubai
Mezzo: Monopattino Elettrico
Durata: 40 giorni
Partecipanti: 30 persone

Costo Totale: millemila euro
[Sconto 5%/Sconto 0.5%/Penale 2%] Facoltativa come riga
Costo Per Partecipante: 10 euro caduno
*/
        System.out.println("Ecco qui un riepilogo del suo acquisto:");
        System.out.println(String.format(""" 
            Destinazione: %s
            Mezzo: %s
            Durata: %s
            Partecipanti: %s
            Costo Totale: %s
            Costo Per Partecipante: %s
            %s
        """, destination, vehicle, numberOfDays, numberOfParticipants, priceTotal, priceforOne, discountOrPenalty));
    }
}
