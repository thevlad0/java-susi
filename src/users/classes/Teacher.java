package users.classes;

import users.enums.UserType;

public class Teacher extends User {
    private String name;
    private String faculty;

    public Teacher(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
        this.type = UserType.Teacher;
    }

    @Override
    public String printUserInfo() {
        return String.format("%s, %s", name, faculty);
    }
}
