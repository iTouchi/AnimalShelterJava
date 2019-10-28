package domain.product;

import domain.ISellable;

public class Product implements ISellable {

    private String name;
    private Double price;

    public Product() {
    }

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product: " + this.name + ", " + "$ " + this.price;
    }

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
