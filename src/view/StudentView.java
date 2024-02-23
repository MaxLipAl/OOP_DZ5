        package view;

import model.Student;

import java.util.List;

public class StudentView {
    public void printStudent(List<Student> studentList) {
        System.out.println("Все студенты: ");
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.println("Студент #" + (i + 1) + ": " + student);
        }
    }
}
