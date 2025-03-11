package model;

import utils.IMappable;

public class Ingredient implements IMappable{

    private int ingredient_id;
    private String name;
    
    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
    }
    
    public Ingredient(int ingredient_id, String name) {
        this.ingredient_id = ingredient_id;
        this.name = name;
    }
    
    public int getIngredient_id() {
        return ingredient_id;
    }
    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Ingredient [ingredient_id=" + ingredient_id + ", name=" + name + "]";
    }
}
