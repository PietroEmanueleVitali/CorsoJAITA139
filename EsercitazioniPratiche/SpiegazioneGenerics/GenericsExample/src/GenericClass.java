

public class GenericClass <T, K extends Number> {

    private T genericAttribute;
    private K AccettaSoloNumeri;

    public GenericClass( T value)
    {
        this.genericAttribute = value;
    }

    public T getGenericAttribute()
    {
        return genericAttribute;
    }

    public void setGenericAttribute(T value)
    {
        this.genericAttribute = value;
    }

}
