import services.DaoPerson;
import services.IDao;

public class App {
    public static void main(String[] args) throws Exception {
        
        String query = "SELECT persone.id, persone.cognome FROM persone WHERE persone.cognome = 'Ferri';";
        IDao daoPerson = new DaoPerson("anagrafica");

        for(var singleRow : daoPerson.readAll(query).entrySet())
        {
            System.out.println(singleRow);  
        }
    }
}
