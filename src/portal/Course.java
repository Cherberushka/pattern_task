package portal;

import observers.Observer;
import observers.StudentsObserver;
import student.Student;

import java.util.List;
import java.util.ArrayList;


public class Course{
    private final String courseName;
    private final List<Material> materials;
    private final List<Observer> observers;

    public Course(String courseName) {
        this.courseName = courseName;
        this.materials = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addMaterial(Material material) {
        materials.add(material);
        notifyMaterial(material);
    }


    public String getCourseName() { return this.courseName; }
    public List<Observer> getObservers() { return this.observers; }
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) { observers.remove(observer); }


    public void notifyProgress(Student student) {
        new StudentsObserver(student).updateProgress(this);;
    }
    private void notifyMaterial(Material material) {
        for (Observer observer : observers) {
            observer.notifyNewMaterial(material);
        }
    }
}
