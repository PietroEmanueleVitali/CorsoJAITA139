package dao;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Album;
import model.Entity;
import model.Song;
import utility.IDatabase;

public class DaoGenerico implements IDao<Entity> {

    private IDatabase database;

    public DaoGenerico(IDatabase database) {
        this.database = database;
    }

    @Override
    public void addEntity(Entity entity) {

        Map<String, Object> insertObject = new LinkedHashMap<>();
      
            Field[] fields = entity.getClass().getDeclaredFields();

            for (var field : fields) {
                field.setAccessible(true);

                String name = field.getName();
                try {

                    Object value = field.get(entity);
                    insertObject.put(name, value);
                } catch (Exception IllegalAccessException) {
                    System.out.println("Errore in addEntity");
                } finally {
                    System.out.println(" ");
                }
            }

        String query = "INSERT INTO " + entity.getClass().getSimpleName() + " (";

        for(var key : insertObject.keySet())
        {
            query += key + ",";
        }

        query = query.substring(0, query.length() - 1);
        query += ") VALUES (";

        for(var value : insertObject.values())
        {
            if(!(value instanceof Number))
            {
                query += "'" + value + "',";
            }
            else if(value instanceof LocalDate)
            {
                query += "'" + value + "',";
            }
            else 
            {
                query += value + ",";
            }
        }
        query = query.substring(0, query.length() - 1);
        query += ");";
        database.executeDML(query);
        System.out.println(query);
    }

    @Override
    public void deleteEntity(Entity entity) {

         Object value = null;

            try {
                Field field = Entity.class.getDeclaredField("id");
            
                field.setAccessible(true);
    
                System.out.println(field.getName());

                value = field.get(entity);      
            }

            catch (IllegalAccessException e) {
                System.out.println("illegalAccessExceptio");

                } catch (NoSuchFieldException e)
                {
                    System.out.println("NoSuchFieldException");
                } 
                catch (Exception e)
                {
                    System.out.println("errore generico");
                }                 
        String query = "DELETE FROM " + entity.getClass().getSimpleName() + " WHERE id=" + value + ";";
        
        database.executeDML(query);
        System.out.println(query);
    }

    
    //Metodo di aggiornamento di un record già esistente nel DB
    @Override
    public void updateEntity(Entity entity) {
        
        //Prendiamo il nome della classe che richiamerà questo metodo
        String tableName = entity.getClass().getSimpleName(); //getClass() --> prende la classe concreta, getSimpleName() --> nome della classe concreta (con getName() prendiamo l'intero path (es. models.Album))
        Field[] fields = entity.getClass().getDeclaredFields(); //getDeclaredFields() --> prende tutti i campi della classe concreta 

        Map<String, Object> updateObject = new LinkedHashMap<>(); //Serve che sia Linked, altrimenti mette in disordine i valori
        
        for(var field : fields) // scorro tutti i campi della classe concreta
        {
            field.setAccessible(true); // dato che i campi sono private, dobbiamo renderli accessibili

            String name = field.getName(); // salviamo il nome del campo, per poi metterlo nella mappa

            try {
                Object value = field.get(entity); // prendiamo il valore del campo della classe concreta 

                updateObject.put(name, value); //mettiamo i campi nella mappa, associando nome e valore (es. name = "giuseppe il frocio")

            } catch (Exception e) {
                System.err.println("Fratello, field.get non funziona");
            }
        }

        System.out.println(updateObject);
        //Dobbiamo costruire la query da dare al PreparedStatement
        //UPDATE nometablla SET campo = ? WHERE id = ?;

        String query = "UPDATE " + tableName + " SET "; 
        /*
        La nostra mappa:
        nome = "luigi"
        cognome = "pirandazzo"
        etc.
        */
        for(var dataSet : updateObject.entrySet()) //ciclo la mappa e costruisco la stringa per la query tramite la mappa
        {
            query += dataSet.getKey() + "=";

            if(!(dataSet.getValue() instanceof Number))
            {
                query += "'" + dataSet.getValue() + "',"; 
            }
            else if(dataSet.getValue() instanceof LocalDate) //In effetti è inutile questo if, mi spiace Ale, devi pulire
            {
                query += "'" + dataSet.getValue() + "', ";
            }
            else 
            {
                query += dataSet.getValue() + ",";
            }
        }
        query = query.substring(0, query.length() -1); // Per togliere la virgola in più

        try {
            
            Field campo = Entity.class.getDeclaredField("id"); //Prendiamo il field di nome "id"
            campo.setAccessible(true); //Li rendo accessibili

            long id = (long)campo.get(entity); // Prendiamo l'id della classe concreta e lo convertiamo a long
            System.out.println(id);

            query += " WHERE id=" + id + ";";
            
        } catch (Exception e) {
            System.err.println("Non sei gesù");
        }
        System.err.println(query);

        database.executeDML(query); //Eseguo la query, non dimenticare questo pezzo dio porcissimo
    }

