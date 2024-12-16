import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner userInput = new Scanner(System.in);
        String feedback;

        feedback = ((userInput.nextInt()%2) == 0 ) ? "il numero è pari" : "il numero è dispari";

        System.out.println(feedback);
        userInput.close();

    }
}
