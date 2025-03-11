
public class App {
    public static void main(String[] args) throws Exception {


        
        Acqua uliveto = new Acqua("Uliveto");
        Bottiglia<Acqua> bottigliaAcqua = new Bottiglia<>(uliveto);




        Vino negroamaro = new Vino("Negroamaro");
        Bottiglia<Vino> bottigliaVino = new Bottiglia<>(negroamaro);



        // ArrayList<String> lista = new ArrayList<>();
        // ArrayList<Integer> lista1 = new ArrayList<>();
        // ArrayList<Double> lista2 = new ArrayList<>();

   
        // System.out.println(lista);



        // GenericClass<String> genericWithStringInside = new GenericClass<>("In automatico sostituisce T con String");

        // System.out.println(genericWithStringInside.getGenericAttribute());



        // GenericClass<Integer> genericWithInteger = new GenericClass<Integer>(2);

        // System.out.println(genericWithInteger.getGenericAttribute());


        // genericWithInteger.setGenericAttribute(3);
        // System.out.println(genericWithInteger.getGenericAttribute());
    }
}
