package ru.ariona.testingsystem.dao;

import ru.ariona.testingsystem.domain.Student;

public class StudentDaoImpl implements StudentDao {

    public Student getByName(final String name) {
        return new Student(name);
    }
}
