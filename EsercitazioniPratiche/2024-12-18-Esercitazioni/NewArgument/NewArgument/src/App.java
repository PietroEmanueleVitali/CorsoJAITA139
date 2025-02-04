import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        double price = 1.50;
        String choice = "il caffè";
        double userMoney = 0;
        String machineAnswer;

        Scanner userInput = new Scanner (System.in);

        System.out.println("Inserire " + price + "$ per " + choice);
        userMoney = userInput.nextDouble();

        while(userMoney <= price )
        {
            System.out.println(String.format("Il credito è %s, servono ancora %s", userMoney, price - userMoney));
            System.out.println("Inserire altre monete:");
            userMoney += userInput.nextDouble();
        }

        machineAnswer = (userMoney == 1.50f) ? "Ecco qui il suo caffè!" : "Ecco qui il suo caffè ed il resto di " + (userMoney - price);
        
        System.out.println(machineAnswer);



        
    }
}
