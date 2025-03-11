package utils;

import java.util.Map;

public interface  IDatabase {

    //Query per la modifica dei dati nel db
    int executeDML(String query, String tableId, String... params);
    
    //Qeury per la selezione dei dati
    Map<Integer, Map<String, String>> executeDQL(String query, String... params);
    
}
