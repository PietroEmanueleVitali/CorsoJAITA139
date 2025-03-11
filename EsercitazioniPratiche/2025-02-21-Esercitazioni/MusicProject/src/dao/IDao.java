package dao;

import java.util.List;
import model.Entity;

public interface IDao <T extends Entity> {

    public void addEntity(T entity);
    
    public void deleteEntity(T entity);

    public void updateEntity(T entity);
    
    public T selectById(long id, String tableName);

    public List<T> getListEntity(String table);



}
