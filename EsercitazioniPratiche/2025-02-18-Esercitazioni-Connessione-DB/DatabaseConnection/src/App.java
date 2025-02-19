import models.Person;
import services.DaoPerson;
import services.IDao;

public class App {
    public static void main(String[] args) throws Exception {
        
        IDao daoPerson = new DaoPerson("anagrafica");


        // Entities persona = new Person(0, "Luigi", "pirandello", LocalDate.of(1999, 12,21), "Milano", 'M', 178);

        // daoPerson.addPersona(persona);

        for (var person : daoPerson.personList())
        {
            System.out.println(person + "\n");
            if(person instanceof Person p)
                daoPerson.updatePerson(p);
        }

        //System.out.println("\n" + daoPerson.personById(2));
       
    

       
    }
}
