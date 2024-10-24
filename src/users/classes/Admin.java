package users.classes;

import db.DataHandler;
import specialties.Specialty;
import specialties.SpecialtyHandler;
import users.enums.UserType;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin extends User {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    @Override
    public String printUserInfo() {
        return String.format("%s", name);
    }

    public void addUser(UserType type, String... args) {
        UserRegistrator.registerUser(type, args);
    }

    public void addSpecialty(String name, Integer yearsToLearn, HashMap<Integer, ArrayList<Integer>> courses, HashMap<Integer, ArrayList<Integer>> electiveCourses) {
        SpecialtyHandler.createSpecialty(name, yearsToLearn, courses, electiveCourses);
    }
}
