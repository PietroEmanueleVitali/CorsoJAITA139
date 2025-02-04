package products;
// abbigliamento,
//  pantalone,AB956071,51,46,Cotone-cashmere-carta-oro-cartone-plexiglas

public class Clothes extends Product {

    private int size;
    private String material;

    protected Clothes(String type, String name, String productcode, String weight, String size, String material) {
        super(type, name, productcode, weight);
        this.size = Integer.parseInt(size);
        this.material = material;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getProductCode() {
        return this.productcode;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setName(String name) {
       this.name = name;
        
    }

    @Override
    public void setProductCode(String productcode) {
        this.productcode = productcode;
        
    }

    @Override
    public void setType(String type) {
        this.type = type;
        
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

        
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + " size= " + this.size + " materials= " + this.material;
    }

    


}
