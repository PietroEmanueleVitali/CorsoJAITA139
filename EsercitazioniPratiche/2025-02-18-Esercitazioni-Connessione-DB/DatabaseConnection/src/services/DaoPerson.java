package services;

//Per la manipolazione dei dati di tipo persona

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Entities;
import models.Person;
import utility.Database;


public class DaoPerson implements IDao{

    //le dipendenze della nostra classe
    //si deve poter connettere al Database per svolgere le operazioni CRUD
    private Database database;


    public DaoPerson (String schema){
       this.database = new Database(schema);
        

    }

    @Override
    public void addPersona(Entities persona) {
        database.openConnection();
        String insertQuery = "INSERT INTO persone (nome, cognome, data_di_nascita, residenza, genere, altezza) VALUES (?,?,?,?,?,?);";
        //per dare effettivamente i valori devo utilizzare un oggetto apposito che controlla la correttezza della query
        try {
            //questo oggetto si occupa di mandare la query
            PreparedStatement ps = database.getConnectiion().prepareStatement(insertQuery);
            if(persona instanceof Person person)
            {

                ps.setString(1, person.getNome());
                ps.setString(2, person.getCognome());
                ps.setDate(3,  Date.valueOf(person.getData_di_nascita()));
                ps.setString(4, person.getResidenza());
                ps.setString(5, String.valueOf(person.getGenere()));
                ps.setInt(6, person.getAltezza());

                //esegui operazione dml
                ps.executeUpdate();
            }
            ps.close();
            

        } catch (SQLException e) {
            System.out.println("Error in addPersona method, the exception SQLException has been thrown");
        } finally {
            database.closeConnection();
        }

    }

    //object-relational-mapping
    @Override
    public List<Entities> personList() {
        //apro la connessione
        database.openConnection();
        List<Entities> listPerson = new ArrayList<>();
        
        //Query per il Db
        String query = "SELECT * FROM persone";

        //il prepare statement si deve occupare dei controlli, quindi dobbiamo passare tutto a lui

        try {
            PreparedStatement ps = database.getConnectiion().prepareStatement(query);

            //per le dql
            ResultSet resultSet = ps.executeQuery();

            //result set è il dato salvato in forma tabellare, quindi ora devo convertirlo alla mia lista
            //cicliamo tutto il contenuto di resultset e prendiamo i valori delle singole righe
            while(resultSet.next())
            {
                Person person = new Person(
                    resultSet.getInt(1), 
                    resultSet.getString(2), 
                    resultSet.getString(3), 
                    resultSet.getDate(4).toLocalDate(), 
                    resultSet.getString(5), 
                    resultSet.getString(6).charAt(0), 
                    resultSet.getInt(7));

                    listPerson.add(person);
            }

            resultSet.close();

        } catch (SQLException e) {
            System.out.println("sono nel metodo personList, qualcosa è andato storto con la query");
        } finally {
            database.closeConnection();
        }

        return listPerson;

    }

    @Override
    public Person personById(int id) {
        database.openConnection();
        Person person = new Person();
        person = null;
        String query = "SELECT * FROM persone WHERE id = ? ;";
        try {
            PreparedStatement ps  = database.getConnectiion().prepareStatement(query);
            ps.setInt(1, id);

            ResultSet result = ps.executeQuery();

            if (result.next())
                person = new Person( 
                result.getInt(1), 
                result.getString(2), 
                result.getString(3), 
                result.getDate(4).toLocalDate(), 
                result.getString(5), 
                result.getString(6).charAt(0), 
                result.getInt(7)
                );

        } catch (SQLException e) {
            System.out.println("Capo ci sono problemi nel metodo personById");
        }
        return person;
    }

    @Override
    public void updatePerson(Person persona) {
        database.openConnection();
        String query = "UPDATE persone SET nome = 'claudiooo' WHERE id = ?;";
        
        try {
            PreparedStatement ps = database.getConnectiion().prepareStatement(query);
            ps.setInt(1, persona.getId());

            System.out.println("ho aggiornato la riga: " + ps.executeUpdate());

            ps.close();
            
        } catch (SQLException e) {
            System.out.println("update person non sta funzionando come deve");
        }
        finally
        {
            database.closeConnection();
        }
        
    }

    @Override
    public void deletePerson(int id) {
        database.openConnection();
        String query = "DELETE FROM persone WHERE id = ?;";

        try {
            PreparedStatement ps = database.getConnectiion().prepareStatement(query);
            ps.setInt(1, id);

            System.out.println("ho eliminato la riga: " + ps.executeUpdate());

            ps.close();

        } catch (SQLException e) {
            System.out.println("delete person non sta funzionando come deve");
        }
        finally
        {
            database.closeConnection();
        }
    }



}
