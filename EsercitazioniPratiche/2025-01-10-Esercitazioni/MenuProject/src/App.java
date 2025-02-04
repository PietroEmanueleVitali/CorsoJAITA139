/*
Scrivere un programma che consenta di gestire un menu di un ristorante, 
leggendo i dati da un file e offrendo diverse funzionalità per 
manipolare e analizzare questi dati. 

Seguire i seguenti punti:

1. Lettura del file (se preferite createno uno nuovo) e inizializzazione dati

Ogni record nel file è composto da tre campi:
Nome del piatto 
Prezzo 
Categoria 

Quindi ogni record occupa 3 righe nel file.
Serviranno 3 ArrayList

2. Popolare gli Arraylist necessari leggendo i dati dal file.

3. Menù interattivo per l'elaborazione dei dati

Implementare un menu interattivo che consenta all'utente di scegliere 
tra diverse opzioni. 
Il programma deve continuare a mostrare il menu finché l'utente 
non sceglie di uscire.

Le opzioni disponibili sono:

1. Elenco dei piatti: 
Mostrare i nomi dei piatti, i prezzi e le categorie.
Controllare che ci siano piatti altrimenti mostrare un messaggio di avviso

2. Prezzo medio di una categoria: 
Calcolare il prezzo medio dei piatti appartenenti a una categoria specifica.
(Far scegliere la categoria all'utente)

3. Elenco per categoria: 
Mostrare i piatti di una specifica categoria inserita dall'utente.
Controllare che ci siano piatti di quella categoria altrimenti mostrare un messaggio di avviso

4. Piatto più costoso: 
Trovare e mostrare il piatto/i piatti con il prezzo più alto.
Potrebbe esserci la possibilità che ci siano più piatti con il prezzo 
più alto, in quel caso includerli tutti

6. Prezzi ordinati: [fare questo case per ultimo]
Ordinare i prezzi in ordine crescente e mostrare l'elenco ordinato.

7. Categoria più ricorrente: 
Determinare la categoria/le categorie con il maggior numero di piatti e mostrarla/le.

8. Aggiungere un piatto:
Controllare che non sia già presente nella lista, se c'è già non aggiungerlo
Altrimenti aggiungere il nome del piatto, il suo prezzo e la sua categoria
(Attenzione agli indici, un prezzo appartiene ad uno specifico piatto quando
nome-prezzo-categoria sono salvato in ArrayList diversi ma allo stesso valore
di indice)

9. Eliminare un piatto:
Controllare che esista per poterlo eliminare(controllare il nome)
Se esiste cancellare nome-prezzo-categoria del piatto
Se non esiste mostrare un messaggio di avviso

10. Modificare un piatto:
Controllare che esista per poterlo modificare(controllare il nome)
Se esiste modificare nome-prezzo-categoria del piatto
Se non esiste mostrare un messaggio di avviso

11. Cercare un piatto per nome:
Cercare se esista nella lista un piatto specifico
Se c'è riportarne anche il prezzo e categoria, altrimenti mostrare un messaggio di avviso

12. Visualizzare i piatti che hanno un prezzo superiore ad una certa cifra
impostata dall'utente.
Se ce ne sono riportare nome del piatto-prezzo-categoria
Altrimenti mostrare un messaggio di avviso */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

// 1. Lettura del file (se preferite createno uno nuovo) e inizializzazione dati

