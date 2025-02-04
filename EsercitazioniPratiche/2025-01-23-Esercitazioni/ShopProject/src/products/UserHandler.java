package products;

public class UserHandler{

    public UserHandler() throws Exception{
        
        Shop shop = new Shop();

        shop.GenerateShop("res/data.csv");
        System.out.println("Benvenuto, siamo un negozio molto strano, cosa desidera fare?");
        System.out.println("""
            1- sapere il peso medio dei prodotti
            2- sapere quanti libri hanno la copertina rigida
        """);
        
        System.in.read();

        System.out.println("Muahahahhaha, non puoi scegliere, devi sapere tutto!");
        
        shop.averageWeight();
        shop.howManyBooksHardCovered();
    }

}
