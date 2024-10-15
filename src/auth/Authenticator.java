package auth;

import db.DataHandler;
import users.classes.User;

public class Authenticator {
    //Contains the currently logged user username
    public static String logged;

    private Authenticator() {}

    //True - login successful, false - no existing user
    public static boolean login(String username, String password) {
        return DataHandler.tryLogin(username, password);
    }

    public static void logout() {
        logged = null;
    }
}
