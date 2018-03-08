public class Customer {


    private int number;
    private String name;

    public Customer(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return number == customer.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return getName();
    }

}
