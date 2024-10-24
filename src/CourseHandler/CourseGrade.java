package CourseHandler;

public class CourseGrade {
    private Integer courseID;
    private double grade;

    CourseGrade(Integer courseID, double grade) {
        this.courseID = courseID;
        this.grade = grade;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public Double getGrade() {
        return grade;
    }
}
