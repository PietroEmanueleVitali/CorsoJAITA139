package dao;

import java.util.Map;

public interface IDao <T> {

    int addEntity(T item);
    
    Map<Integer, T> readAll();

    T readById(int id);

    int update(T item);

    int delete(int id);
    
}
