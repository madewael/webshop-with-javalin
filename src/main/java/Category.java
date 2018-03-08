public class Category {

    private String name;
    private int VAT;

    public Category(String name, int VAT) {
        this.name = name;
        this.VAT = VAT;
    }

    public double getPrice(double base) {
        return base + (base*VAT)/100;
    }

    public String toString() {
        return String.format("%s (%d%%)", name, VAT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return name != null ? name.equals(category.name) : category.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }
}
