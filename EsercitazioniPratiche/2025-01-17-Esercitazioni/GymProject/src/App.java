import clienthandler.Client;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
   
    Scanner fileReader = new Scanner(new File("resources/clients.csv"));
    ArrayList<Client> clientList = new ArrayList<>();
    String[] clientDataInArray = new String[8];
    int findTheAncientOne = 0;
    int findTheBoy = 0;
    String ancientOne = "";
    String boy = "";
    

    while(fileReader.hasNextLine())
    {
    String lineRead = fileReader.nextLine();
    String[] whiteSpace = lineRead.split("\n");
    //esempio di un dato
    //giuseppe, rovanelli, 1999,10,12,Lucrezia, definizione, false
    for(var singleLine : whiteSpace)
    {
         clientDataInArray = singleLine.split(",");

        System.out.println(clientDataInArray[6]);
        
        LocalDate data = LocalDate.of(
            Integer.parseInt(clientDataInArray[2]),
            Integer.parseInt(clientDataInArray[3]),
            Integer.parseInt(clientDataInArray[4]));

        clientList.add(new Client(clientDataInArray[0], clientDataInArray[1], data, clientDataInArray[5], clientDataInArray[6], Boolean.parseBoolean(clientDataInArray[7])));
        }
    }       

    String theAncientOneButRegistered = "";

    for (Client c : clientList)
    {
        if(findTheAncientOne == 0)
        {
            findTheAncientOne = c.calculateAge();
            ancientOne = c.toString();
        }
        if(findTheBoy == 0)
        {
            findTheBoy = c.calculateAge();
            boy = c.toString();
        }

        ancientOne = c.calculateAge() > findTheAncientOne ? c.toString() : ancientOne;
        boy = c.calculateAge() < findTheBoy ? c.toString() : boy;   

        if(c.getName().equalsIgnoreCase(ancientOne) && c.isRegistered())
        {
            theAncientOneButRegistered = c.toString();
        }

    }


    System.out.println("Ecco i dati del più giovane:" + boy + " ecco i dati del più vecchio: " + ancientOne);

    System.out.println(theAncientOneButRegistered);

    System.out.println("inserisci il personal trainer di cui desideri vedere i clienti:");
    Scanner userInput = new Scanner(System.in);
    String nameTrainer = userInput.nextLine();
    
    for (Client c : clientList)
    {
        if(nameTrainer.equalsIgnoreCase(c.getPersonalTrainer()))
        {
            System.out.println(c.toString());
        }
    }

    System.out.println("Lista di tutti i clienti e relativi dati");
    for (Client c : clientList)
    {
        System.out.println(c.toString());
    }


        

// Creiamo un programma palestra con degli affiliati letti da un file .csv, dove avranno come proprietà un nome, un cognome, una data di nascita('dob' abbreviato in inglese),
// il nome del loro personal trainer(string personalTrainer), l'obbiettivo che vogliono perseguire(se dimagrire oppure per divertimento, o  definire) e SE hanno OPPURE no un abbonamento,
// (fate un massimo di 3 persone nel file, per non esagerare).
// Ci sarà la classe main separata dalla classe modello (che sarà una classe 'Person')
// Inserire i dati letti da file all'interno di un vettore
// Fare una scheda per ogni persona e stamparla per poter visualizzare i dati
// Voglio  stampare la scheda della persona più giovane

// Voglio anche stampare quella più vecchia che è abbonata alla palestra

// Voglio anche avere la possibilità di vedere i clienti che sono sotto ad un
// personal trainer, digitandolo a tastiera.
// Potrebbero esserci più clienti che hanno lo stesso personal trainer
    }
}
