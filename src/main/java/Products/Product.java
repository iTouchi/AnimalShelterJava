package Products;

public class Product implements ISellable {

    private String name;
    private Double price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice(){
        return this.price;
    }
}
