/*
    Per leggere l'input dell'utente possiamo utilizzare la classe Scanner.
    Questa deve essere importata affinchè possa funzionare, possiamo farlo con import java.util.Scanner;

    Integer.parseInt(); Serve per la conversione da una stringa ad un numero intero.
    Possiamo dargli in input (tra le sue parentesi) keyboard.nextLine() che restituisce la stringa da convertire.

    Per comparare due stringhe ricorda sempre di utilizzare stringa.equals, Le stringhe in Java sono dei reference type, non puoi confrontare il valore e basta

    
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner keyboardAge = new Scanner(System.in);
        int age;
        Scanner KeyboardName = new Scanner(System.in);
        String name;
        Scanner KeyboardGame = new Scanner(System.in);
        String game;

        //validazione dei dati, deve essere un numero positivo tra 1 e 139
        do {
            System.out.println("Inserisci la tua età:");

            while (!keyboardAge.hasNextInt()) { //facciamo inserire il dato, se non si tratta di un int ripete il loop
                System.out.println("Inserisci un dato valido");
                keyboardAge.next(); //se entriamo in questo loop, dobbiamo prendere un altro input e controllare che non sia una stringa
            }

            age = keyboardAge.nextInt();
        } while (age <= 0 || age >= 140);

        System.out.println("Inserisci il tuo nome:");
        name = KeyboardName.next();

        if(age >= 18)
        {
            System.out.println("Ciao " + name + ", Quale gioco vorresti provare?\n");
            System.out.println("1-Biliardo\n2-Poker\n3-Roulette\n");
            switch(KeyboardGame.next())
            {
                case "Biliardo":
                    System.out.println("Certo " + name + "! Divertiti!");
                    break;
                case "Poker":
                    System.out.println("Certo " + name + "Divertiti!");
                    break;
                case "Roulette":
                    System.out.println("Certo " + name + "Divertiti!");
                    break;
                default:
                    System.out.println("Non abbiamo giochi del genere");
            }

        } 
        else 
        {
            System.out.println("Mi spiace " + name + "non è possibile farti giocare..");
        }
    
    }
}
