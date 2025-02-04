package persondatahandler;

//proprietà dei pazienti: nome,cognome,eta,residenza,reparto,giorniRicovero,costoGiornaliero

public class Patient extends Person {

    private String department;
    private int recoveryDays;
    private int priceDay;


    public Patient(String name, String surname, String age, String residence, String department, String recoveryDays,
            String priceDay) {
        super(name, surname, age, residence);
        this.department = department;
        this.recoveryDays = Integer.parseInt(recoveryDays);
        this.priceDay = Integer.parseInt(priceDay);
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public int getRecoveryDays() {
        return recoveryDays;
    }


    public void setRecoveryDays(int recoveryDays) {
        this.recoveryDays = recoveryDays;
    }


    public int getPriceDay() {
        return priceDay;
    }


    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public int howMuchForThis()
    {
        return this.priceDay * this.recoveryDays;
    }

    @Override
    public String toString() {
        return super.toString() + "[department=" + department + ", recoveryDays=" + recoveryDays + ", priceDay=" + priceDay + "]";
    }
}
