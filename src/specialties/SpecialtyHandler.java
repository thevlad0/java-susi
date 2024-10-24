package specialties;

import CourseHandler.Course;
import db.DataHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class SpecialtyHandler {
    private static int specialtyID = 0;
    private HashMap<Integer, Specialty> specialties;

    public static void createSpecialty(String name, Integer yearsToLearn,
                                       HashMap<Integer, ArrayList<Integer>> courses,
                                       HashMap<Integer, ArrayList<Integer>> electiveCourses) {

        DataHandler.writeData(String.valueOf(specialtyID++),
                new Specialty(name, yearsToLearn, courses, electiveCourses));
    }

    public static ArrayList<Integer> getCoursesByYear(int specialtyID, int year) {
        return DataHandler.getSpecialties().get(specialtyID).getCourseListByYear(year);
    }

    public static ArrayList<Integer> getElectiveCoursesByYear(int specialtyID, int year) {
        return DataHandler.getSpecialties().get(specialtyID).getElectiveCourseListByYear(year);
    }
}
