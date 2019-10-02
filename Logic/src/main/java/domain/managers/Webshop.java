package domain.managers;

import domain.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Webshop {

    private final ObservableList<Product> products = FXCollections.observableArrayList();

    public ObservableList<Product> getProducts(){
        return products;
    }

    public void addProducts(Product product){
        products.add(product);
    }
}
