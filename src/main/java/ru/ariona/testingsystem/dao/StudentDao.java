package ru.ariona.testingsystem.dao;

import ru.ariona.testingsystem.domain.Student;

public interface StudentDao {

    Student getByName(String name);
}
