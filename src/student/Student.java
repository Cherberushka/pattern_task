package student;

import observers.Observer;
import observers.StudentsObserver;
import portal.Course;
import portal.Material;

import java.util.ArrayList;
import java.util.List;

public class Student{
    private final String studentName;
    private final List<Course> enrolledCourses;

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
        course.registerObserver(new StudentsObserver(this));
    }

    public void dropCourse(Course course) {
        enrolledCourses.remove(course);

        // Поиск и удаление конкретного наблюдателя, связанного с этим учеником
        List<Observer> courseObservers = course.getObservers();
        for (Observer observer : courseObservers) {
            if (observer instanceof StudentsObserver studentsObserver) {
                if (studentsObserver.getStudent().equals(this)) {
                    course.removeObserver(studentsObserver);
                    break;
                }
            }
        }
    }
}
