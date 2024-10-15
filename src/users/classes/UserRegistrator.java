package users.classes;

import db.DataHandler;
import users.enums.UserType;

public class UserRegistrator {
    private static String genUsername(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.charAt(0));
        sb.append(name.split(" ")[1]);

        return sb.toString().toLowerCase();
    }

    // TODO: Find out how to add args* to function
    public static void registerUser(UserType type, String name, String password) {
        switch (type) {
            case Student -> {
                String username = genUsername(name);
                DataHandler.writeData(username, new Student(name, "0"));
                DataHandler.addLoginInfo(username, password);
            }
            case Teacher -> {
                String username = genUsername(name);
                DataHandler.writeData(username, new Teacher(name, "FMI"));
                DataHandler.addLoginInfo(username, password);
            }
        }
    }
}
