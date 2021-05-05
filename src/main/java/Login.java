import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    private static Login singleton;
    private ArrayList<User> users;
    private User user;

    private Login () {
        users = new ArrayList<> ();
        users.add (new User ("x", "y"));
        users.add (new User ("a", "b"));
        users.add (new User ("k", "l"));
        user = null;
    }

    public static Login getInstance () {

        if (singleton == null) {
            singleton = new Login ();
        }

        return singleton;
    }

    private boolean userExists (String name) {

        for (User user : users) {
            if (user.getName ().equals (name)) {
                this.user = user;
                return true;
            }
        }

        return false;
    }

    public boolean userIsAuthenticated () {
        return user != null;
    }

    public boolean isAuthenticated () {

        if (userIsAuthenticated ()) {
            return true;
        }
        else {

            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {

                System.out.println ("=================");
                System.out.print("Met welke gebruikersnaam wilt u inloggen? ");
                String userName = scanner.nextLine();
                System.out.print ("Graag het bijbehorende password: ");
                String password = scanner.nextLine();
                System.out.println ("=================");

                if (userExists (userName) && user.passwordIsCorrect(password)) {
                    System.out.println ();
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