/*
    Oggi parleremo dei vettori (gli array). Essi sono dei contenitori ordinati con una dimensione fissa.
    I dati contenuti all'interno di un array devono essere dello stesso tipo e la dimensione và definita nel momento della creazione. 
    Ogni dato avrà un identificativo, ovvero un indice (la sua posizione all'interno dell'array, si parte a contare da 0 fino a lunghezza - 1).
    Un array lo posso caricare in diversi modi:
    ->Un primo modo è dichiararlo e caricarlo subito String[] cars = {...args}
    ->Posso anche crearlo vuoto e definire quanto sarà lungo String[] cars = new String[10]
    ->Oppure posso dichiararlo e inizializzarlo dopo


*/

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Scrivere un file che contenga i prodotti venduti da un bar.
        // nel file troveremo: nomeProdotto, prezzo

        File menu = new File("src/prodotti.txt");
        Scanner reader = new Scanner(menu);

        double[] prices = new double[4];
        String[] names = new String[4];
        int index = 0;
        double cheaper = 10.0;
        double averagePrices = 0;
        double coffeePrices = 0;
        int numberOfCoffee = 0;
        boolean keepOrdering = false;
        String order;
        int numberOfOrders = 0;
        String[] orderMade = new String[5];
        boolean notOnTheList = false;

        while (reader.hasNextLine()) {
            names[index] = reader.nextLine();
            prices[index] = Double.parseDouble(reader.nextLine());
            index++;
        }

        reader.close();

        System.out.println("Ecco qui tutti i prodotti del bar");

        for (int i = 0; i < prices.length; i++) {
            System.out.println(names[i] + ": " + prices[i]);

            cheaper = prices[i] < cheaper ? prices[i] : cheaper;
            averagePrices += prices[i];
            if (names[i].equalsIgnoreCase("caffe")) {
                coffeePrices += prices[i];
                numberOfCoffee++;
            }
        }
        averagePrices = averagePrices / prices.length;
        coffeePrices = coffeePrices / numberOfCoffee;

        System.out.printf("Prodotto più economico: %s\nCosto medio dei prodotti: %s\nCosto medio del caffè:%s\n",
                cheaper, averagePrices, coffeePrices);

        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("Cosa desidera ordinare? Massimo 5 ordini\n");
            order = userInput.nextLine().trim().toLowerCase();

            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(order)) {
                    orderMade[numberOfOrders] = order;
                    numberOfOrders++;
                    break;
                }
                notOnTheList = i >= names.length;
            }

            if (notOnTheList) {
                System.out.println("Non presente in elenco");
            }

            System.out.println("Desideri ordinare altro?[y /n]\n");
            keepOrdering = userInput.nextLine().equalsIgnoreCase("y") || numberOfOrders >= 5;

        } while (keepOrdering);

        System.out.println("Ecco qui cosa ha ordinato:");
        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("\n" + orderMade[i]);
        }

        userInput.close();
        // Scrivere un programma che apra un menù all'utente in cui si vede:

        // menù bar;
        // il nome dei prodotti più economici
        // il costo medio di tutti i prodotti del bar;
        // il costo medio dei prodotti che contengono la parola 'caffe';
        // permettere all'utente di ordinare un prodotto

        // Mettiamo anche unb comando di uscita dal menù
    }
}
