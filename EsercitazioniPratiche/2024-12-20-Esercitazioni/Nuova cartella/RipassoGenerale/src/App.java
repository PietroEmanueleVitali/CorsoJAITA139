import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner userInput = new Scanner(System.in);
        int order;
        double price;
        double totalPrice =0;
        String keepOrdering = "y";


        // Mostrare un menù con opzioni numerate (ad esempio, 1 per Pizza, 2 per Pasta, 3 per Insalata, ecc.).

        System.out.println("Benvenuto nel servizio di ordinazione dell'ostello bello grande.");
        System.out.println("Premere un tasto per continuare");
        System.in.read();

        do{

       
        // Chiedere all'utente di inserire il numero del piatto che vuole ordinare.
        System.out.println("""
            Seleziona cosa vorresti ordinare:
            -> 1 per Pizza
            -> 2 per pasta
            -> 3 per insalata
            """);
        order = userInput.nextInt();

        switch (order) {
            case 1:
                price = 12;
                break;
            case 2:
                price = 10;
                break;
            case 3:
                price = 8;
                break;
            default:
                price = 0;
                System.out.println("Non presente nel menú.");    
        }

        // Utilizzare un'istruzione switch per calcolare il prezzo totale in base al piatto scelto.
        totalPrice += price;

        // Consentire all'utente di ordinare più di un piatto chiedendo conferma dopo ogni scelta.
        System.out.println("Desideri ordinare altro? [y/n]");
        keepOrdering = userInput.next();

        }while(keepOrdering.equalsIgnoreCase("y"));
        
        // (opzionale)Integra un sistema di sconti, ad esempio, il 10% di sconto se il totale supera €20.
        totalPrice = (totalPrice > 20) ? (totalPrice - (totalPrice * 0.20)) : totalPrice;
        
        // Stampare il totale finale dell'ordine.
        System.out.println("Il prezzo totale è " + totalPrice);

    }
}
