package ru.ariona.testingSystem.dao;

import ru.ariona.testingSystem.domain.Student;

public class StudentDaoImpl implements StudentDao {

    public Student getByName(final String name) {
        return new Student(name);
    }
}
