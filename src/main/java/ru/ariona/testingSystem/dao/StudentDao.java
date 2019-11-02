package ru.ariona.testingSystem.dao;

import ru.ariona.testingSystem.domain.Student;

public interface StudentDao {

    Student getByName(String name);
}
