package users.classes;

import CourseHandler.Course;
import CourseHandler.CourseHandler;
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

    public void addStudentToCourse(int courseID, String student) {
        StudentHandler.addStudentToCourse(courseID, student);
    }

    public void removeStudentFromCourse(int courseID, String student) {
        CourseHandler.deleteAtendant(courseID, student);
    }

    public void gradeStudentOnCourse(int courseID, String student, double grade) {
        CourseHandler.gradeStudent(courseID, student, grade);
    }
}
