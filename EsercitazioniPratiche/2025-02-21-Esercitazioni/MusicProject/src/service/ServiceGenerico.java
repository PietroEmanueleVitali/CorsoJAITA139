package service;

import dao.DaoGenerico;
import dao.IDao;
import utility.Database;
import utility.IDatabase;

public class ServiceGenerico {

    private IDatabase database;
    private IDao dao; 

    public ServiceGenerico(String schema)
    {
        //O così, o meglio creare un builder che inizializza tutto
        this.dao = new DaoGenerico(new Database(schema));
    }

    

}
