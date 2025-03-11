package utility;

import java.util.Map;

public interface IDatabase {

    public int executeDML(String query, String... parametri);

    public Map<Integer, Map<String, String>> executeDQL(String query, String... parametri);
}