// Ogni record nel file è composto da tre campi:
// Nome del piatto 
// Prezzo 
// Categoria 
        File file = new File("src/dishes.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner userInput = new Scanner(System.in);
        String userChoice;
        double average = 0;
        int numberOfDishes = 0;
        int higherPrice = 0;
        int indexOfPlate;
        String options = """
        1- Mostrare il nome dei piatti con categoria e prezzo
        2- Prezzo medio di una categoria
        3- Elenco per categoria
        4- Piatto più costoso
        5- Categoria più ricorrente
        6- Cercare un piatto per nome
        7- Aggiungere un piatto
        8- Eliminare un piatto
        9- Modificare un piatto
        10- prezzi sopra una certa categoria
        11- Spoiler su bubble :)
        """;
        int optionSelected;
        boolean keepGoing = false;
        String[] counterCategories = {"primo", "secondo", "antipasto", "contorno"};
        ArrayList<Integer> counter = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

        ArrayList<String> dishName = new ArrayList<>();
        ArrayList<Integer> dishPrice = new ArrayList<>();
        ArrayList<String> dishCategory = new ArrayList<>();
        ArrayList<Integer> pricesAbove = new ArrayList<>();

//2. Popolare gli Arraylist necessari leggendo i dati dal file.
        while (fileScanner.hasNextLine()) 
        {
            dishName.add(fileScanner.nextLine());
            dishPrice.add(Integer.parseInt(fileScanner.nextLine()));
            dishCategory.add(fileScanner.nextLine()); 
        }
        fileScanner.close();

// 3. Elenco per categoria: 
// Mostrare i piatti di una specifica categoria inserita dall'utente.
// Controllare che ci siano piatti di quella categoria altrimenti mostrare un messaggio di avviso

        do{
            System.out.println("Scegliere l'opzione che le interessa:\n" + options);
            optionSelected = Integer.parseInt(userInput.nextLine());

            switch(optionSelected)
            {
                case 1:
                    for(int i =0; i < dishName.size(); i++ )
                    {
                        System.out.printf("""
                            Nome del piatto: %s
                            Prezzo: %s
                            Categoria: %s
                        """, dishName.get(i), dishPrice.get(i), dishCategory.get(i));
                    }
                break;
                case 2:
                    numberOfDishes = 0;
                    System.out.println("Quale categoria vorresti controllare?");
                    userChoice = userInput.nextLine();
                    for(int i = 0; i < dishCategory.size(); i++)
                    {
                        if (dishCategory.get(i).equalsIgnoreCase(userChoice))
                        {
                            average += dishPrice.get(i);
                            numberOfDishes ++;
                        }
                    }
                    if(numberOfDishes > 0)
                        System.out.printf("""
                            Per la categoria %s, il prezzo medio è: %s
                        """, userChoice, average/numberOfDishes);
                    else
                        System.out.println("Non ci sono piatti in quella categoria");
                break;
                case 3:
                    numberOfDishes = 0;
                    System.out.println("Prego, inserire la categoria del piatto che le interessa:");
                    userChoice = userInput.nextLine();
            
                    for(int i = 0; i < dishCategory.size(); i++)
                    {
                        if(dishCategory.get(i).equalsIgnoreCase(userChoice))
                        {
                            System.out.println(dishName.get(i));  
                            numberOfDishes ++;  
                        }
                    }
                    if(numberOfDishes == 0)
                        System.out.println("non abbiamo quella categoria!");
                break;
                case 4:
                    for(int i = 0; i < dishPrice.get(i); i++)
                    {
                        higherPrice = higherPrice < dishPrice.get(i) ? dishPrice.get(i) : higherPrice;
                    }
                    System.out.println(higherPrice);
                break;
                case 5:
                    int numbersOfFirst = 0;
                    int numbersOfSecond = 0;
                    int numbersOfThird = 0;
                    int numbersOfFourth = 0;

                    for(int i = 0; i < dishCategory.size(); i++)
                    {
                        if(dishCategory.get(i).equalsIgnoreCase(counterCategories[0]))
                        {
                            numbersOfFirst ++;
                            counter.set(0, numbersOfFirst);
                        }
                        if(dishCategory.get(i).equalsIgnoreCase(counterCategories[1]))
                        {
                            numbersOfSecond ++;
                            counter.set(1, numbersOfSecond);
                        }
                        if(dishCategory.get(i).equalsIgnoreCase(counterCategories[2]))
                        {
                            numbersOfThird ++;
                            counter.set(2, numbersOfThird);
                        }
                        if(dishCategory.get(i).equalsIgnoreCase(counterCategories[3]))
                        {
                            numbersOfFourth ++;
                            counter.set(3, numbersOfFourth);
                        }
                    }

                    System.out.println("La categoria più ricorrente è: " + counterCategories[counter.indexOf((Integer)Collections.max(counter))]);
                    //credo che si possano mettere anche dei controlli per trovare più valori massimi simultaneamente, ma credo si debbano nestare due loop uno dentro l'altro
                    //ricorda di chiedere se ci sono soluzioni migliori.
                    
                break;
                case 6:
                    indexOfPlate = 0;
                    System.out.println("Quale piatto desidera cercare?");
                    userChoice = userInput.nextLine();
                    for(int i = 0; i < dishName.size(); i++)
                    {
                        if(dishName.get(i).equalsIgnoreCase(userChoice))
                        {
                            indexOfPlate = i;
                        }
                    }

                    System.out.println("Questo piatto ha il prezzo di: " + dishPrice.get(indexOfPlate) + " e appartiene alla categoria: " + dishCategory.get(indexOfPlate));

                break;
                case 7:
                    int addingPrice;
                    String addingCategory;
                    System.out.println("Inserire il piatto che desidera aggiungere:");
                    userChoice = userInput.nextLine();
                    indexOfPlate = 0;
                    for(int i = 0; i < dishName.size(); i++)
                    {
                        if(dishName.get(i).equalsIgnoreCase(userChoice))
                        {
                            indexOfPlate = i;
                        }
                    }
                    if(indexOfPlate == 0)
                    {
                        System.out.println("Che prezzo dovrebbe avere?");
                        addingPrice = Integer.parseInt(userInput.nextLine());
                        System.out.println("A quale categoria appartiene?");
                        addingCategory = userInput.nextLine();

                        dishName.add(userChoice);
                        dishPrice.add(addingPrice);
                        dishCategory.add(addingCategory);

                        System.out.println("Inserito con successo!");
                    }
                    else
                    {
                        System.out.println("Il piatto esiste già");
                    }
                    
                break;
                case 8:
                System.out.println("Inserire il piatto che desidera Rimuovere:");
                userChoice = userInput.nextLine();
                indexOfPlate = 0;
                for(int i = 0; i < dishName.size(); i++)
                {
                    if(dishName.get(i).equalsIgnoreCase(userChoice))
                    {
                        indexOfPlate = i;
                    }
                }
                if(indexOfPlate == 0)
                {
                    System.out.println("Il piatto non esiste");
                }
                else{
                    dishName.remove(indexOfPlate);
                    dishPrice.remove(indexOfPlate);
                    dishCategory.remove(indexOfPlate);
                    System.out.println("Piatto eliminato con successo!");
                }
                break;
                case 9:
                    System.out.println("Inserire il piatto che desidera Modificare:");
                    userChoice = userInput.nextLine();
                    indexOfPlate = 0;
                    for(int i = 0; i < dishName.size(); i++)
                    {
                        if(dishName.get(i).equalsIgnoreCase(userChoice))
                        {
                            indexOfPlate = i;
                        }
                    }

                    if(indexOfPlate == 0)
                    {
                        System.out.println("Il piatto non esiste");
                    }
                    else
                    {
                        System.out.println("Inserire il nuovo nome:");
                        userChoice = userInput.nextLine();
                        int modPrice;
                        System.out.println("Inserire il nuovo prezzo:");
                        modPrice = Integer.parseInt(userInput.nextLine());
                        String ModCategory;
                        System.out.println("Inserire la nuova categoria");
                        ModCategory = userInput.nextLine();

                        dishName.set(indexOfPlate, userChoice);
                        dishPrice.set(indexOfPlate, modPrice);
                        dishCategory.set(indexOfPlate, ModCategory);
                        System.out.println("Piatto modificato con successo!");
                    }

                break;
                case 10:
                    indexOfPlate = 0;
                    int priceUserChose;    
                    System.out.println("Sopra quali prezzi desidera vedere?");
                    priceUserChose = Integer.parseInt(userInput.nextLine());

                    for(int i = 0; i < dishPrice.size(); i ++)
                    {
                        if(dishPrice.get(i) > priceUserChose)
                        {
                            pricesAbove.add(dishPrice.get(i));
                            indexOfPlate ++;
                        }
                    }
                    if(indexOfPlate > 0)
                        System.out.println(pricesAbove);
                    else
                        System.out.println("Non ci sono piatti oltre quella cifra");
                break;
                case 11:
                int[] orderedPrice = new int[dishPrice.size()];
                    for(int i = 0; i < orderedPrice.length; i ++)
                    {
                        orderedPrice[i] = dishPrice.get(i);
                    }

                    for (int i = 0; i < orderedPrice.length - 1; i++){
                        for (int j = 0; j < orderedPrice.length - i - 1; j++)
                            if (orderedPrice[j] > orderedPrice[j + 1]) {
                            
                                // scambio con una variabile di appoggio
                                int temp = orderedPrice[j];
                                orderedPrice[j] = orderedPrice[j + 1];
                                orderedPrice[j + 1] = temp;
                            }
                    }
                for (int i = 0; i < orderedPrice.length; i++) 
                {
                    System.out.println("Piatto " + dishName.get(i) + " corrisponde al prezzo di " + orderedPrice[i]);
                }
                    
                break;
            }

            System.out.println("Desideri continuare?");
            keepGoing = userInput.nextLine().equalsIgnoreCase("y");

        }while(keepGoing);
                
    }
}
