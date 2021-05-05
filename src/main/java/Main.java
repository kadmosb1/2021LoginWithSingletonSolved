import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer ("Testklant", "Teststraat 15", "2282 CD", "DELFT");
        Product product = new Product ("Testproduct", 22.0);
        ArrayList <InvoiceLine> lines = new ArrayList<> ();
        InvoiceLine line = new InvoiceLine (2, product);
        lines.add (line);
        new Invoice ().printInvoice (customer, lines);
    }
}
