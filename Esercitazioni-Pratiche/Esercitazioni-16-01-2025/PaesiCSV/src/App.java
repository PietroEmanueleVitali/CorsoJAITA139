import countryhandler.Country;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Costruttore oggetto
        //String capital, String language, String currency, boolean isItIsland, int numberOfPeople

        Scanner userInput = new Scanner(System.in);
        
        do{
        ArrayList<Country> countries = new ArrayList<>();
        Scanner fileReader = new Scanner(new File("resources/countries.csv"));
        fileReader.useDelimiter(",");
        
        while(fileReader.hasNext())
        {
            countries.add(new Country(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), Boolean.parseBoolean(fileReader.next()), Integer.parseInt(fileReader.next())));
        }

        fileReader.close();

        System.out.println("Ecco la lista dei paesi e tutti i loro valori:");
        for (var c : countries)
        {
            System.out.println(c.toString());
        }

        System.out.println("Desideri inserire un nuovo paese?[y/n]");
        
        if(userInput.nextLine().equalsIgnoreCase("y"))
        {
            countries.add(new Country());
            System.out.println("Inserire un il paese:");
            countries.get(countries.size() - 1).setNation(userInput.nextLine());
            System.out.println("Inserire la capitale:");
            countries.get(countries.size() - 1).setCapital(userInput.nextLine());
            System.out.println("Inserire la valuta:");
            countries.get(countries.size() - 1).setCurrency(userInput.nextLine());
            System.out.println("Inserire il linguaggio del paese:");
            countries.get(countries.size() - 1).setLanguage(userInput.nextLine());
            System.out.println("si tratta di un isola? [y/n]");
            countries.get(countries.size() - 1).setItIsland(userInput.nextLine().equalsIgnoreCase("y"));
            System.out.println("Inserire un il numero di cittadini:");
            countries.get(countries.size() - 1).setNumberOfPeople(Integer.parseInt(userInput.nextLine()));

            FileWriter fileWriter = new FileWriter(new File("resources/countries.csv"), true);
            
            fileWriter.write("\n" + countries.get(countries.size() - 1).getFormattedElement());

            fileWriter.close();
            System.out.println("Hai inserito: \n" + countries.get(countries.size() - 1).toString());
        }

        System.out.println("Desideri continuare? [y/n]");

        }while(userInput.nextLine().equalsIgnoreCase("y"));
    }
}

// Creare una lista in formato csv che chiameremo 'paesi.txt' con la nazione, la capitale, la lingua del paese, la valuta, se è un isola oppure no e il numero di abitanti
// che dovranno essere inseriti nel file e letti dal nostro programma (direi di fare 3 paesi)  

// esempio di inserimento nel file:  Giappone,Tokyo,Giapponese,Yen,true,9433125

// Dividiamo la classe di avvio, il nostro main dalla classe Paese

// Voglio che l'utente, oltre a visualizzare i dati da file inseriti precedentemente, possa inserire anche lui un paese a sua scelta, dove potremmo
// inserire le proprietà tramite tastiera.
// Il menu di inserimento dovrà chiedere sempre la prima volta di inserire un nuovo paese.
// Creare poi un metodo di uscita dall'inserimento.

// Inseriamo questi dati all'interno di un arrayList, poi visualizziamo la stampa.
