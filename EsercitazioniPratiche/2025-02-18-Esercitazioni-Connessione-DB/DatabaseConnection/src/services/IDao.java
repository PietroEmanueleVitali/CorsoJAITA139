package services;

import java.util.List;
import models.Entities;
import models.Person;

//creo tutti i metodi CRUD

public interface IDao {
    
    //firma dei metodi CRUD
    //C -> Create
    void addPersona(Entities persona); //Avrà una insert

    //R -> Read
    //Lista di entità, tutte le persone
    List<Entities> personList();

    Person personById(int id);

    //U -> Update
    void updatePerson(Person persona);

    //D -> Delete
    void deletePerson(int id);
}
