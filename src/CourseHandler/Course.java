package CourseHandler;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String headTeacher;
    private List<String> atendants = new ArrayList<>();
    private String description;

    public Course(String name, String headTeacher, String description) {
        this.name = name;
        this.headTeacher = headTeacher;
        this.description = description;
    }

    public void addAtendant(String atendant) {
        atendants.add(atendant);
    }

    public void removeAtendant(String atendant) {
        atendants.remove(atendant);
    }

    public List<String> getAtendants() {
        return atendants;
    }

    public void assignHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void displayCourseInfo() {
        System.out.printf("Course name: %s%n", name);
        System.out.printf("Head teacher: %s%n", headTeacher);
        System.out.printf("Description: %s%n", description);
    }
}
