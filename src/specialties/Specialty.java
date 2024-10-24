package specialties;

import CourseHandler.Course;

import java.util.ArrayList;
import java.util.HashMap;

public class Specialty {
    private static Integer specialtyID = 0;
    private String name;
    private Integer yearsToLearn;

    // <Year for which they apply, array of courseIDs>
    private HashMap<Integer, ArrayList<Integer>> courses;
    private HashMap<Integer, ArrayList<Integer>> electiveCourses;

    public Specialty(String name, Integer yearsToLearn, HashMap<Integer, ArrayList<Integer>> courses, HashMap<Integer, ArrayList<Integer>> electiveCourses) {
        this.name = name;
        this.yearsToLearn = yearsToLearn;
        this.courses = courses;
        this.electiveCourses = electiveCourses;
    }

    public ArrayList<Integer> getCourseListByYear(int year) {
        return courses.get(year);
    }

    public ArrayList<Integer> getElectiveCourseListByYear(int year) {
        return electiveCourses.get(year);
    }
}
