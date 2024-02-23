// ServiceTeacher.java
// ServiceTeacher.java
package service;

import model.Teacher;
import model.User;

import java.util.List;

public interface ServiceTeacher {
    Teacher create(User user);
    List<Teacher> read();
}
