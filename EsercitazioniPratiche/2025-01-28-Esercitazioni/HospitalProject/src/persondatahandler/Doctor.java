package persondatahandler;
//proprietà dei dottori: nome,cognome,eta,residenza, specializzazione, anniLavoro,tirocinante;


public class Doctor extends Person{

    private String specialization;
    private int yearsOfWork;
    private boolean internship;

    public Doctor(String name, String surname, String age, String residence, String specialization, String yearsOfWork,
            String internship) {
        super(name, surname, age, residence);
        this.specialization = specialization;
        this.yearsOfWork = Integer.parseInt(yearsOfWork);
        this.internship = internship.trim().equalsIgnoreCase("si");
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfWork() {
        return yearsOfWork;
    }

    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }

    public boolean isInternship() {
        return internship;
    }

    public void setInternship(boolean internship) {
        this.internship = internship;
    }

    public double getSalary()
    {
        double salary;
        if(this.specialization.equalsIgnoreCase("cardiologo"))
            salary = 1500 + (this.yearsOfWork * 120);
        else if(this.specialization.equalsIgnoreCase("psichiatra"))
            salary = 1300 + (this.yearsOfWork * 100);
        else if(this.specialization.equalsIgnoreCase("pediatra"))
            salary = 2000 + (this.yearsOfWork * 200);
        else
            salary = 1350 + (this.yearsOfWork * 110);
        
        if(this.goodDoctor())
            salary += ((salary/100) * 5);
        
        return salary;
    }

    public boolean goodDoctor(){
        return this.yearsOfWork > 3;
    }

    @Override
    public String toString() {
        return super.toString() + "[specialization=" + specialization + ", yearsOfWork=" + yearsOfWork + ", internship="
                + internship + "]";
    }



    // Dottori
    // -- stipendio dottori:
    //     ogni reparto ha uno stipendio diverso e un bonus per ogni anno di esperienza differente:
    //     Cardiologia: 1500 -> bonus 120
    //     Psichiatria: 1300 -> bonus 100
    //     Pediatria: 2000 -> bonus 200
    //     Altri: 1350 -> bonus 110
    //  -- buonMedico() => Se ha almeno 3 anni di esperienza, ma se è del reparto pediatria è un buon medico a prescindere
    //     dagli anni di esperienza
    // -- stipendio dottori(boolean buonMedico)
    //     restituisce lo stipendio maggiorato del 5% se è un buon medico
}
