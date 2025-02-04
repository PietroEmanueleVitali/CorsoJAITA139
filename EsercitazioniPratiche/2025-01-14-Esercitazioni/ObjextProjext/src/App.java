import UserHandling.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     
    ArrayList<User> registered = new ArrayList<>(Arrays.asList(new User("Giovanni", "1234"), new User("Filippo", "1234"), new User("Giuseppe", "1234"), new User("Lucrezia", "1234")));
    boolean exists = false;  
    String response;
    Scanner userInput = new Scanner(System.in);

    System.out.println("Inserire username: ");
    String username = userInput.nextLine();

    System.out.println("Inserire password: ");
    String password = userInput.nextLine();

    User inputUser = new User(username, password);
    
  
    for (User user : registered) {
      if(user.userChek(inputUser))
      {
        exists = true;
        break;
      }
    }

    response = exists ? "L'utente esiste" : "L'utente non esiste";
    System.out.println(response);

    }
}
/* creare un modello per gestire gli utenti che si devono autenticare 
        
Attributi:
username
password
  Metodi:
toString()
controllaUsername(String user) -> questo metodo controlla lo username inserito dall'utente
cioè ci sarà un oggetto utente creato da voi con un suo user e una sua password
l'utente da console dovrà provare ad autenticarsi inserendo user e pass
il vostro obiettivo è controllarli
se lo user inserito dall'utente in consoleè uguale a quello dell'attributo dell'oggetto
controllaPassword(String pass) -> controlla pa password
cioè se quella insertita in console per autenticarsi è uguale a quella dell'oggetto
controllaAutenticazione(String user,String pass)->
controlla che sia user che password siano corretti

        provate a creare almeno 4 utenti
        
come poter salvare i 4 o più utenti in una struttura dati(contenitore)?*/