
import java.util.Scanner;

/* Scrivere un programma per "gestire" una festa
 * in cui c'e' una lista di VIP che all'ingresso con il semplice nome 
 * possono entrare senza problemi.
 * mentre ci sono tutti gli altri che devono pagare per entrare (10)
 * il locale ha una capienza massima di 20 persone 
 * 
 * cosa deve fare inoltre il programma:
 * deve contare quanti VIP sono entrati 
 * deve stampare l'incasso della serata, somma di tutti gli ingressi a pagamento
 * se si arriva al numero massimo non si puo' piu far entrare persone e il programma termina.
 * 
 * LIVELLO ESTREMO 
 * fare in modo che anche se non si e' arrivati al numero massimo di persone
 * il programma potrebbe terminare prima, quindi deve esserci una domanda 
 * se ci sono altre persone all'ingresso, se la riposta e' NO il programma 
 * termina
 * 
 * LIVELLO EXTRA ESTREMO
 * come faccio a capire se una persona e' gia' entrata ?
 * 
 * 
 */

public class App {
    public static void main(String[] args) throws Exception {
        String[] vipList = new String[5];
        vipList[0] = "Francesco";
        vipList[1] = "Luigi";
        vipList[2] = "Filiberto";
        vipList[3] = "Roberto";
        vipList[4] = "Batman";
        int cashEarned = 0;
        Scanner userInput = new Scanner(System.in);
        String[] enteredPeople = new String[20];
        String[] entrancePeople = new String[20];
        boolean isVip = false;
        boolean keepGoing = true;
        boolean isAlreadyInside = false;
        String nameChecker;
        int peopleInside = 0;

        do {
            System.out.println("Benvenuto al Locale delle meraviglie, come si chiama il cliente?");
            nameChecker = userInput.nextLine();

            for (int i = 0; i < vipList.length; i++) {
                isVip = vipList[i].equalsIgnoreCase(nameChecker);
                if (isVip)
                    break;
            }

            entrancePeople[peopleInside] = nameChecker;

            if (peopleInside > 0) {
                for (int i = 0; i < peopleInside; i++) {
                    isAlreadyInside = enteredPeople[i].equalsIgnoreCase(nameChecker);
                    if (isAlreadyInside)
                        break;
                }
            }

            if (isAlreadyInside) {
                System.out.println("L'utente è già entrato");
            } else {
                enteredPeople[peopleInside] = nameChecker;
                peopleInside++;
                if (isVip) {
                    System.out.println("L'ingresso per lei è gratuito");
                } else {
                    System.out.println("Il costo per l'ingresso è di 10 euro");
                    cashEarned += 10;
                }
            }

            System.out.println("Desideri continuare? [y/n]");
            isAlreadyInside = false;
            keepGoing = userInput.nextLine().equalsIgnoreCase("y") || peopleInside >= 20;

        } while (keepGoing);

        System.out.println("Incasso della serata:" + cashEarned);
    }
}
