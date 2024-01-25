package observers;

import portal.Material;
import portal.Course;
import student.Student;

public class StudentsObserver implements Observer {
    private Student student;

    public StudentsObserver(Student student) {
        this.student = student;
    }

    public Student getStudent() { return this.student; }

    @Override
    public void updateProgress(Course course) {
        if (student.getEnrolledCourses().contains(course)) {
            System.out.println("Student " + student.getStudentName() + " has made progress in course: " + course.getCourseName());
        } else {
            System.out.println("Student " + student.getStudentName() + " didn't enroll in course: " + course.getCourseName());
        }
    }

    @Override
    public void notifyNewMaterial(Material material) {
        System.out.println("Student " + student.getStudentName() + " has received new material of type: " + material.getType());
    }
}
