package dao;

import java.util.Map;
import model.Ingredient;
import utils.Database;
import utils.IDatabase;

public class DaoIngredients implements IDao<Ingredient> {

    private IDatabase database;
    private static IDao daoIngredients;

    final String INGRIDIENT_ID = "ingredient_id";

    private final String ADD_ITEM = "INSERT INTO ingredient (name) VALUES (?)";
    private final String UPDATE_ITEM = String.format("UPDATE ingredient SET name=? WHERE %s=?", INGRIDIENT_ID);
    private final String DELETE_ITEM = String.format("DELETE FROM ingredient WHERE %s=?", INGRIDIENT_ID);
    private final String SELECT_ALL = "SELECT * FROM ingredient";
    private final String SELECT_FROM_ID = String.format("SELECT * FROM ingredient WHERE %s=?", INGRIDIENT_ID);


    private DaoIngredients() {
        this.database = Database.getInstance();
    }

    public static IDao getInstance() {
        if (daoIngredients == null) {
            return new DaoIngredients();
        }
        return daoIngredients;
    }

    @Override
    public int addEntity(Ingredient item) {
        return database.executeDML(ADD_ITEM, INGRIDIENT_ID, item.getName());
    }

    @Override
    public Map<Integer, Ingredient> readAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public Ingredient readById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readById'");
    }

    @Override
    public int update(Ingredient item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

   

}
