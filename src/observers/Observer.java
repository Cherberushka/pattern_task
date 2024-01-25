package observers;

import portal.Course;
import portal.Material;
import student.Student;

public interface Observer {
    void updateProgress(Student student, Course course);
    void notifyNewMaterial(Material material);
}
