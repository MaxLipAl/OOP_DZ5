// DataStudent.java
package service;

import model.Student;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataStudent implements ServiceStudent {

    private final List<Student> listStudent = new ArrayList<>();

    @Override
    public Student create(User user) {
        Student student = (Student) user;
        listStudent.add(student);
        return student;
    }

    @Override
    public List<Student> read() {
        return listStudent;
    }
}

