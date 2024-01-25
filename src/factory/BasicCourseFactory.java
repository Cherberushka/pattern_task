package factory;

import portal.Course;

public class BasicCourseFactory implements CourseFactory{
    @Override
    public Course createCourse(String courseName) {
        return new Course(courseName);
    }
}
