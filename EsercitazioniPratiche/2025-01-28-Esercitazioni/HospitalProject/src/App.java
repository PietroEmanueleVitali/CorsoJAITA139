
import java.util.Scanner;
import persondatahandler.Hospital;

public class App {
    public static void main(String[] args) throws Exception {

        Hospital sanRaffaele = new Hospital("res/pazienti.txt", "res/dottori.txt", "res/chirurghi.txt");
        System.out.println("Benvenuto, dicci pure cosa vorresti vedere:");
        System.out.println(  
        "1  - Lista pazienti\n" +
        "2  - Lista Dottori\n" +
        "3  - Lista Completa\n" +
        "4  - Dottori con almeno 10 anni di lavoro\n" +
        "5  - Dottori per città\n" +
        "6  - Media stipendi per specializzazione\n" +
        "7 - Lista buon dottore\n" +
        "8 - Spesa totale\n" +
        "9 - Reparto con più pazienti");

        Scanner userInput = new Scanner(System.in);

        do{
        switch(Integer.parseInt(userInput.nextLine()))
        {
            case 1:
                sanRaffaele.patientList();
                break;
            case 2:
                sanRaffaele.doctorList();
                break;
            case 3: 
                System.out.println(sanRaffaele.toString());
                break;
            case 4:
                sanRaffaele.doctorListWithEx();
            case 5: 
                System.out.println("Di quale città vorresti sapere i dottori?");
                sanRaffaele.doctorListForCity(userInput.nextLine());
                break;
            case 6:
                System.out.println("Di quale specializzazione vorresti sapere il guadagno medio?");
                sanRaffaele.doctorAverageEarnings(userInput.nextLine());
                break;
            case 7:
                sanRaffaele.doctorGood();
                break;
            case 8:
                sanRaffaele.priceFortreatment();
                break;
            case 9:
                sanRaffaele.mostPopularDepartment();
                break;
            default:
                System.out.println("Scelta non valida");
            
        }

        System.out.println("desideri vedere altro? [y/n]");
    }while(userInput.nextLine().equalsIgnoreCase("y"));


      
    }
}
