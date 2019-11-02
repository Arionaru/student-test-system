package ru.ariona.testingSystem.service;

import ru.ariona.testingSystem.domain.Student;

public interface StudentService {
    Student getByName(String name);

}
