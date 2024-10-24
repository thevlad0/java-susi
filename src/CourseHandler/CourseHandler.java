package CourseHandler;

import db.DataHandler;

import java.util.List;

public class CourseHandler {
    private static int courseID = 0;

    private CourseHandler() {}

    public static void createCourse(String name, String headTeacher, String description) {
        DataHandler.writeData(String.valueOf(courseID++), new Course(name, headTeacher, description));
    }

    public static List<String> getCourseAttendants(int courseId) {
        return DataHandler.getCoursesList().get(courseId).getAtendants();
    }

    public static void deleteCourse(int courseId) {
        DataHandler.getCoursesList().remove(courseId);
    }

    public static void addAtendant(int courseId, String username) {
        DataHandler.getCoursesList().get(courseId).addAtendant(username);
    }

    public static void deleteAtendant(int courseId, String username) {
        DataHandler.getCoursesList().get(courseId).removeAtendant(username);
    }

    public static void gradeStudent(int courseId, String username, double grade) {
        DataHandler.writeData(username, new CourseGrade(courseId, grade));
    }

}
