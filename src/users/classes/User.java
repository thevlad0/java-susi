package users.classes;

import users.enums.UserType;


public abstract class User {
    protected UserType type;

    public abstract String printUserInfo();
}
