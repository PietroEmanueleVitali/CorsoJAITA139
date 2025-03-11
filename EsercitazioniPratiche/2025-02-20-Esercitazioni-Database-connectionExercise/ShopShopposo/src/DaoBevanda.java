import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class DaoBevanda implements IdaoBevanda{


    private Database database;

    public DaoBevanda(String schema) {
        this.database = new Database(schema);
    }


    @Override
    public void addBevanda(Bevanda bevanda) {
        //Apro la connessione col database
        database.openConnection();
        //Definisco la query
        String query = "INSERT INTO bevande (tipo, nome, produttore, anno, prezzo, provenienza, gradi, ed_limitata, quantita, volume) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(query);
            

        } catch (Exception e) {
            System.out.println("Hey sto avendo problemi di urinazione!");
        }



        //Eseguo l'operazione

        //chiudo la connessione
        
    }

    @Override
    public List<Bevanda> listaBevanda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaBevanda'");
    }

    @Override
    public Bevanda bevandaById(int idBevanda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bevandaById'");
    }

    @Override
    public void updateBevanda(Bevanda bevandaDaAggiornare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBevanda'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Map<Integer, Map<String, String>> readAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }



}
