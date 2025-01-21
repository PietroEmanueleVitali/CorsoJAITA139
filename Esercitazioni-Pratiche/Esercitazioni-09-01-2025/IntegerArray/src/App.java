/*Implementare un programma che chieda quanti numeri si vogliono inserire 
 * Procedere con l'inserimento e memorizzare nel vettore i numeri forniti
 *
 *     Dopo che l'utente ha inserito i valori
 *     dargli la possibilitÃ di effettuare le seguenti operazioni:
 * 1) stampare l'intero vettore
 * 2) la somma totale dei numeri salvati
 * 3) il valore medio dei numeri
 * 4) stampare i numeri pari inseriti
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner userInput = new Scanner(System.in);
        int numberOfNumbers= 0;
        int selectOperation;
        boolean keepGoing = true;
        int sum = 0;

        System.out.println("Quanti numeri desideri inserire? ");
        numberOfNumbers = Integer.parseInt(userInput.nextLine());

        int[] numbers = new int[numberOfNumbers];

        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(userInput.nextLine());
        }

        System.out.println("Quali operazioni vorresti svolgere?\n");
        System.out.println("""
            1- Stampa l'intero vettore
            2- Somma totale dei numeri salvati
            3- Valore medio dei numeri
            4- Stampa i numeri pari inseriti
        """);

        selectOperation = Integer.parseInt(userInput.nextLine());

        while(keepGoing)
        {
            switch(selectOperation)
            {
                case 1:
                    for(int i = 0; i < numbers.length; i++)
                    {
                        System.out.println("\n" + numbers[i]);
                    }
                break;
                case 2:
                    for(int i = 0; i < numbers.length; i++)
                    { 
                        sum += numbers[i];
                    }
                    System.out.println("\n" + sum);
                break;
                case 3:
                    for(int i = 0; i < numbers.length; i++)
                    { 
                        sum += numbers[i];
                    }
                    if(numberOfNumbers == 0)
                    {
                        System.out.println(sum);
                    }
                    else
                    {
                        System.out.println("\n" + (sum/numberOfNumbers));
                    }
                break;
                case 4:
                    for(int i = 0; i < numbers.length; i++)
                    {
                        if(numbers[i] % 2 == 0)
                            System.out.println("\n" + numbers[i]);
                    }
                break;

            }

            System.out.println("Desideri continuare? [y/n]");
            keepGoing = userInput.nextLine().equalsIgnoreCase("y");

        }

    }
}
