import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        //cosa sono le mappe?
        // Permettono di salvere dei dati ma non hanno un indice, utilizzano delle coppie chiave-valore
        //La chiave non può essere null, deve essere univoca, le chiavi possono essere oggetti
        //Il valore abbinato alla chiave può essere qualsiasi cosa

        //Dichiarazione di una mappa
        //map è una interfaccia, i tipi concreti che permette di utilizzare sono hashmap (chiave-valore)
        //nelle mappe non abbiamo un indice, ci interessa solo la combo chiave-valore e si usano le chiavi per lavorarci
        Map<String, String> users = new HashMap<>(); 

        users.put("mariorossi@gmail.com", "admin");
        users.put("filippo@gmail.com", "user"); //cosa accade se duplico una chiave all'inserimento? Sovrascrivo il suo valore
        users.put("marco@gmail.com", "admin");
        users.put("luigi@gmail.com", "bowser");

        //Quali sono i metodi che posso usare sulle mappe?

        //Controllo se esiste una determinata chiave, o se esiste un determinato valore associato
        if (users.containsKey("mariorossi@gmail.com") || users.containsValue("admin")) {
            //Stampo prendo il valore associato ad una determinata chiave tramite il .get()
            System.out.println("Benvenuto generale mario, chi vuole nuclearizzare oggi?" + " Il suo ruolo è " + users.get("mariorossi@gmail.com"));
        }

        //posso ciclare tutto il dizionario? Prendo tutti i values e li metto in una lista, poi posso usarla come un normale arraylist
        users.values();


        

        System.out.println();

        for(var key : users.keySet())
        {
            System.out.println(key);
        }

        //Entryset restituisce un set di coppie chiave valore (entry)
        for(Entry<String, String> string : users.entrySet())
        {
            System.out.println(string.getKey() + " " + string.getValue());
        }

        //abbiamo anche i metodi per togliere i valori
        System.out.println(users.remove("mariorossi@gmail.com")); // ricevo come risposta il valore(value) se è andato a buon fine, altrimenti null
        //posso anche passargli due valori .remove("key", "value") che torna come valore un boolean

        for(Entry<String, String> string : users.entrySet())
        {
            System.out.println(string.getKey() + " " + string.getValue());
        }

        // Map.clear per pulirla da tutti i valori
        //map.replace per sovrascirvere un vecchio valore con uno nuovo, te lo cerca già lui

    }
}
