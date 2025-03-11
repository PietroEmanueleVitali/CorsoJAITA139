import dao.DaoAlbum;
import dao.DaoGenerico;

import java.time.LocalDate;
import java.util.List;
import model.Album;
import model.Entity;
import utility.Database;

public class App {
    public static void main(String[] args) throws Exception {

        Database database = new Database("music2");

        DaoGenerico daoalbum = new DaoGenerico(database);

        Long id = (long)13;
        String name = "Bravo Ale";
        LocalDate dateRelease = LocalDate.now();

        List<Entity> album = daoalbum.getListEntity("album");

        for (var albus : album)
        {
            if(albus instanceof Album a)
            {
                System.out.println(a.getId() + " " + a.getName());
            }

        }

        //System.out.println(album);
        //daoalbum.addEntity(album);

    }
}
