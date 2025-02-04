package persondatahandler;
//nome,cognome,eta,residenza,

import java.time.LocalDate;

public abstract class Person {
    protected String name;
    protected String surname;
    protected int age;
    protected String residence;

    protected Person(String name, String surname, String age, String residence) {
        this.name = name;
        this.surname = surname;
        this.age = LocalDate.now().getYear() - LocalDate.parse(age).getYear();
        this.residence = residence;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getSurname() {
        return surname;
    }

    protected void setSurname(String surname) {
        this.surname = surname;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected String getResidence() {
        return residence;
    }

    protected void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", surname=" + surname + ", age=" + age + ", residence=" + residence + "]";
    }
}
