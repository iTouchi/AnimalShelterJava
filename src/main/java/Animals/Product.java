package Animals;

public class Product implements ISellable {

    private String name;
    private Decimal price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(Decimal price) {
        this.price = price;
    }

    public Decimal getPrice(){
        return this.price;
    }
}
