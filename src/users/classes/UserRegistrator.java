package users.classes;

import auth.Authenticator;
import db.DataHandler;
import users.enums.UserType;

public class UserRegistrator {
    private static String genUsername(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(0));
        sb.append(name.split(" ")[1]);

        return sb.toString().toLowerCase();
    }

    public static void registerUser(UserType type, String... args) {
        if (Authenticator.logged instanceof Admin) {
            switch (type) {
                case Student -> {
                    String username = genUsername(args[0]);
                    DataHandler.writeData(username, new Student(args[0], args[2], Integer.valueOf(args[3])));
                    DataHandler.addLoginInfo(username, args[1]);
                }
                case Teacher -> {
                    String username = genUsername(args[0]);
                    DataHandler.writeData(username, new Teacher(args[0], args[2]));
                    DataHandler.addLoginInfo(username, args[1]);
                }
                case Admin -> {
                    String username = genUsername(args[0]);
                    DataHandler.writeData(username, new Admin(args[0]));
                    DataHandler.addLoginInfo(username, args[1]);
                }
            }
        } else {
            throw new IllegalArgumentException("Only Admins can register users");
        }
    }
}
