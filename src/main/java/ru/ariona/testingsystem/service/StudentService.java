package ru.ariona.testingsystem.service;

import ru.ariona.testingsystem.domain.Student;

public interface StudentService {

    Student getByName(String name);
}
