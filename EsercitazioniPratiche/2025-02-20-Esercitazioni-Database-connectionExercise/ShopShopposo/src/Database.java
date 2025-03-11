import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    //Dati di accesso al DB

    private String user; //root
    private String password; //
    private String percorso; //Path del db (jdbc:mysql://localhost:3306/) + nomeSchema (pub) + timezone (?useSSL=false&serverTimezone=UTC)

    private Connection connection; //Lo possiamo creare tramite driver
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //
    
    public Database (String schema)
    {
        this.user = "root";
        this.password = "";

        setPercorso(schema);
    }

    public String getPercorso() {
        return percorso;
    }

    public void setPercorso(String schema) {
        String path = "jdbc:mysql://localhost:3306/";
        String timeZone = "?useSSL=false&serverTimezone=UTC";

        percorso = path + schema + timeZone;
    }

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    //Creare dei metodi che ci permettano di collegarci comodamente

    public void openConnection ()
    {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(percorso, user, password);
            
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } catch (Exception e) {
            System.out.println("Hey sono nell'apertura della connessione del DB, qualcosa è andato storto");
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Sto provando a chiudere la connessione ma qualcosa non funzinoa");
        }
    }

}
