package factory;

import portal.Course;

public class CourseFactory {
    public Course createCourse(String courseName) {
        return new Course(courseName);
    }
}
