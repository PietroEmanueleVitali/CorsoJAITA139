package dao;

import java.util.LinkedHashMap;
import java.util.Map;
import model.Can;
import utils.Database;
import utils.IDatabase;

public class DaoCan implements IDao<Can> {

    private static DaoCan daocan = null;
    private IDatabase database;

    final String CAN_ID = "can_id";

    private final String ADD_ITEM = "INSERT INTO can (name) VALUES (?)";
    private final String UPDATE_ITEM = String.format("UPDATE can SET name=? WHERE %s=?", CAN_ID);
    private final String DELETE_ITEM = String.format("DELETE FROM can WHERE %s=?", CAN_ID);
    private final String SELECT_ALL = "SELECT * FROM can";
    private final String SELECT_FROM_ID = String.format("SELECT * FROM can WHERE %s=?", CAN_ID);

    public DaoCan() {
        this.database = Database.getInstance();
    }

    public static synchronized IDao<Can> getInstance() {
        if (daocan == null) {
            daocan = new DaoCan();
        }
        return daocan;
    }

    @Override
    public int addEntity(Can item) {
        int result = 0;
        result = database.executeDML(ADD_ITEM, CAN_ID, item.getName());
        return result;
    }

    @Override
    public int update(Can item) {
        int result = 0;
        result = database.executeDML(UPDATE_ITEM, CAN_ID, item.getName(), String.valueOf(item.getCan_id()));
        return result;
    }

    @Override
    public int delete(int id) {
        int result = 0;
        result = database.executeDML(DELETE_ITEM, CAN_ID, String.valueOf(id));
        return result;
    }

    @Override
    public Map<Integer, Can> readAll() {
       Map<Integer, Map<String, String>> table = database.executeDQL(SELECT_ALL);
       Map<Integer, Can> result = new LinkedHashMap<>();
       for (var entity : table.values()) {
            Can can = new Can();
            can.mapper(entity);
            result.put(can.getCan_id(), can); 
       }
       return result;
    }

    @Override
    public Can readById(int id) {
        Map<String, String> singleLine = new LinkedHashMap<>();
        singleLine = database.executeDQL(SELECT_FROM_ID, String.valueOf(id)).get(id);
        Can result = new Can();
        result.mapper(singleLine);
        return result;
    }
}
