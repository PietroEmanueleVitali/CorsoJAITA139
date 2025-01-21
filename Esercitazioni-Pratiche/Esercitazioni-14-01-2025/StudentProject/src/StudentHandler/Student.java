package StudentHandler;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Student {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int year = Year.now().getValue();
    private int studentClass;
    private char section;
    private float[] votes = new float[6]; //ordine: italiano, matematica, scienze, inglese, educazione fisica, fisica

    public Student(String name, String surname, String yearOfBirth, int  studentClass, char section, float[] votes) {
        this.name = name;
        this.surname = surname;
        this.studentClass = studentClass;
        this.section = section;
        this.votes = votes.clone();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.birthDate = LocalDate.parse(yearOfBirth.trim(), inputFormatter);
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public float[] getVotes() {
        return votes;
    }

    public void setVotes(float[] votes) {
        this.votes = votes;
    }

    public int ageCalculator()
    {
        return this.year - birthDate.getYear();
    }
    public String formatDate()
    {
         // Create formatter for Italian locale
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);
        
        // Format the date
        return birthDate.format(italianFormatter);
    }

    @Override
    public String toString(){
        return String.format("""
            Nome: %s
            Cognome: %s
            DatadiNascina: %s
            Classe: %s
            Sezione: %s
            media dei Voti: %s
        """, this.name, this.surname, this.formatDate(), this.studentClass, this.section, this.averageCalculator());
    }

    public float averageCalculator()
    {
        float average = 0;
        for (float f : this.votes) {
            average += f;
        }

        return average/this.votes.length;
    }

    public boolean isPromoted()
    {
        boolean hasFailed;
        if(this.getStudentClass() == 5)
        {
            for (float f : this.votes)
            {
                hasFailed = f < 6;
                if(hasFailed)
                {
                    return !hasFailed;
                }
            }
        }

        return !(hasFailed = this.averageCalculator() < 6);
    }

    public boolean erasmus()
    {
        boolean hasEverythingOk = false;
        int failedCounter = 0;
        for (float f : this.votes)
        {
            failedCounter += f < 6 ? 1 : 0;
        }
        if(failedCounter > 2 && this.votes[3] >= 9)
            hasEverythingOk = true;

        return this.isPromoted() && hasEverythingOk;
    }

    public int hasScholarship()
    {
        int scholarship = 0;

        if(this.averageCalculator() > 9)
            scholarship = 2000;
        if(this.averageCalculator() > 7 && this.averageCalculator() < 9)
            scholarship = 1000;

        return scholarship;
    }

}

// /Creare un programma che permetta la creazione di oggetti di tipo studente
// Uno studente deve avere le seguenti caratteristiche: 
// Nome
// Cognome
// Data di nascita (String)
// Classe (da 1 a 5)
// Sezione
// Voto italiano (float da 1 a 10)
// Voto matematica
// Voto scienze
// Voto inglese
// Voto educazione fisica
// Voto fisica
// Definire i seguenti metodi: 
// eta() => metodo che calcola l'età sapendo la data di nascita e l'anno attuale
// toString() =>restituire la descrizione dello studente
// float media()=>restituire la media calcolata sui voti
// dello studente
// boolean promosso()=>uno studente è promosso:
// • Se frequenta la 5° non deve avere insufficienze
// • Nelle altre classe deve avere la media sopra il 6
// ma al massimo 2 insufficienze

// boolean erasmus()=>uno studente può andare in
// erasmus se è promosso e ha il voto di inglese sopra il 9 e avere al
// massimo 2 insufficienze
// int borsaDiStudio()=>se lo studente è promosso e ha una media sopra il 9 ha una borsa di studio
// di 2000 euro se invece ha una media tra l'e il 9 di 1000
// I dati li potete inserire manualmente oppure chiederli ad un utente oppure leggerli da un file(lascio un file di esempio per chi lo volesse usare)./
