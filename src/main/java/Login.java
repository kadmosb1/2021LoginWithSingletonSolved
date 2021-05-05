import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    private static Login singleton;
    private ArrayList<User> users;
    private boolean isLoggedIn;

    private Login () {
        users = new ArrayList<> ();
        users.add (new User ("x", "y"));
        users.add (new User ("a", "b"));
        users.add (new User ("k", "l"));
        isLoggedIn = false;
    }

    public static Login getInstance () {

        if (singleton == null) {
            singleton = new Login ();
        }

        return singleton;
    }

    private User getUser (String name) {
        for (User user : users) {
            if (user.getName ().equals (name)) {
                return user;
            }
        }

        return null;
    }

    public boolean isAuthenticated () {

        if (isLoggedIn) {
            return true;
        }
        else {

            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {

                System.out.println ("=================");
                System.out.print("Met welke gebruikersnaam wilt u inloggen? ");
                String gebruikersnaam = scanner.nextLine();
                System.out.print("Graag het bijbehorende password: ");
                String password = scanner.nextLine();
                System.out.println ("=================");

                User user = getUser (gebruikersnaam);

                if (user != null && user.getPassword().equals(password)) {
                    System.out.println ();
                    isLoggedIn = true;
                    return true;
                }

                System.out.println ("De combinatie van gebruikersnaam en password is niet OK.");
            }

            System.out.println ("=================");
            System.out.println ();
            return false;
        }
    }
}