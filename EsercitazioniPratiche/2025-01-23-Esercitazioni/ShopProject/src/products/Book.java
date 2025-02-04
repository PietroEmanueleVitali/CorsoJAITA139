package products;
//autore, numero di pagine, genere, copertina rigina 

public class Book extends Product {

    private String author;
    private int numberOfPAges;
    private String genre;
    private boolean isHardCovered;

    public Book(String type, String name, String productcode, String weight, String author, String numberOfPAges, String genre,
            String isHardCovered) {
        super(type, name, productcode, weight);
        this.author = author;
        this.numberOfPAges = Integer.parseInt(numberOfPAges);
        this.genre = genre;
        this.isHardCovered = Boolean.parseBoolean(isHardCovered);
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProductCode() {
        return this.productcode;
    }

    @Override
    public void setProductCode(String productcode) {
        this.productcode = productcode;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(int weigth) {
        if(weigth > 0)
            this.weight = weigth;
        else
            this.weight = 0;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPAges() {
        return numberOfPAges;
    }

    public void setNumberOfPAges(int numberOfPAges) {
        if(numberOfPAges > 0)
            this.numberOfPAges = numberOfPAges;
        else
            this.numberOfPAges = 0;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isHardCovered() {
        return isHardCovered;
    }

    public void setHardCovered(boolean isHardCovered) {
        this.isHardCovered = isHardCovered;
    }

    @Override
    public String toString() {
        return  super.toString() + "author=" + author + ", numberOfPAges=" + numberOfPAges + ", genre=" + genre + ", isHardCovered="
                + isHardCovered;
    } 
}
