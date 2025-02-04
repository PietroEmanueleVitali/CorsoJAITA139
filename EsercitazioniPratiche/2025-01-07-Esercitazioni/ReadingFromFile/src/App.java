/*
    Ripasso iterazioni. Introduzione della parola chiave "continue" all'interno di un loop. Essa permette di passare direttamente al prossimo loop ignorando il codice sottostante.

    Nuovo modo per utilizzare gli Scanner: Per ora abbiamo utilizzato il System.in nel costruttore per prendere in input i dati (Legge i dati inseriti nella console).
    Ora andremo a mettere nel costruttore altre fonti di input

 * Come si fa a leggere da un file in java? Abbiamo diverse classi che possiamo utilizzare, ma meglio vedere la versione più semplice:
 * Prima di tutto dobbiamo creare un oggetto col nome del file, per 
 * fare questo esiste la classe di tipo File, 
 * si può importare tramite import java.io.File (Ha un sacco di metodi per creare un file o prendere informazioni).
 * La creazioe del file avviane utilizzando l'oggetto File e utilizzando il metodo createNewFile().
 * Questo deve essere racchiuso all'interno di un try catch block (Lancia una IOException, per cui bisogna anche includere java.io.IOException).
 * Il metodo createNewFile() restituisce un booleano: true(file creato) false(il file esiste già). Se non si può creare lancia l'eccezione.
 * Nella creazione del File possiamo specificare il path in cui esso dovrà essere definito.
 * 
 * Per scrivere sul file creato si una la classe FileWriter ed il suo metodo write(). Questa va inizializzata col nome del file nel costruttore.
 * Rircordati sempre di chiuderla.
 * 
 * Per leggere il file basta possiamo utilizzare sempre gli scanner, essi possono prendere un oggetto di tipo file nel loro costruttore.
 * Per leggere le varie linee del file posso usare un loop in cui controllo se esiste una linea successiva con hasNextLine(), se esiste, possiamo 
 * usare nextLine(), che ci restituisce una stringa con il contenuto del file.
 * 
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Creazione della classe file che ci permette di creare un file, altrimenti sia
        // il reader che il writer non possono lavorare
        File newFile = new File("./Test.txt");

        try {
            // creazione del file con controllo di eventuali errori
            if (newFile.createNewFile()) {
                System.out.println("Il file è stato creato con successo!");
            } else {
                System.out.println("Il file esiste già");
            }
        } catch (IOException ex) {
            System.out.println("Errore nella creazione del file" + ex.getMessage());
        }

        // Scrittura manuale del file col metodo write (Possiamo anche prenderli dal
        // System.in o da altri file, vanno bene più tipi di dato)
        FileWriter writer = new FileWriter("Test.txt");
        writer.write("Canada\n" );
        writer.write("Ottawa\n");
        writer.write("Dollaro\n");
        writer.write("Italia\n" );
        writer.write("Roma\n");
        writer.write("Euro\n");
        writer.write("Spagna\n" );
        writer.write("Madrid\n");
        writer.write("Euro\n");
        writer.write("Svizzera\n" );
        writer.write("Berna\n");
        writer.write("Franco\n");
        writer.write("Austria\n" );
        writer.write("Vienna\n");
        writer.write("Euro\n");
        writer.write("Belgio\n" );
        writer.write("Bruxelles\n");
        writer.write("Euro\n");
        writer.write("Usa\n" );
        writer.write("Washington\n");
        writer.write("Dollaro\n");
        writer.write("Germania\n" );
        writer.write("Berlino\n");
        writer.write("Euro\n");
        writer.write("Francia\n" );
        writer.write("Parigi\n");
        writer.write("Euro\n");
        writer.write("Russia\n" );
        writer.write("Mosca\n");
        writer.write("Euro\n");
        writer.write("Giappone\n" );
        writer.write("Tokyo\n");
        writer.write("Yen\n");

        writer.close();

        System.out.println("Cosa c'è scritto nel file?");

        // Nuovo utilizzo degli scanner sfruttando un altro overload del costruttore
        // Nel costruttore dello scanner possiamo creare ed inizializzare direttamente
        // l'oggetto File che ci serve (con path relativo o assoluto)
        Scanner reader = new Scanner(newFile);
        String output = "";
        int number = 0;

        // controlliamo che ci sia qualcosa prima di scrivere
        while (reader.hasNextLine()) {
            //ogni volta che utilizzo un nextline verrà letta la riga successiva, a prescindere fino a quando non lo chiudo
            
            output += reader.nextLine() +"\n" + "Capitale: " + reader.nextLine() + "\n" + "Moneta: " + reader.nextLine() + "\n";
        }

        reader.close();
        System.out.println(output);

        System.out.println("Versione 2:");

        //Lo facciamo con un altro scanner visto che non si potrebbe usare di nuovo reader (è stato chiuso, il garbage collector ha già ripreso la sua memoria)
        Scanner italianReader = new Scanner(newFile);
        boolean isItaly = false;
        String checker;

        while (italianReader.hasNextLine()) {
            checker = italianReader.nextLine();
            isItaly = checker.equalsIgnoreCase("italia");
            if(isItaly)
            {
            output = "Paese: " + checker + " Capitale: " + italianReader.nextLine() + " Moneta: " + italianReader.nextLine() + "\n";
            break;
            }
        }

        System.out.println(output);
        italianReader.close();
    }
}
