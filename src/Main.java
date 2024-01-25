import portal.Course;
import portal.Material;
import student.Student;

public class Main {
    public static void main(String[] args) {
        // Создание нового курса
        Course javaCourse = new Course("Java Programming");

        // Создание и добавление студентов в качестве наблюдателей
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        student1.enrollCourse(javaCourse);
        student2.enrollCourse(javaCourse);

        // Добавление нового материала вызывает уведомления для студентов
        javaCourse.addMaterial(new Material("Introduction to Java", "Добро пожаловать в мир программирования на Java"));
        // Уведомление о прогрессе студента
        javaCourse.notifyProgress(student2);

        student1.dropCourse(javaCourse);
        javaCourse.addMaterial(new Material("Introduction to Java Part II", "Погружаемся в мир программирования на Java"));
        javaCourse.notifyProgress(student1);
        javaCourse.notifyProgress(student2);
    }
}