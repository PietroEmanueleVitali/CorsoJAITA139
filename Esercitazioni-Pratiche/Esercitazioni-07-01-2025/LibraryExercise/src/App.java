
import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        /*Create un programma che importi le informazioni da file 
        La prima riga del file sarà il nome della libreria
        Ogni libro avrà titolo, autore, genere, nPagine, prezzo
        Stampare la lista dei libri nello store...inserite almeno 3 libri
        Stampare il totale delle pagine di tutti i libri
        Stampare la media dei prezzi di tutti i libri
        Stampare la media dei prezzi dei libri di genere fantasy*/

        File libraryInfo = new File("src/libreria.txt");
        Scanner readingInfo = new Scanner(libraryInfo);
        String libraryName = "";
        int totalPages = 0;
        int averagePrice = 0;
        int numberofBooks = 0;
        int averagePriceFantasy = 0;
        int numberOfFantasy = 0;
        String bookName, author, genre = "";
        int numberOfPages, price;

        libraryName = readingInfo.nextLine();
        System.out.println("\nEcco qui il catalogo della libreria " + libraryName + '\n');

        while(readingInfo.hasNextLine())
        {
            bookName = readingInfo.nextLine();
            author = readingInfo.nextLine();
            genre =readingInfo.nextLine();
            numberOfPages = Integer.parseInt(readingInfo.nextLine());
            price = Integer.parseInt(readingInfo.nextLine());

            
            System.out.println(String.format("""
                Nome del testo: %s
                Autore: %s
                Genere: %s
                Numero Pagine: %s
                Prezzo: %s
                    """, bookName, author, genre, numberOfPages, price) );

            // Stampare il totale delle pagine di tutti i libri
            // Stampare la media dei prezzi di tutti i libri
            // Stampare la media dei prezzi dei libri di genere fantasy
            totalPages += numberOfPages;
            averagePrice += price;
            numberofBooks++;
            if(genre.equalsIgnoreCase("fantasy"))
            {
                averagePriceFantasy += price;
                numberOfFantasy++;
            }
        }

        averagePrice = numberofBooks != 0 ? averagePrice/numberofBooks : averagePrice;
        averagePriceFantasy = numberOfFantasy != 0 ? averagePriceFantasy/numberOfFantasy : averagePriceFantasy;

        System.out.println(String.format("""
            Numero totale delle pagine: %s
            Media dei prezzi di tutti i libri: %s
            Media dei prezzi dei libri fantasy: %s
            """, totalPages, averagePrice, averagePriceFantasy));
    }
}
