package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/*questa classe ha il compito di gestire la connessione con il Database, ovvero il server
 * che contiene i dati salvati al suo interno
 */
public class Database implements IDatabase{
 
    //proprietà
    private String user;
    private String password;
    private String percorso;
    //le proprietà qui sopra servono per creare una connessione, un ponte
    //che viene gestito da un oggetto specifico che ha il compito di arrivare al database e aprire la porta a cui si trova
    private Connection connection;//ho aggiunto una prorpietà che è una dipendenza
    //ovvero alla classe Database per poter funzionare serve un oggetto di tipo Connection
    
    //mi serve la classe Driver per aprire la connessione, qui setto il percorso per
    //raggiungerla all'interno della libreria
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
       
    //costruttore
    public Database(String nomeSchema){
        this.user = "root";
        this.password = "giocops2";
        setPercorso(nomeSchema);
    }
    
    //get e sets   
    public String getPercorso() {
        return percorso;
    }

    //con il set imposto il percorso per raggiungere il db
    public void setPercorso(String nomeSchema) {
        //creo una variabile che contenga dei comandi per utilizzare il tempo universlae
        String timeZone = "?useSSL=false&serverTimezone=UTC";
        //contiene il percorso per arrivare al server e quindi alla porta in cui sotra
        String url = "jdbc:mysql://localhost:3306/";
        this.percorso = url+nomeSchema + timeZone;    
    }

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    //metodi
    //1. apre la connessione
    public void apriConnessione(){
        try {
            //chiamo la classe Driver, ovvero facci si che io possa prenderne
            //i metodi che mi servono
            
            Class.forName(DRIVER);//prendo la classe che mi serve dall'archivio


            connection = DriverManager.getConnection(percorso, user, password); 

        }catch(ClassNotFoundException e){
            //se non trova la classe Driver verrà catturata questa eccezione         
            System.out.println("riga: 58 -> controlla il percorso per arrivare alla classe Driver"+
            " oppure non c'è il connettore, controlla il jar");
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("riga 59 -> controlla lo user, la password e il percorso(url nomeschema e porta)");
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Errore nella chusura del database");
        }
    }

    @Override
    public int executeDML(String query, String... parametri) {

        apriConnessione();
        int rowModified = 0;
        String[] columns = {"id"};

        System.out.println(query);
        
        System.out.println(parametri);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, columns))
        { 
            for(int i = 1; i <= parametri.length; i++)
            {
                preparedStatement.setString(i, parametri[i]);
            }

            rowModified = preparedStatement.executeUpdate();

            ResultSet resulSet = preparedStatement.getGeneratedKeys();

            if(resulSet.next())
            {
                return resulSet.getInt(1);
            }
            preparedStatement.close();
            resulSet.close();
        }catch (SQLException e)
        {
            System.out.println("PROBLEMI DENTRO EXECUTE_DML");
        }
        closeConnection();
        return rowModified;
    }

    @Override
    public Map<Integer, Map<String, String>> executeDQL(String query, String... parametri) 
    {
        apriConnessione();
        Map<Integer, Map<String, String>> result = new LinkedHashMap<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            for(int i = 1; i < parametri.length; i++)
            {
                preparedStatement.setString(i, parametri[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            Map<String, String> row;
            while(resultSet.next())
            {
                row = new LinkedHashMap<>();
                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++)
                {
                    row.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(i));
                }
                result.put(resultSet.getInt("id") , row);
            }
            resultSet.close();
            
        } catch (SQLException e) {

            System.out.println("problema in executeDQL");
        }
        closeConnection();
        return result;
    }
}
