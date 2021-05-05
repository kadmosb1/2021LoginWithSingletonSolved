public class Customer {

    private String name;
    private String address;
    private String zipcode;
    private String city;

    public Customer (String name, String address, String zipcode, String city) {
        if (Login.isAuthenticated ()) {
            this.name = name;
            this.address = address;
            this.zipcode = zipcode;
            this.city = city;
        }
    }

    @Override
    public String toString() {

        if (Login.isAuthenticated ()) {
            return String.format ("%s%n%s%n%s  %s%n", name, address, zipcode, city);
        }

        return "";
    }
}
