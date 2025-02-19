package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// per la connessione al database

public class Database {

    // Gli servono: nome_schema, user, password e porta
    private String user;
    private String password;

    // Tutto ciò che ci serve per raggiungere la porta ed aprirla
    private String percorso;

    // Questi valori vanno passati ad un oggetto specifico che si occupa della
    // creazione della connessione al DB
    private Connection connection;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // prendiamo la classe driver

    public Database(String nomeSchema) {
        this.user = "root";
        this.password = "root";
        setPercorso(nomeSchema);
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String nomeSchema) {
        // Dobiamo definire di quale timezone si parla
        String timeZone = "?useSSL=false&serverTimezone=UTC?useSSL=false&serverTimezone=UTC";
        // percorso per arrivare al server, si parte dal connettore poi abbiamo dbms e
        // il server
        String url = "jdbc:mysql://localhost:3306/";
        this.percorso = url + nomeSchema + timeZone;
    }

    public Connection getConnectiion() {
        return connection;
    }

    public void setConnectiion(Connection connectiion) {
        this.connection = connectiion;
    }

    // apriamo la connessione
    public void openConnection() {
        try {
            // chiamo la classe
            Class.forName(DRIVER); // ritorna l'oggetto associato al nome della classe che gli passiamo
            connection = DriverManager.getConnection(percorso, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Non ho trovato la classe in openConnection");
        } catch (SQLException e) {
            System.out.println("Non riesco a connettermi col DB");
        } catch (Exception e) {
            System.out.println("Errore generico nella classe DATABASE, metodo openConnection");
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Non posso chiudere la connessione, c'è stato un problema");
        } catch (Exception e) 
        {
            System.out.println("Errore generico nella chiusura della connesione");
        }
    }

}
