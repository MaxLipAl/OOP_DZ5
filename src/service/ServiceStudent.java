// ServiceStudent.java
package service;

import model.Student;
import model.User;

import java.util.List;

public interface ServiceStudent {
    Student create(User user);
    List<Student> read();
}