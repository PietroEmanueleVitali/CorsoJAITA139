import java.util.List;
import java.util.Map;

public interface IdaoBevanda {
    
    //firme dei metodi CRUD
    //C -> CREATE
    void addBevanda(Bevanda bevanda);//permetterà di aggiungere una persona come entità nel db
    //R -> READ leggo i dati della tabella persone
    List<Bevanda> listaBevanda();
    //Read di una sola persona
    Bevanda bevandaById(int idBevanda);
    //U -> UPDATE
    void updateBevanda(Bevanda bevandaDaAggiornare);
    //D -> DELETE
    void delete(int id); 

    Map<Integer,Map<String,String>> readAll();

}
