package ru.ariona.testingsystem.service;

import ru.ariona.testingsystem.dao.StudentDao;
import ru.ariona.testingsystem.domain.Student;

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
