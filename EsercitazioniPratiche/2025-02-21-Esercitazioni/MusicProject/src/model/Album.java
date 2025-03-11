package model;
// album
// id, name, date_release

import java.time.LocalDate;

public class Album extends Entity{


    private String name;
    private LocalDate date_release;

    public Album(){}

    public Album(String name, LocalDate date_release)
    {
        this.name = name;
        this.date_release = date_release;
    }

    public Album(Long id, String name, LocalDate date_release) {
        super(id);
        this.name = name;
        this.date_release = date_release;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDate_release() {
        return date_release;
    }
    public void setDate_release(LocalDate date_release) {
        this.date_release = date_release;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", name=" + name + ", date_release=" + date_release + "]";
    }
    

}
