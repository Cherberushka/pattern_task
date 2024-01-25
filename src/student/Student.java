package student;

import observers.Observer;
import portal.Course;
import portal.Material;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observer{
    private String studentName;
    private List<Course> enrolledCourses;

    public Student(String studentName) {
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentName() {
        return this.studentName;
    }

    public List<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.registerObserver(this);
    }

    public void dropCourse(Course course) {
        enrolledCourses.remove(course);
        course.removeObserver(this);
    }

    @Override
    public void updateProgress(Student student, Course course) {
        if (enrolledCourses.contains(course)) {
            System.out.println("Student " + student.getStudentName() + " has made progress in course: " + course.getCourseName());
        }
        else {
            System.out.println("Student " + student.getStudentName() + " don't enrolled course: " + course.getCourseName());
        }
    }


    public void notifyNewMaterial(Material material) {
        System.out.println("Student " + studentName + " has received new material of type: " + material.getType());
    }
}
