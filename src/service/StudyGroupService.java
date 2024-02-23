package service;

import model.StudyGroup;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudyGroupService {
    private final List<StudyGroup> studyGroups;

    public StudyGroupService() {
        studyGroups = new ArrayList<>();
    }

    public void addStudyGroup(StudyGroup studyGroup) {
        studyGroups.add(studyGroup);
    }

    public List<Student> getStudentsBySubjectAndTeacher(String subject, Teacher teacher) {
        return studyGroups.stream()
                .filter(group -> group.getTeacher().equals(teacher)) // Фильтруем группы по преподавателю
                .filter(group -> group.getTeacher().getSubject().equalsIgnoreCase(subject)) // Фильтруем группы по предмету
                .flatMap(group -> group.getStudents().stream()) // Получаем список студентов из отфильтрованных групп
                .distinct() // Удаляем дублирующиеся студенты
                .collect(Collectors.toList());
    }
}
