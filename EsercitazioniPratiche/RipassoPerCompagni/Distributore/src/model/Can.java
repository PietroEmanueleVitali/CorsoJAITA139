package model;

import utils.IMappable;

public class Can implements IMappable{

    private int can_id;
    private String name;
    
    public Can() {
    }

    public Can(String name) {
        this.name = name;
    }

    public Can(int can_id, String name) {
        this.can_id = can_id;
        this.name = name;
    }
    
    public int getCan_id() {
        return can_id;
    }
    public void setCan_id(int can_id) {
        this.can_id = can_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Can [can_id=" + can_id + ", name=" + name + "]";
    }

}
