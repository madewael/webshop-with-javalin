public class Product {

    private String name;
    private String description;

    private Category category;
    private double price;

    public Product(String name, String description, Category category, double price) {
        if (name==null || category == null ) {
            throw new IllegalArgumentException("A products name or category cannot be null.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("A products price cannot be zero or less.");
        }

        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public double getPrice() {
        return category.getPrice(price);
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String toString() {
        return getName();
    }
}
