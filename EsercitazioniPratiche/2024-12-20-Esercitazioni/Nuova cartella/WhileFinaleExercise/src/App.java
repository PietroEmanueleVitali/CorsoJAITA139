public class App {
    public static void main(String[] args) throws Exception {
        
        //stampare tutti i numeri da 1 a 50
        int numberToPrint = 0;

        while(numberToPrint < 40 ){
            numberToPrint++;
            System.out.println(numberToPrint);
        }


        while(numberToPrint > 0 ){
            numberToPrint--;
            System.out.println(numberToPrint);
        }

        while(numberToPrint <= 40)
        {
            System.out.println(numberToPrint);
            numberToPrint +=3;
        }

    }
}
