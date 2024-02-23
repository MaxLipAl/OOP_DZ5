// StudyGroup.java
package model;

import java.util.List;

public class StudyGroup {
    private final Teacher teacher;
    private final List<Student> students;

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }


    public void printTeacher() {
        System.out.println(teacher);//("Преподаватель: " + teacher);
    }

    public void printStudentsBySubject() {
        System.out.println("Студенты по предметам:");
        for (Student student : students) {
            System.out.println(student.getName() + " изучает " + student.getSubjects());
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public List<Student> getStudents() {
        return students;
    }
}
