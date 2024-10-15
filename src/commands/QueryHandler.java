package commands;

import commands.queries.Login;
import commands.queries.Query;

// Class to be used for handling of user input commands
public class QueryHandler {
    public static Query parseCommand(String command) {
        String[] tokens = command.split(" ");
        return switch (tokens[0]) {
            case "login" -> new Login(tokens[1], tokens[2]);
            //Operations to be added
            default -> null;
        };
    }
}
