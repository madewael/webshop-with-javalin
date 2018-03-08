import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomerRepository {

    Set<Customer> customers;

    public Set<Customer> getCustomers(){
        return Collections.unmodifiableSet(customers);
    }

    public CustomerRepository() {
        customers = new HashSet<>();

        customers.add(new Customer(0, "Alice"));
        customers.add(new Customer(1, "Bob"));
        customers.add(new Customer(2, "Carol"));

    }

    public Customer find(String name) {
        for(Customer c : customers) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public Customer find(int number) {
        for(Customer c : customers) {
            if (c.getNumber() == number){
                return c;
            }
        }
        return null;
    }

}
