package factory;

import portal.Course;

public interface CourseFactory {
   Course createCourse(String courseName);
}
