package ru.ariona.testingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ariona.testingsystem.dao.StudentDao;
import ru.ariona.testingsystem.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student getByName(String name) {
        if (name == null || name.isEmpty()) {
            name = "Автобот";
        }
        return dao.getByName(name);
    }
}
