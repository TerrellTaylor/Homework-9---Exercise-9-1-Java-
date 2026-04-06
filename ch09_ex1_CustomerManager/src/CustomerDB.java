import java.util.ArrayList;
import java.io.*;


// This code should work, but the FileReader cannot find the text file.
// I've made sure that it isn't reading the file as "customers.txt.txt" in Windows Explorer.
public final class CustomerDB {

    private static final String FILENAME = "customers.txt";
    private static final String COL_SEP = "\t";    

    public static ArrayList<Customer> getAll() {
        var customers = new ArrayList<Customer>();
        
        // load the array list with Customer objects created from
        // the data in the file
        try (BufferedReader in = new BufferedReader(new FileReader(FILENAME)))
        {
            String data = in.readLine();
            while (data != null)
            {
                String[] columns = data.split(COL_SEP);
                String firstName = columns[0];
                String lastName = columns[1];
                String email = columns[2];

                Customer c = new Customer(firstName, lastName, email);
                customers.add(c);

                data = in.readLine();
            }
            return customers;
        }
        catch (FileNotFoundException e)
        {
            System.out.println(FILENAME + " was not found.");
            return null;
        }
        catch (IOException e)
        {
            System.out.println(e);
            return null;
        }
    }

    public static void saveAll(ArrayList<Customer> customers) {
        // save the Customer objects in the array list to the file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME))))
        {
            for (Customer c : customers)
            {
                out.print(c.getFirstName() + COL_SEP);
                out.print(c.getLastName() + COL_SEP);
                out.print(c.getEmail());
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}