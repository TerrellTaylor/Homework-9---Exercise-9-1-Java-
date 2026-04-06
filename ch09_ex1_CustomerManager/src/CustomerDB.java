import java.util.ArrayList;

public final class CustomerDB {

    private static final String FILENAME = "customers.txt";
    private static final String COL_SEP = "\t";    

    public static ArrayList<Customer> getAll() {
        var customers = new ArrayList<Customer>();
        
        // load the array list with Customer objects created from
        // the data in the file
        
        return customers;
    }

    public static void saveAll(ArrayList<Customer> customers) {
        // save the Customer objects in the array list to the file
    }
}