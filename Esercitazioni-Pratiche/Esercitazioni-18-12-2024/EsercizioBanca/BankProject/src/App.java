/* creare uno sportello bancario che permetta ad un utente di effettuare:
         
bilancio (quanto c'è sul conto, potrebbe esserci inizialmente un valore di default-2000)
versamento
prelievo()- se fate in tempo controllare che possa prelevare quella cifra
storico (movimenti effettuati in positivo e in negativo)
esci
Per far scegliere ad un utente quale operazione svolgere usare uno switch
L'utente deve poter effettuare diverse operazioni quindi finché non decide di uscire*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        String bankingOperation;
        double checkingAccountCash = 2000;
        double requestedCash;
        double deposit;
        int pin = 1234;
        int pinEntered;
        int counterForPin = 0;
        boolean logged;
        String operationList = "";
        String keepGoing = "no";

        
        Scanner userInput = new Scanner(System.in);

        //inserire il pin, max 3 tentativi

        System.out.println("Benvenuto nel servizio bancario di Intesa SanPaolo, inserisci il tuo pin:");
        pinEntered = Integer.parseInt(userInput.nextLine());

        while (pinEntered != pin && counterForPin <=1) 
        { 
            System.out.println("Pin non valido, riprova:");
            pinEntered = Integer.parseInt(userInput.nextLine());
            counterForPin ++;
        }

        logged = pinEntered == pin;

        do{

        if(logged)
        {
            System.out.println("""
                Quale operazione desideri effettuare?
                -> Prelievo
                -> Bilancio (vedere storico)
                -> Versamento    
                    """);
            
            bankingOperation = userInput.nextLine().toLowerCase();

            switch(bankingOperation)
            {
                case "prelievo":
                    System.out.println("Quanto vorresti prelevare?");
                    requestedCash = Double.parseDouble(userInput.nextLine());
                    while(requestedCash > checkingAccountCash)
                    {
                        System.out.println("Il suo conto non dispone di quella cifra. Immettere un numero valido:");
                        requestedCash = Double.parseDouble(userInput.nextLine());
                    }
                    checkingAccountCash = checkingAccountCash - requestedCash;
                    operationList += "\nHai prelevato " + requestedCash;
                break;
                case "bilancio":
                    if(operationList.isEmpty())
                    {
                        System.out.println("Non hai effettuato nessuna operazione");
                    }
                    else
                    {
                        System.out.println(operationList);
                    }
                break;
                case "versamento":
                    System.out.println("Quanto vorresti versare?");
                    deposit = Double.parseDouble(userInput.nextLine());
                    checkingAccountCash += deposit;
                    operationList += "\nHai versato " + deposit;
                break;
                default:
                    System.out.println("Non hai selezionato nessuna operazione valida.");
            }
            System.out.println("Desideri continuare?[si/no]");
            keepGoing = userInput.nextLine();
        }
        else
        {
            System.out.println("Tentativi disponibili superati, verrai reindirizzato alla home...");
        }
    }while(keepGoing.equalsIgnoreCase("si"));


        //userInput.close();
        System.out.println("Premere un tasto per chiudere.");
        System.in.read();


    }
}