    //Abbiamo modificato i dati in ingresso, ci servono id e tabella di riferimento
    @Override
    public Entity selectById(long id, String tableName) {

        String query = "SELECT * FROM " + tableName + " WHERE Id=" + id + ";";

        Map<Integer, Map<String, String>> SelectResult = database.executeDQL(query); //Utilizziamo il metodo presente in Database che restituisce una mappa di mappe

        ArrayList<String> values = new ArrayList<>(); // guarda bene come utilizziamo questi 
        Entity result = null;

        for (var singleMap : SelectResult.values()) // Per prima cosa dobbiamo eseguire un foreach su SelectResult per prendere tutte le Map<String, String>
        {
            for(var singleValue : singleMap.values()) // Ora facciamo un for each su ogni Map<String, String> per prendere solo la seconda stringa, ovvero il valore da inserire nell'oggetto
            {
                values.add(singleValue); // Salviamo tutti i valori in una Lista
            }
        }

        if (tableName.equalsIgnoreCase("album")) // Se parliamo di un oggetto album (tableName è ugaule al nome della classe)
        {      
            result = new Album(Long.parseLong(values.get(0)), values.get(1), LocalDate.parse(values.get(2))); // Convertiamo i singoli valori che abbiamo salvato prima e creiamo l'oggetto
        }

        if (tableName.equalsIgnoreCase("song")) // Stessa cosa per le canzoni
        {
            result = new Song(Long.parseLong(values.get(0)), Long.parseLong(values.get(1)), values.get(2), Double.parseDouble(values.get(3)));
        }
        return result;
    }

    //Questo è identico al precedente, ma deve dare come valore di ritorno una lista di entità, quindi richiede qualche passaggio in più
    @Override
    public List<Entity> getListEntity(String table) {
        
        String query = "SELECT * FROM " + table;

        Map<Integer, Map<String, String>> SelectResult = database.executeDQL(query);

        ArrayList<Entity> lista = new ArrayList<>(); // dobbiamo aggiungere anche una lisa di entità, deve contenere il valore di ritorno del nostro metodo
        
        Entity result = null;
        
        for (var singleMap : SelectResult.values()) // Qui è come prima, dobbiamo fare un foreach su Map<Integer, Map<String, String>> per prendere solo tutti i Map<String, String>
        {
            ArrayList<String> values = new ArrayList<>(); // Ad ogni giro dobbiamo creare una lista nuova per salvare tutti i valori contenuti nella mappa

            for(var singleValue : singleMap.values()) // Ora come prima, facciamo un foreach su Map<String, String> Solo per prendere tutti i valori della seconda String
            {
                values.add(singleValue); //Salviamo tutti i valori, che andranno poi convertiti nei Field dell'oggetto
            }

            if (table.equalsIgnoreCase("album")) //Esattamente come prima creiamo l'oggetto in base al nome della tabella
            {   
                // La differenza qui è l'aggiunta dell'oggetto alla lista di Entity che abbiamo definito prima   
                lista.add(new Album(Long.parseLong(values.get(0)), values.get(1), LocalDate.parse(values.get(2))));
            }
    
            if (table.equalsIgnoreCase("song")) 
            {  
                lista.add(new Song(Long.parseLong(values.get(0)), Long.parseLong(values.get(1)), values.get(2), Double.parseDouble(values.get(3))));
            }
        }
        return lista;
    }
}
