/*
 * Nel nominare le variabili non si mettono: spazi vuoti, caratteri speciali, non si inizia il nome con un numero, i nomi delle variabili sono lowerCamelCase
 */

public class App {
    public static void main(String[] args) throws Exception {
        
        String name = "Pietro";
        String secondName = "Emanuele";
        String surName = "Vitali";
        String cityOfResidence = "Milan";
        int age = 24;

        float height = 1.82F;

        

        System.out.println("Nome: " + name + " "  + secondName);
        System.out.println("Cognome: "+ surName);
        System.out.println("Residenza: "+ cityOfResidence);
        System.out.println("Età: "+ age);
        System.out.println("Altezza: "+ height);


    }
}
