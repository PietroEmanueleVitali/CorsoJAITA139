
public class App {
    public static void main(String[] args) throws Exception {
        
        String name = "Pietro";
        String secondName = "Emanuele";
        String surname = "Vitali";
        String cityOfResidence = "Milano";
        int age = 24;

        float height = 1.82F;

        //versione con una sola stampa

        System.out.println("Carta numero 1 \n" + "Nome: " + name + " "  + secondName + "\nCognome: " + surname 
        + "\nResidenza: "+ cityOfResidence + "\nEtà: " + age + "\nAltezza: " + height);
      
        name = "Elia";
        secondName = "";
        surname = "Santoro";
        cityOfResidence = "Milano";
        age = 25;

        height = 1.83F;

        //versione con più stampe e sovrascrivendo le variabili

        System.out.println(" ");
        System.out.println("Carta numero 2");
        System.out.println(" ");

        System.out.println("Nome: " + name + " "  + secondName);
        System.out.println("Cognome: "+ surname);
        System.out.println("Residenza: "+ cityOfResidence);
        System.out.println("Età: "+ age);
        System.out.println("Altezza: "+ height);

        System.out.println(" ");
        


    }
}
