package wineshop;
//Title;Description;Price;Capacity;Grape;Secondary Grape Varieties;Closure;Country;Characteristics;Type;ABV;Region;Style;Vintage

public class Wine {

    private String title;
    private String description;
    private double price;
    private double capacity;
    private String Grape;
    private String secondaryGrapeVarieties;
    private String clousure;
    private String country;
    private String characteristics;
    private String type;
    private double abv;
    private String region;
    private String style;
    private int vintage;

    public Wine () {}
    
    public Wine(String title, String description, double price, double capacity, String grape,
            String secondaryGrapeVarieties, String clousure, String country, String characteristics, String type, double abv, String region,
            String style, int vintage) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
        Grape = grape;
        this.secondaryGrapeVarieties = secondaryGrapeVarieties;
        this.clousure = clousure;
        this.country = country;
        this.characteristics = characteristics;
        this.type = type;
        this.abv = abv;
        this.region = region;
        this.style = style;
        this.vintage = vintage;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    public String getGrape() {
        return Grape;
    }
    public void setGrape(String grape) {
        Grape = grape;
    }
    public String getSecondaryGrapeVarieties() {
        return secondaryGrapeVarieties;
    }
    public void setSecondaryGrapeVarieties(String secondaryGrapeVarieties) {
        this.secondaryGrapeVarieties = secondaryGrapeVarieties;
    }
    public String getClousure() {
        return clousure;
    }
    public void setClousure(String clousure) {
        this.clousure = clousure;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getAbv() {
        return abv;
    }
    public void setAbv(double abv) {
        this.abv = abv;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public int getVintage() {
        return vintage;
    }
    public void setVintage(int vintage) {
        this.vintage = vintage;
    }
    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Wine [title=" + title + ", description=" + description + ", price=" + price + ", capacity=" + capacity
                + ", Grape=" + Grape + ", secondaryGrapeVarieties=" + secondaryGrapeVarieties + ", clousure=" + clousure
                + ", country=" + country + ", characteristics=" + characteristics + ", type=" + type + ", abv=" + abv
                + ", region=" + region + ", style=" + style + ", vintage=" + vintage + "]";
    }

}
