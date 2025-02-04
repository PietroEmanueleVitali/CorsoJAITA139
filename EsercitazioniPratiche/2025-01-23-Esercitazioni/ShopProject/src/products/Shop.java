package products;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    ArrayList<Product> products = new ArrayList<>();
    
    public Shop(){}

    public void GenerateShop(String path) throws Exception
    {
        Scanner fileReader = new Scanner(new File(path));
        while(fileReader.hasNextLine())
        {
            String[] data = fileReader.nextLine().split(",");

            if(data[0].equalsIgnoreCase("libro"))
            {
                products.add(new Book(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]));
            }
            else if(data[0].equalsIgnoreCase("abbigliamento"))
            {
                products.add(new Clothes(data[0],data[1],data[2],data[3],data[4],data[5]));
            }
            else
            {
                explode();
                System.exit(0);
            }
        }
        fileReader.close();
    }

    //Scusatemi non ho troppa fantasia coi metodi

    public void averageWeight()
    {
        int averageWeight = 0;
        int counter = 0;
        for(Product item : products)
        {
            averageWeight += item.getWeight();
            counter ++;
        }

        if(counter > 0)
            System.out.println("Il peso medio di tutti i prodotti è: " + (averageWeight/counter));
        else
            System.out.println("Non ho trovato nessun prodotto...");
    }

    public void howManyBooksHardCovered()
    {
        int counter = 0;
        for(var item : products)
        {
            if (item instanceof Book) {
                Book book = (Book) item;
                counter += book.isHardCovered() ? 1 : 0;
            }
        }
        System.out.println("Il numero di libri con la copertina rigida è: " + counter);
    }

    public void explode(){
        System.out.println("KABOOOOOOOOOOOOOOM");
    }

}
