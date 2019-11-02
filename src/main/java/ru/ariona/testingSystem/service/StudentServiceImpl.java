package ru.ariona.testingSystem.service;

import ru.ariona.testingSystem.dao.StudentDao;
import ru.ariona.testingSystem.domain.Student;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student getByName(String name) {
        if (name == null || name.isEmpty()) {
            name = "Авто имя";
        }
        return dao.getByName(name);
    }


}
