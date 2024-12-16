import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner userInput = new Scanner(System.in);
        String dayOfWeek;
        boolean validDay;
        int age;
        float price = 10F;
        
        System.out.println("Benvenuto nel servizio di acquisti online, prime di proseguire con l'acquisto le verranno poste alcune domande");
        System.out.println("Premere invio per continuare");
        System.in.read();

        System.out.println("Inserire la propria età");
        age = userInput.nextInt();

        if (age < 0)
        {
            while(age < 0)
            {
                System.out.println("Età non valida, inserie un numero valido");
                age = userInput.nextInt();
            }
        }

        if (age <= 10)
        {
            price = 5f;
        }
        else if (age >= 60)
        {
            price = 7f;
        }

        System.err.println("In quale giorno della settimana vorrebbe prenotare?");
        dayOfWeek = userInput.next();

        do
        {
            validDay = (dayOfWeek.equalsIgnoreCase("lunedi") ||  dayOfWeek.equalsIgnoreCase("martedi") || dayOfWeek.equalsIgnoreCase("mercoledi") || dayOfWeek.equalsIgnoreCase("giovedi") ||
            dayOfWeek.equalsIgnoreCase("venerdi") || dayOfWeek.equalsIgnoreCase("sabato") || dayOfWeek.equalsIgnoreCase("domenica"));
            if(!validDay)
            {
                System.err.println("Errore, il giorno inserito non è valido. Riprova:");
                dayOfWeek = userInput.next();
            }

        }while(!validDay);


        if(dayOfWeek.equalsIgnoreCase("mercoledì"))
        {
            price = (price * 80f ) / 100f;
        }
        else if (dayOfWeek.equalsIgnoreCase("sabato") || dayOfWeek.equalsIgnoreCase("domenica") && age <= 10)
        {
            price = 6f;
        }

            System.out.println("Il prezzo è: " + price);

    }
}
