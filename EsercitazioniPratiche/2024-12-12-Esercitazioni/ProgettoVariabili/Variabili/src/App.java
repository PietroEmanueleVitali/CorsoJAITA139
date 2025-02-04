public class App {
    public static void main(String[] args) throws Exception {
        
        int height;
        height = 5;
        int base = 7;

       //println permette di stampare e andare a capo, utilizzando solo "System.out.print" le cose rimarranno tutte sulla stessa linea.
        System.out.println("In un rettangolo in cui la base vale: " + base + ", mentre il lato vale: " + height + ".");

        //Stiamo consideranto un rettangolo
        int perimeter = (base * 2) + (height * 2); //oppure (base + height) * 2;
        int area = base * height;

        String result = "Il perimetro vale: " + perimeter + ", mentre l'area vale: " + area + ".";
        System.out.println(result);

        double weight = 3.2;
        float weightButFloat = 3.2F;

        char letter = 'a';

    }
}
