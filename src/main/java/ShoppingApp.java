import java.util.Random;
import java.util.Set;

public class ShoppingApp {

    CategoryCatalogue categories = new CategoryCatalogue();
    ProductCatalogue products = new ProductCatalogue();
    CustomerRepository customers = new CustomerRepository();

    Shop shop = new Shop();

    public ShoppingApp() {
        Products initialStock = new Products();

        Product[] products = this.products.getProducts().toArray(new Product[]{});
        Random r = new Random();
        for(int i=0; i<100; i++) {
            initialStock.add(products[r.nextInt(products.length)]);
        }

        shop.restock(initialStock);

    }


    public Set<Product> getProducts() {
        return products.getProducts();
    }

    public Set<Customer> getCustomers() {
        return customers.getCustomers();
    }

    public Customer findCustomer(int customerId) {
        Customer c = customers.find(customerId);

        if (c == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return c;
    }

    public StockAndCart getStockAndCart(Customer customer) {
        return shop.getStockAndCart(customer);
    }

    public Product findProduct(String productName) {
        return products.find(productName);
    }

    public void addToCart(Customer customer, Product product) {
        shop.addToCart(customer, product);
    }

    public void removeFromCart(Customer customer, Product product) {
        shop.removeFromCart(customer, product);
    }

    public StockAndCart buy(Customer customer) {
        return new StockAndCart(shop.getStock(), shop.buy(customer));
    }

    public StockAndCart dropCart(Customer customer) {
        return new StockAndCart(shop.getStock(), shop.buy(customer));
    }

    public Products dropCartOf(Customer customer) {
        shop.dropCartOf(customer);
        return shop.getStock();
    }

    public Customer findCustomer(String name) {
        Customer c = customers.find(name);

        if (c == null) {
            throw new IllegalArgumentException("Customer not found");
        }

        return c;
    }

    public Products getStock() {
        return shop.getStock();
    }
}
