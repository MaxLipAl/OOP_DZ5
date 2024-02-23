package controler;

import model.Student;
import model.StudyGroup;
import model.Teacher;
import service.DataStudent;
import service.DataTeacher;
import view.StudentView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Controler {
    private final DataStudent dataStudent;
    private final DataTeacher dataTeacher;
    private final StudentView studentView;
    private final service.StudyGroupService studyGroupService;
    private final Scanner scanner;

    public Controler() {
        dataStudent = new DataStudent();
        dataTeacher = new DataTeacher();
        studentView = new StudentView();
        studyGroupService = new service.StudyGroupService();
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Создание студентов
        List<String> subjectsIvanov = Arrays.asList("физика", "математика", "русский язык");
        Student ivanov = new Student(23, "Иванов", 4.6, subjectsIvanov);

        List<String> subjectsPetrov = Arrays.asList("химия", "биология", "английский язык");
        Student petrov = new Student(22, "Петров", 4.4, subjectsPetrov);

        List<String> subjectsSmith = Arrays.asList("физика", "математика", "английский язык");
        Student sidorov = new Student(25, "Сидоров", 4.3, subjectsSmith);

        List<String> subjectsJohnson = Arrays.asList("физика", "английский язык", "биология");
        Student blinov = new Student(24, "Блинов", 4.2, subjectsJohnson);

        List<String> subjectsWilliams = Arrays.asList("физика", "математика", "английский язык");
        Student smirnov = new Student(21, "Смирнов", 4.1, subjectsWilliams);

        List<String> subjectsBrown = Arrays.asList("физика", "английский язык", "русский язык");
        Student maximov = new Student(20, "Максимов", 4.0, subjectsBrown);

        List<String> subjectsJones = Arrays.asList("физика", "английский язык", "математика");
        Student gagarin = new Student(22, "Гагарин", 4.5, subjectsJones);

        List<String> subjectsGarcia = Arrays.asList("физика", "английский язык", "математика");
        Student kurchatov = new Student(23, "Курчатов", 4.4, subjectsGarcia);

        List<String> subjectsMartinez = Arrays.asList("физика", "математика", "русский язык");
        Student solovev = new Student(24, "Соловьев", 4.3, subjectsMartinez);

        List<String> subjectsRodriguez = Arrays.asList("физика", "английский язык", "математика");
        Student rodionov = new Student(25, "Родионов", 4.2, subjectsRodriguez);

        // Добавление студентов в список
        dataStudent.create(ivanov);
        dataStudent.create(petrov);
        dataStudent.create(sidorov);
        dataStudent.create(blinov);
        dataStudent.create(smirnov);
        dataStudent.create(maximov);
        dataStudent.create(gagarin);
        dataStudent.create(kurchatov);
        dataStudent.create(solovev);
        dataStudent.create(rodionov);

        // Создание преподавателей
        Teacher physicsTeacher = new Teacher(35, "Петров", "физика");
        Teacher chemistryTeacher = new Teacher(40, "Сидоров", "химия");

        // Добавление преподавателей в список
        dataTeacher.create(physicsTeacher);
        dataTeacher.create(chemistryTeacher);

        // Создание учебных групп
        List<Student> physicsStudents = new ArrayList<>();
        physicsStudents.add(ivanov);
        physicsStudents.add(sidorov);
        physicsStudents.add(blinov);
        physicsStudents.add(smirnov);
        physicsStudents.add(maximov);
        physicsStudents.add(gagarin);
        physicsStudents.add(kurchatov);
        physicsStudents.add(solovev);
        physicsStudents.add(rodionov);
             
        List<Student> chemistryStudents = new ArrayList<>();
        chemistryStudents.add(petrov);

        // Создание учебных групп для различных предметов
        StudyGroup physicsGroup = new StudyGroup(physicsTeacher, physicsStudents);
        StudyGroup chemistryGroup = new StudyGroup(chemistryTeacher, chemistryStudents);

        // Добавление учебных групп в StudyGroupService
        studyGroupService.addStudyGroup(physicsGroup);
        studyGroupService.addStudyGroup(chemistryGroup);

        // Основной цикл программы
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Вывести список студентов");
            System.out.println("2. Вывести список преподавателей");
            System.out.println("3. Вывести учебные группы по предметам");
            System.out.println("4. Выйти");
            System.out.print("Введите ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера после считывания числа

            switch (choice) {
                case 1:
                    printStudents();
                    break;
                case 2:
                    printTeachers();
                    break;
                case 3:
                    printStudyGroupsBySubject();
                    break;
                case 4:
                    System.out.println("Завершение работы программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        } while (choice != 4);
    }

    private void printStudents() {
        // Вывод списка студентов
        List<Student> students = dataStudent.read();
        studentView.printStudent(students);
    }

    private void printTeachers() {
        // Вывод списка преподавателей
        List<Teacher> teachers = dataTeacher.read();
        teachers.forEach((Consumer<? super Teacher>) teachers);
    }

    private void printStudyGroupsBySubject() {
        // Получаем список всех преподавателей
        List<Teacher> teachers = dataTeacher.read();

        // Перебираем каждого преподавателя
        for (Teacher teacher : teachers) {
            // Получаем предмет, который преподает текущий преподаватель
            String subject = teacher.getSubject();

            // Выводим заголовок для текущего предмета
            System.out.println("Учебная группа для предмета: " + subject);

            // Получаем список всех студентов, изучающих данный предмет у данного преподавателя
            List<Student> students = studyGroupService.getStudentsBySubjectAndTeacher(subject, teacher);

            // Выводим информацию о преподавателе
            System.out.println("Преподаватель: " + teacher.getName() + ", предмет: " + subject);

            // Выводим информацию о студентах через StudentView
            studentView.printStudent(students);

            // Пустая строка для разделения учебных групп
            System.out.println();
        }
    }
}
