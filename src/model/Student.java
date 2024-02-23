package model;

import java.util.List;

public class Student extends User {
    private static int nextStudentId = 1;
    private Integer studentId;
    private Double average;
    private List<String> subjects;

    public Student(Integer age, String name, Double average, List<String> subjects) {
        super(age, name);
        this.studentId = nextStudentId++;
        this.average = average;
        this.subjects = subjects;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", average=" + average +
                ", subjects=" + subjects +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}