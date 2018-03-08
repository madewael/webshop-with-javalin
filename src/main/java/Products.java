import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Products {

    private Map<Product,Integer> products;

    public Products() {
        products = new HashMap<>();
    }

    public Products(Products other) {
        products = new HashMap<>(other.products);
    }

    public int getCount(Product p) {
        if (products.containsKey(p)){
            return products.get(p);
        } else {
            return 0;
        }
    }

    public Map<Product,Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public double getPrice() {
        double total = 0.0;

        for(Product p : products.keySet()) {
            total += getProductPrice(p);
        }

        return total;
    }

    private double getProductPrice(Product p) {
        return p.getPrice() * getCount(p);
    }

    public int add(Product p) {
        return update(p, getCount(p) + 1);
    }

    public int add(Product p, int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative!");
        }
        return update(p, getCount(p) + amount);
    }

    public int remove(Product p){
        return update(p, getCount(p) - 1);
    }

    public int removeAll(Product p){
        return update(p, 0);
    }

    private int update(Product p, int newCount) {
        if (newCount < 0) {
            throw new IllegalArgumentException("A negative amount of products is not possible");
        }

        products.put(p, newCount);
        return newCount;
    }

    public void add(Products other) {
        for(Product p : other.products.keySet()){
            add(p, other.getCount(p));
        }
    }


}
