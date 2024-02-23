// Teacher.java
package model;

public class Teacher extends User {
    private static int nextTeacherId = 1;
    private Integer teacherId;
    private final String subject;

    public Teacher(Integer age, String name, String subject) {
        super(age, name);
        this.teacherId = nextTeacherId++;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Преподаватель: {" +
                "teacherId=" + teacherId +
                "Имя='" + name + '\'' +
                ", Возраст=" + age +
                ", Предмет='" + subject + '\'' +
                '}';
    }
}
