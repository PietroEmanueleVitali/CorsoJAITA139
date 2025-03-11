import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
     
// creare una mappa per associare ogni ordine al suo stato.

Map<Integer, String> orders = new HashMap();

orders.put(1, "In elaborazione");
orders.put(2, "terminato");
orders.put(3, "presa in consegna");
orders.put(4, "In elaborazione");
orders.put(5, "terminato");


// Dove l'ordine potrebbe essere o una strimga alfanumerica o un numero(codice a barre numerico)
// Provare a:
// aggiornare lo stato di un'ordine(ad esempio "In elaborazione" oppure "Spedito" oppure "Consegnato"..)

System.out.println("abbiamo cambiato lo stato dell'ordine numero 1 da: " + orders.replace(1, "terminato") + " a terminato");

System.out.println("Stato ordini: ");
// recuperare lo stato degli ordini.
for(var orderstate : orders.values())
{
    System.out.println(orderstate);
}

// visualizzare tutti gli ordini
for(var orderInfo : orders.entrySet())
{
    System.out.println(orderInfo.getKey() + " " + orderInfo.getValue());
    System.out.println("+-------------+");
}
// rimuovere un ordine

System.out.println("Stiamo rimuovendo l'ordine 1 che si trovava in uno stato: " + orders.remove(1));
// verificare se esiste un ordine
if(orders.containsKey(2))
{
    System.out.println("Esiste l'ordine numero 2 e si trova in uno stato " + orders.get(2));
}
// /
// //esempio:
// /
//            +-------------+
// Key:  ORD123 |  Stato: "In elaborazione" |
//            +-------------+
//                    ↓
//            +-------------+
// Key:  ORD124 |  Stato: "Spedito"        |
//            +-------------+
//                    ↓
//            +-------------+
// Key:  ORD125 |  Stato: "Consegnato"     |
//            +-------------+

    }
}
