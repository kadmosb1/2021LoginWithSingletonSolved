import java.util.ArrayList;

public class Invoice {

    private static int nextInvoiceNumber = 0;
    private Login login;

    public Invoice () {
        login = new Login ();
    }

    private int getNextInvoiceNumber () {
        nextInvoiceNumber += 13;
        return nextInvoiceNumber;
    }

    public void printInvoice (Customer customer, ArrayList<InvoiceLine> lines) {

        double totalPrice = 0.0;

        if (login.isAuthenticated ()) {
            
            System.out.printf("Invoicenumber: %d%n%n", getNextInvoiceNumber());
            System.out.println(customer);

            for (InvoiceLine line : lines) {
                Product product = line.getProduct ();
                int numberOfProducts = line.getNumberOfProducts ();
                double linePrice = product.getPrice () * numberOfProducts;
                totalPrice += linePrice;
                System.out.printf ("%4d %-50s € %8.2f%n", numberOfProducts, product.getName (), linePrice);
            }

            System.out.printf ("%56s----------%n", "");
            System.out.printf ("%56s€ %8.2f%n", "", totalPrice);
        }
        else {
            System.out.println("Niet ingelogd");
        }
    }
}
