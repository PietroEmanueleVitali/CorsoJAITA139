package models;

public abstract class Entities {
   
    private int id;

    protected Entities(){}

    protected Entities(int id){
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + "]";
    }
}
