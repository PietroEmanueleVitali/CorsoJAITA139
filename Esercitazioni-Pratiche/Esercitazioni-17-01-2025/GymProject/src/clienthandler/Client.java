package clienthandler;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String goal;
    private String personalTrainer;
    private boolean isRegistered;
// Creiamo un programma palestra con degli affiliati letti da un file .csv, dove avranno come proprietà un nome, un cognome, una data di nascita('dob' abbreviato in inglese),
// il nome del loro personal trainer(string personalTrainer), l'obbiettivo che vogliono perseguire(se dimagrire oppure per divertimento, o  definire) e SE hanno OPPURE no un abbonamento,
// (fate un massimo di 3 persone nel file, per non esagerare).
    public Client(String name, String surname, LocalDate dateofbrith, String personaltrainer, String goal, boolean isregistered) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateofbrith;
        this.personalTrainer = personaltrainer;
        this.goal = goal;
        this.isRegistered = isregistered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int calculateAge() {
        // Calculate period between birthdate and current date
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, currentDate);
        
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + ", goal=" + goal
                + ", age=" + this.calculateAge() + ", personalTrainer=" + personalTrainer + ", isRegistered=" + isRegistered + "]";
    }

}
