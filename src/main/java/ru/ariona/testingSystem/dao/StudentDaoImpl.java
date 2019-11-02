package ru.ariona.testingSystem.dao;

import ru.ariona.testingSystem.domain.Student;

import java.util.*;

public class StudentDaoImpl implements StudentDao {

    private Set<Student> students;

    public StudentDaoImpl() {
        students = new HashSet<Student>(){{
            add(new Student("Vasya"));
            add(new Student("Petya"));
            add(new Student("Vanya"));
            add(new Student("Sasha"));
        }};
    }

    public Student createStudent(String name) {
        Student student = getByName(name);
        students.add(student);
        return student;
    }

    public Student getByName(final String name) {
        Optional<Student> student = students.stream().filter(s -> s.getName().equals(name)).findFirst();

        return student.isPresent() ? student.get() : new Student(name);
    }
}
