import java.util.logging.*;




public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws Exception {


        //test per provare gli operatori ternari
        int age = 18;
        String underAgeOrNot = age >= 18 ? "Adult" : "Child";

        if (underAgeOrNot.equalsIgnoreCase("Adult") ) {
            
            LOGGER.info("Ok sei grande");
        }
        else {         
            LOGGER.info("Ok sei piccolo");
        }

        
    }
}
