package db;

import CourseHandler.Course;
import users.classes.Student;
import users.classes.Teacher;
import users.classes.User;

import java.util.HashMap;

// Class that simulates a database
public class DataHandler {
    private static final HashMap<String, User> users = new HashMap<>();
    private static final HashMap<String, String> loginData = new HashMap<>();
    private static final HashMap<Integer, Course> courses = new HashMap<>();

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

    public static void writeData(String id, Object data) {
        switch (data) {
            case Student s -> users.put(id, (Student) data);
            case Teacher t -> users.put(id, (Teacher) data);

            case Course c -> courses.put(Integer.valueOf(id), (Course) data);

            default -> throw new IllegalStateException("Unexpected value: " + data);
        }
    }
}
