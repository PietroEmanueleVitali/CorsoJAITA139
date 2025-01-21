package wineshop;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WineShop {

    private ArrayList<Wine> menu;

    public WineShop(String path) throws Exception
    {
        menu = GenerateWineShop(path);
    }

    public ArrayList<Wine> GenerateWineShop(String path) throws Exception{

        Scanner readFile = new Scanner(new File(path));
        menu = new ArrayList<Wine>();
        int index = 0;

        while(readFile.hasNextLine())
        {
            String[] singleLine = readFile.nextLine().split(";");
    
            menu.add(new Wine());

                menu.get(index).setTitle(singleLine[0]);

                menu.get(index).setDescription(singleLine[1]);

                if (singleLine[2].replaceAll("[^0-9.]", "").isEmpty()) 
                {
                    menu.get(index).setPrice(0);
                }else{
                    menu.get(index).setPrice(Double.parseDouble(singleLine[2].replaceAll("[^0-9.]", "")));
                }
                if (singleLine[3].replaceAll("[^0-9.]", "").isEmpty()) {
                    menu.get(index).setCapacity(0);
                }else{
                    menu.get(index).setCapacity(Double.parseDouble(singleLine[3].replaceAll("[^0-9.]", "")));
                }
                menu.get(index).setGrape(singleLine[4]);
                menu.get(index).setSecondaryGrapeVarieties(singleLine[5]);
                menu.get(index).setClousure(singleLine[6]);
                menu.get(index).setCountry(singleLine[7]);
                menu.get(index).setCharacteristics(singleLine[8]);
                menu.get(index).setType(singleLine[9]);

                if (singleLine[10].replaceAll("[^0-9.]", "").isEmpty()) {
                    menu.get(index).setAbv(0);
                }else{
                    menu.get(index).setAbv(Double.parseDouble(singleLine[10].replaceAll("[^0-9.]", "")));
                }
                
                menu.get(index).setRegion(singleLine[11]);
                menu.get(index).setStyle(singleLine[12]);

                if(singleLine[13].replaceAll("[^0-9.]", "").isEmpty())
                {
                    menu.get(index).setVintage(0);
                }else{
                    menu.get(index).setVintage(Integer.parseInt(singleLine[13].replaceAll("[^0-9.]", "")));
                }
            index ++;
         }    
         return menu;
    }


    public void allWineNames()
    {
        for(var m : this.menu)
        {      
            System.out.println(m.getTitle() + "\n");
        }
    }

    public void whinesByCategory(String type)
    {
        System.out.println("I vini " + type + " sono:"+ "\n");
        for(var m : this.menu)
        {
            if(m.getType().equalsIgnoreCase(type))
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void whinesByCountry(String country)
    {
        System.out.println("I vini del" + country + " sono:"+ "\n");
        for(var m : this.menu)
        {
            if(m.getCountry().equalsIgnoreCase(country))
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void whinesByCountryAndRegion(String country, String region)
    {
     
        System.out.println("I vini del" + country + " e della regione " + region + " sono:" + "\n");
        for(var m : this.menu)
        {
            if(m.getCountry().equalsIgnoreCase(country) && m.getRegion().equalsIgnoreCase(region))
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void PricePicker(double price)
    {
        
        System.out.println("I vini con un prezzo inferiore a:" + price + " sono:" + "\n");
        for(var m : this.menu)
        {
            if(m.getPrice() < price)
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void namechecker(String name)
    {  
        System.out.println("Il vino è: " + "\n");
        for(var m : this.menu)
        {
            if(m.getTitle().contains(name))
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void characteristicschecker(String characteristic)
    {  
        System.out.println("Il vino è: " + "\n");
        for(var m : this.menu)
        {
            if(m.getCharacteristics().contains(characteristic))
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void vintageWine()
    {  
        System.out.println("Il vino è: " + "\n");
        for(var m : this.menu)
        {
            if(m.getVintage() <= 2010)
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }
    
    public void oneGrape()
    {  
        System.out.println("Il vino è: " + "\n");
        for(var m : this.menu)
        {
            if(m.getSecondaryGrapeVarieties().equalsIgnoreCase("null"))
            {
                System.out.println(m.getTitle() + "\n");
            }
        }
    }

    public void theMostPopularCountry()
    {
        String country = "";
        int biggest = 0;
        
        for(int i = 0; i < this.menu.size(); i++)
        {
            int counter = 0;
            for(var m : this.menu)
            {
                if(menu.get(i).getCountry().equalsIgnoreCase(m.getCountry()))
                {
                    counter++;
                }
            }       

            if(counter >= biggest)
            {
                biggest = counter;
                country = menu.get(i).getCountry();
            }
        }
        System.out.println(country);
    }

}
