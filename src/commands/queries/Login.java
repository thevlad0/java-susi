package commands.queries;

import auth.Authenticator;

public class Login implements Query {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {
        if (Authenticator.login(username, password)) {
            System.out.printf("Logged in as %s successfully!%n", username);
        } else {
            System.out.printf("Login failed!%n");
        }

    }
}
