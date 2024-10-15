package users.classes;

import users.enums.UserType;

public class Student extends User {
    private String name;
    private String facultyNum;

    public Student(String name, String facultyNum) {
        this.name = name;
        this.type = UserType.Student;
        this.facultyNum = facultyNum;
    }

    @Override
    public String printUserInfo() {
        return String.format("%s %s", name, facultyNum);
    }
}
