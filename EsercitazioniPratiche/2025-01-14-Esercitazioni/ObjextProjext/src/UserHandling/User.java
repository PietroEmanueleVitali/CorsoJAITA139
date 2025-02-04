package UserHandling;

public class User {

    private String userName;
    private String password;

    public User()
    {
        
    }
    public User(String name ,String pass)
    {
        this.userName = name;
        this.password = pass;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() { return "Username: " + this.userName + "Password: " + this.password; }

    public boolean userChek(User user)
    {
        return user.getUserName().equalsIgnoreCase(this.userName) && user.getPassword().equalsIgnoreCase(this.password);
    }
    
    

}

// Attributi:
// username
// password
//   Metodi:
// toString()
// controllaUsername(String user) -> questo metodo controlla lo username inserito dall'utente
// cioè ci sarà un oggetto utente creato da voi con un suo user e una sua password
// l'utente da console dovrà provare ad autenticarsi inserendo user e pass
// il vostro obiettivo è controllarli
// se lo user inserito dall'utente in consoleè uguale a quello dell'attributo dell'oggetto
// controllaPassword(String pass) -> controlla pa password
// cioè se quella insertita in console per autenticarsi è uguale a quella dell'oggetto
// controllaAutenticazione(String user,String pass)->
// controlla che sia user che password siano corretti

//         provate a creare almeno 4 utenti
        
// come poter salvare i 4 o più utenti in una struttura dati(contenitore)?