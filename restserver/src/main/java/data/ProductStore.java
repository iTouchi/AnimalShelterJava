package data;

import domain.product.Product;

import java.util.Collection;
import java.util.HashMap;

public class ProductStore {


    private HashMap<String, Product> store;
    private static ProductStore instance;

    private ProductStore(HashMap<String, Product> store) {
        this.store = store;
    }

    public void addProduct(Product product) {
        store.put(product.getName(), product);
    }

    public Product getProduct(String key) {
        return store.get(key);
    }

    public void removeProduct(String key) {
        store.remove(key);
    }

    public void replaceProduct(Product product) {
        store.replace(product.getName(), product);
    }

    public Collection<Product> getAll() {
        return store.values();
    }

    public static ProductStore getInstance() {
        if (instance == null) {
            instance = new ProductStore(new HashMap<>());
        }
        return instance;
    }

}
