
import java.util.Scanner;
import wineshop.WineShop;


    
public class App {
    public static void main(String[] args) throws Exception {
        WineShop wineshop = new WineShop("Res/vini_modificato.csv");
        Scanner userInput = new Scanner(System.in);

        do{ 
        System.out.println("cosa desideri fare?");
        System.out.println("""
            1- guarda tutti i nomi dei vini
            2- guarda i vini per categoria
            3- guarda i vini per paese
            4- guarda i vini per regione e paese
            5- guarda i vini che costano meno di una certa soglia
            6- controlla se è presente un certo vino
            7- controlla i vini vintage
            8- controlla i vini con un solo tipo di uva
            9- controlla il paese con più vini
        """);

        int choice = Integer.parseInt(userInput.nextLine());

        switch (choice) {
            case 1:
            wineshop.allWineNames();
                break;
            case 2:
            wineshop.whinesByCategory(userInput.nextLine());
                break;
            case 3:
            wineshop.whinesByCountry(userInput.nextLine());
                break;
            case 4:
            wineshop.whinesByCountryAndRegion(userInput.nextLine() , userInput.nextLine());
                break;
            case 5:
            wineshop.PricePicker(Double.parseDouble(userInput.nextLine()));
                break;
            case 6:
            wineshop.namechecker(userInput.nextLine());
                break;
            case 7:
            wineshop.vintageWine();
                break;
            case 8:
            wineshop.oneGrape();
                break;
            case 9:
            wineshop.theMostPopularCountry();
                break;
            default:
                throw new AssertionError();
        }
        System.out.println("Desideri continuare? [y/n]");
    }while(userInput.nextLine().equalsIgnoreCase("y"));
    }
}
