package persondatahandler;

//proprietà dei chirurghi: nome,cognome,eta,residenza, specializzazione, anniLavoro,tirocinante,numeroInterventi,interventiRiusciti;

public class Surgeon extends Doctor {

    private int numberOpertation;
    private int succededOperation;

    public Surgeon(String name, String surname, String age, String residence, String specialization, String yearsOfWork,
            String internship, String numberOpertation, String succededOperation) {
        super(name, surname, age, residence, specialization, yearsOfWork, internship);
        this.numberOpertation = Integer.parseInt(numberOpertation);
        this.succededOperation = Integer.parseInt(succededOperation);
    }

    public int getNumberOpertation() {
        return numberOpertation;
    }

    public void setNumberOpertation(int numberOpertation) {
        this.numberOpertation = numberOpertation;
    }

    public int getSuccededOperation() {
        return succededOperation;
    }

    public void setSuccededOperation(int succededOperation) {
        this.succededOperation = succededOperation;
    }

    @Override
    public double getSalary()
    {
        double salary = 0;

        salary += succededOperation *20;
        salary -= (numberOpertation - succededOperation) * 10;

        if(numberOpertation > 20)
            salary += Math.floor((double)numberOpertation/20) * 15;

        if(this.getSpecialization().equalsIgnoreCase("cardiologo"))
            salary += 1500 + (this.getYearsOfWork() * 120);
        else if(this.getSpecialization().equalsIgnoreCase("psichiatra"))
            salary += 1300 + (this.getYearsOfWork() * 100);
        else if(this.getSpecialization().equalsIgnoreCase("pediatra"))
            salary += 2000 + (this.getYearsOfWork() * 200);
        else
            salary += 1350 + (this.getYearsOfWork() * 110);
        
        if(this.goodDoctor())
            salary += ((salary/100) * 8);


        salary += ((salary/100) * 20);
        
        return salary;
    }

    @Override
    public boolean goodDoctor(){
        return this.getYearsOfWork() > 3 && ((numberOpertation - succededOperation) > (numberOpertation/3));
    }

    @Override
    public String toString() {
        return super.toString() + "[numberOpertation=" + numberOpertation + ", succededOperation=" + succededOperation + "]";
    }
}
