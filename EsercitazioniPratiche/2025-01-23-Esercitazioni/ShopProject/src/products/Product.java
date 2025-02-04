package products;
//       titolo, codice, peso, autore, numero di pagine, genere, copertina rigina 
// Libro,
//  Cobol,LB637955,2,Spoletini,informatica,35,SI
//      nome, codice, peso, taglia, materiali
// abbigliamento,
//  pantalone,AB956071,51,46,Cotone-cashmere-carta-oro-cartone-plexiglas


public abstract class Product {
    
    protected String type;
    protected String name;
    protected String productcode;
    protected int weight;

    protected Product(String type, String name, String productcode, String weight) {
        this.type = type;
        this.name = name;
        this.productcode = productcode;
        this.weight = Integer.parseInt(weight);
    }

    protected abstract String getType();
    public abstract void setType(String type);

    protected abstract String getName();
    protected abstract void setName(String name);

    protected abstract String getProductCode();
    protected abstract void setProductCode(String productcode);
    
    protected abstract int getWeight();
    protected abstract void setWeight(int weigth);

    @Override
    public String toString() {
        return "Product: type=" + type + ", name=" + name + ", productcode=" + productcode + ", weight=" + weight;
    }
}
