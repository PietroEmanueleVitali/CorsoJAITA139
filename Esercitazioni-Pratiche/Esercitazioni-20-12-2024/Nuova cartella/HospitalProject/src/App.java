/*

Creare un programma che chiede all'utente di inserire i dati di medici.

// PARTE BONUS: 
// - Trovare il nome del medico che percepisce lo stipendio più ALTO, ma non del reparto Pediatria
// - Voglio trovare il numero di serial killer che ci sono: un medico è serial killer se il numero di interventi FALLITI è
// almeno il doppio di quelli riusciti. Ad eccezione dei pediatri.
// Loro possono sbagliare senza diventare serial killer. 
// - Voglio anche la lista dei serial killer
// - Trovare il nome del medico che ha il massimo delle uccisioni 
// - Trovare il nome del medico che ha il rapporto uccisioni / salvataggi più alta
*/

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner UserInput = new Scanner(System.in);
        int numberOfDoctors;
        double totalEarning = 0;
        double averageEarning = 0;
        int pediatricians = 0;
        int PediatriciansEarning = 0;
        double numberOfKills = 0;
        String bestKillerWorstDoctor = "";
        double ratio = 0;
        String bestRatioDoctor = "";

        double singleDoctorEarnings;
        double doctorThatEarnsMore = 0;
        double currentKills = 0;

        // Per ogni medico chiedere: 
        // - Il nome
        // - I suoi anni di esperienza
        // - Il reparto in cui lavoro
        // - Il numero di interventi 
        // - Il numero di interventi riusciti
        String name;
        int ageOfExperience;
        String department;
        int numberOfOperations;
        double succededOperations;
        double currentRatio;

        Stack<String> killers = new Stack<String>();
        
        //Chiedere innanzitutto il numero di medici da inserire
        System.out.println("Quanti medici vuole inserie?");
        numberOfDoctors = UserInput.nextInt();


        for(int i = 1; i <= numberOfDoctors; i++){

            singleDoctorEarnings = 0;

            System.out.println(String.format("""
                Dati del medico numero %s:
                Quanti anni ha di esperienza?
                """, i));    
            ageOfExperience = UserInput.nextInt();
                
            System.out.println("Come si chiama?");
            name = UserInput.next();

            System.out.println("In quale reparto lavora?");
            department = UserInput.next().toLowerCase();

            System.out.println("Quante operazioni ha svolto?");
            numberOfOperations = UserInput.nextInt();

            System.out.println("Quante di queste hanno avuto successo?");
            succededOperations = UserInput.nextInt();

            // Per ogni medico calcoleremo il suo stipendio nel seguente modo: 
            // - A seconda del reparto hanno stipendi di base differenti: 
            // • Ortopedia: 2800
            // • Chirurgia generale: 3000
            // • Pediatria: 2700
            // • Tutti gli altri casi: 2500

            switch(department)
            {
                case "ortopedia":
                    totalEarning += 2000; 
                    singleDoctorEarnings = 2000;
                break; 
                case "chirurgia":
                    totalEarning += 3000; 
                    singleDoctorEarnings = 3000;
                break; 
                case "pediatria":
                    totalEarning += 2700; 
                    pediatricians ++;
                    PediatriciansEarning += 2700;
                break; 
                default:
                    totalEarning += 2500; 
                    singleDoctorEarnings = 2500;
            }

            

            // - Per ogni anno di esperienza aggiungere al medico 50€, MA se lavora nel reparto pediatria, 
            // l'aumento per ogni anno è di 100€
            // - Per ogni intervento RIUSCITO aggiungere 10€
            // - Per ogni intervento NON RIUSCITO togliere 50€ Ma se lavora nel reparto pediatria gliene togliamo 20 in più

            totalEarning += (department.equalsIgnoreCase("pediatra")) ? ageOfExperience * 100 : ageOfExperience * 50;
            singleDoctorEarnings += (department.equalsIgnoreCase("pediatra")) ? ageOfExperience * 100 : ageOfExperience * 50;

            totalEarning -= (department.equalsIgnoreCase("pediatra")) ? (numberOfOperations - succededOperations) * 70 : (numberOfOperations - succededOperations) * 50;
            singleDoctorEarnings -= (department.equalsIgnoreCase("pediatra")) ? (numberOfOperations - succededOperations) * 70 : (numberOfOperations - succededOperations) * 50;

            totalEarning += succededOperations * 10;
            singleDoctorEarnings += succededOperations * 10;

            doctorThatEarnsMore = (singleDoctorEarnings > doctorThatEarnsMore) ? singleDoctorEarnings : doctorThatEarnsMore; 

            if ((succededOperations*2) < (numberOfOperations - succededOperations) && !department.equalsIgnoreCase("pediatra")) {
                killers.push(name);

                currentKills = numberOfOperations - succededOperations;
                if (currentKills > numberOfKills) {
                    numberOfKills = currentKills;
                    bestKillerWorstDoctor = name;
                }
        
                if(succededOperations > 0){
                    currentRatio = (numberOfOperations - succededOperations) / succededOperations;
                    if (currentRatio > ratio) {
                        ratio = currentRatio;
                        bestRatioDoctor = name;
                    }
                } else {
                    currentRatio = numberOfOperations;
                    if (currentRatio > ratio) {
                        ratio = currentRatio;
                        bestRatioDoctor = name;
                    }
                }
            }
    }

    // Calcolare e stampare le seguenti informazioni: 
    // - Lo stipendio totale dei medici 
    // - Lo stipendio medio dei medici 
    // - Il NUMERO di medici che lavorano nel reparto pediatria
    // - Lo stipendio medio dei pediatri

    if(pediatricians > 0){
        System.out.println(String.format("""
                Stipendio totale dei medici: %s
                Stipendio medio dei medici: %s
                Numero di pediatri: %s
                Stipendio medio dei pediatri: %s
        """, totalEarning, (totalEarning/numberOfDoctors), pediatricians, (PediatriciansEarning/pediatricians)));
    }
    else{
        System.out.println(String.format("""
            Stipendio totale dei medici: %s
            Stipendio medio dei medici: %s
    """, totalEarning, (totalEarning/numberOfDoctors)));
    }

    // PARTE BONUS: 
    // - Trovare il nome del medico che percepisce lo stipendio più ALTO, ma non del reparto Pediatria
    // - Voglio trovare il numero di serial killer che ci sono: un medico è serial killer se il numero di interventi FALLITI è
    // almeno il doppio di quelli riusciti. Ad eccezione dei pediatri.
    // Loro possono sbagliare senza diventare serial killer. 

    // - Voglio anche la lista dei serial killer

    // - Trovare il nome del medico che ha il massimo delle uccisioni 

    // - Trovare il nome del medico che ha il rapporto uccisioni / salvataggi più alta

    System.out.println(String.format("""
        Il medico che guadagna di più prende : %s.
        Il killer è: %s.
        Medico con peggior ratio: %s
    """, doctorThatEarnsMore, bestKillerWorstDoctor, bestRatioDoctor));

    System.out.println("Lista killer:");
    System.out.println(killers);

    }
}
