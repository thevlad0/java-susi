package users.classes;

import CourseHandler.CourseHandler;
import db.DataHandler;
import specialties.SpecialtyHandler;

import java.util.ArrayList;

public class StudentHandler {
    public static void passYear(String student) {
        var courseGrades = DataHandler.getCourseGrades(student);
        var user = DataHandler.getUser(student);
        boolean canPass = true;
        if (user instanceof Student s) {
            var perYearCourses = SpecialtyHandler.getCoursesByYear(s.getSpecialtyID(), s.getCurrentYear());

            // If there is a grade of a course less than 3
            for (var i : perYearCourses) {
                for (var course : courseGrades) {
                    if (course.getCourseID().equals(i) && course.getGrade() < 3) {
                        canPass = false;
                    }
                }
            }

            // If a mandatory course is missing
            if (canPass) {
                var courseGradeIDs = new ArrayList<Integer>();
                for (var course : courseGrades) {
                    courseGradeIDs.add(course.getCourseID());
                }

                for (var courseID : perYearCourses) {
                    if (!courseGradeIDs.contains(courseID)) {
                        canPass = false;
                    }
                }
            }

            if (canPass) {
                s.passYear();
            }
        }
    }

    public static void addStudentToCourse(int courseID, String student) {
        var user = DataHandler.getUser(student);
        if (user instanceof Student s) {
            var possibleCourses = SpecialtyHandler.getElectiveCoursesByYear(s.getSpecialtyID(), s.getCurrentYear());
            if (possibleCourses.contains(courseID)) {
                CourseHandler.addAtendant(courseID, student);
            }
        }
    }

    public static void removeStudentFromCourse(int courseID, String student) {
        CourseHandler.deleteAtendant(courseID, student);
    }
}
