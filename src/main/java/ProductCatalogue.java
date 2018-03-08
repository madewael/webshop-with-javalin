import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProductCatalogue {

    private Set<Product> products;

    public Set<Product> getProducts(){
        return Collections.unmodifiableSet(products);
    }

    public ProductCatalogue() {
        CategoryCatalogue categories = new CategoryCatalogue();
        products = new HashSet<>();

        products.add( new Product("apple", null, categories.find("fruit"), 1.0));
        products.add( new Product("pear", null, categories.find("fruit"), 1.5));
        products.add( new Product("pineapple", null, categories.find("fruit"), 2.0));

        products.add( new Product("lettuce", null, categories.find("vegetables"), 1.0));
        products.add( new Product("tomato", null, categories.find("vegetables"), 1.5));
        products.add( new Product("onion", null, categories.find("vegetables"), 2.0));

        products.add( new Product("big white bread", null, categories.find("bread"), 2.0));
        products.add( new Product("small white bread", null, categories.find("bread"), 1.5));
        products.add( new Product("big whole-wheat bread", null, categories.find("bread"), 2.0));

        products.add( new Product("marmalade", null, categories.find("spreads"), 2.0));
        products.add( new Product("choco", null, categories.find("spreads"), 2.0));


        products.add( new Product("cellphone", null, categories.find("electronics"), 2.0));
        products.add( new Product("calculator", null, categories.find("electronics"), 2.0));


    }

    public Product find(String name) {
        for(Product p : products) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

}
