package users.classes;

import CourseHandler.CourseHandler;
import db.DataHandler;
import users.enums.UserType;

public class Student extends User {
    private String name;
    private String facultyNum;
    private Integer specialtyID;
    private Integer currentYear = 1;

    public Student(String name, String facultyNum, Integer specialtyID) {
        this.name = name;
        this.type = UserType.Student;
        this.facultyNum = facultyNum;
        this.specialtyID = specialtyID;
    }

    public int getSpecialtyID() {
        return specialtyID;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void passYear() {
        currentYear++;
    }

    @Override
    public String printUserInfo() {
        return String.format("%s %s", name, facultyNum);
    }
}
