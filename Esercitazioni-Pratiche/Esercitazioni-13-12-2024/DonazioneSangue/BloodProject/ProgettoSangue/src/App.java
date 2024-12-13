
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner userData = new Scanner(System.in);
        int age;
        String answer;
        String sesso;
   
        System.out.println("""
            Ciao! Prima di poter donare il sangue... 
            dovremo farti qualche domanda:\n""");



        System.out.println("Qual è la tua età\n");

        if(userData.hasNextInt())
        {
            age = userData.nextInt();
            if(age >= 18)
            {
                System.out.println("Hai fatto tatuaggi negli ultimi 6 mesi? Rispondi con Si o No.");
                answer = userData.next();

                if(answer.equalsIgnoreCase("no"))
                {
                    System.out.println("Ti sei mai drogato? Rispondi con Si o No.");
                    answer = userData.next();
                    if(answer.equalsIgnoreCase("no"))
                    {
                        System.out.println("Hai patologie ematiche? Rispondi con Si o No.");
                        answer = userData.next();
                        if(answer.equalsIgnoreCase("no"))
                        {
                            System.out.println("Hai subito trasfusioni di sangue negli ultimi 6 mesi? Rispondi con Si o No.");
                            answer = userData.next();
                            if(answer.equalsIgnoreCase("no"))
                            {
                                System.out.println("Sei maschio (M) o Femmina (F)?");
                                sesso = userData.next();
                                if (sesso.equalsIgnoreCase("F")) {
                                    System.out.println("Hai donato negli ultimi 6 mesi? Rispondi di Si o di No.");
                                    answer =userData.next();
                                    if(answer.equalsIgnoreCase("no"))
                                    {
                                        System.out.println("Perfetto, puoi donare");
                                    }else{
                                        System.out.println("Mi spiace, non puoi donare.");
                                    }
                                }
                                else if (sesso.equalsIgnoreCase("M")) {
                                    System.out.println("Hai donato negli ultimi 4 mesi? Rispondi di Si o di No.");
                                    answer =userData.next();

                                    if (answer.equalsIgnoreCase("no")) {
                                        System.out.println("Perfetto, puoi donare");
                                    }else{
                                        System.out.println("Mi spiace, non puoi donare.");
                                    }
                                    
                                }else{
                                    System.out.println("Mi spiace, non puoi donare.");
                                }
                            }else{
                                System.out.println("Mi spiace, non puoi donare.");
                            }
                        }else{
                            System.out.println("Mi spiace, non puoi donare.");
                        }
                    }else{
                        System.out.println("Mi spiace, non puoi donare.");
                    }
                }else{
                    System.out.println("Mi spiace, non puoi donare.");
                }
            }else
            {
                System.out.println("Non puoi donare.");
            }
        }
        else
        {
            System.out.println("Mi spiace, non puoi donare.");
        }
    
    }
}
