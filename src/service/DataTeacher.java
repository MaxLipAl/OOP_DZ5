// DataStudent.java
package service;

//import model.Student;
import model.Teacher;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataTeacher implements ServiceTeacher {

    private final List<Teacher> listTeacher = new ArrayList<>();

    @Override
    public Teacher create(User user) {
        Teacher teacher = (Teacher) user;
        listTeacher.add(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> read() {
        return listTeacher;
    }
}