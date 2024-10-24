package db;

import CourseHandler.Course;
import CourseHandler.CourseGrade;
import specialties.Specialty;
import users.classes.Student;
import users.classes.Teacher;
import users.classes.User;

import java.util.ArrayList;
import java.util.HashMap;

// Class that simulates a database
public class DataHandler {
    private static final HashMap<String, User> users = new HashMap<>();
    private static final HashMap<String, String> loginData = new HashMap<>();
    private static final HashMap<Integer, Course> courses = new HashMap<>();
    private static final HashMap<String, ArrayList<CourseGrade>> courseGrades = new HashMap<>();
    private static final HashMap<Integer, Specialty> specialties = new HashMap<>();

    private DataHandler() {
        // Add users data
        // users.put("vvelikov", new Student("Vladimir Velikov", "0MI0600204"));
        // users.put("mdelikotseva", new Student("Vladimir Velikov", "1MI0600204"));
        // users.put("ggeorgiev", new Teacher("Georgi Georgiev", "FMI"));

        // Add user credentials
        // loginData.put("vvelikov", "12345");
        // loginData.put("mdelikotseva", "12345");
        // loginData.put("ggeorgiev", "12345");

        // Add courses data
        // courses.put()
    }

    public static boolean tryLogin(String username, String password) {
        return (loginData.containsKey(username) && loginData.get(username).equals(password));
    }

    public static User getUser(String username) {
        return users.get(username);
    }

    public static void addLoginInfo(String username, String password) {
        loginData.put(username, password);
    }

    public static HashMap<Integer, Course> getCoursesList() {
        return courses;
    }

    public static ArrayList<CourseGrade> getCourseGrades(String username) {
        return courseGrades.get(username);
    }

    public static HashMap<Integer, Specialty> getSpecialties() {
        return specialties;
    }

    public static void writeData(String id, Object data) {
        switch (data) {
            case Student s -> users.put(id, s);
            case Teacher t -> users.put(id, t);

            case Course c -> courses.put(Integer.valueOf(id), c);
            case CourseGrade c -> {
                if (courseGrades.containsKey(id)) {
                    courseGrades.get(id).add(c);
                } else {
                    courseGrades.put(id, new ArrayList<CourseGrade>());
                    courseGrades.get(id).add(c);
                }
            }

            case Specialty s -> {
                specialties.put(Integer.valueOf(id), s);
            }

            default -> throw new IllegalStateException("Unexpected value: " + data);
        }
    }
}
