package ru.ariona.testingsystem.dao;

import org.springframework.stereotype.Repository;
import ru.ariona.testingsystem.domain.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

    public Student getByName(final String name) {
        return new Student(name);
    }
}
