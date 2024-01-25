package portal;

import observers.Observer;
import student.Student;

import java.util.List;
import java.util.ArrayList;


public class Course{
    private String courseName;
    private List<Material> materials;
    private List<Observer> observers;

    public Course(String courseName) {
        this.courseName = courseName;
        this.materials = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addMaterial(Material material) {
        materials.add(material);
        notifyNewMaterial(material);
    }

    public String getCourseName() { return this.courseName; }
    public List<Material> getMaterials() { return this.materials; }


    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) { observers.remove(observer); }

    public void notifyProgress(Student student) {
        student.updateProgress(student,this);
    }

    private void notifyNewMaterial(Material material) {
        for (Observer observer : observers) {
            observer.notifyNewMaterial(material);
        }
    }
}
