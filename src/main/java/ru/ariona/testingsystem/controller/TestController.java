package ru.ariona.testingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.ariona.testingsystem.domain.Student;
import ru.ariona.testingsystem.service.QuestionService;
import ru.ariona.testingsystem.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Service
public class TestController {

    private StudentService studentService;
    private QuestionService questionService;

    @Autowired
    private MessageSource messageSource;

    private Locale locale;

    @Autowired
    public TestController(StudentService studentService, QuestionService questionService) {
        this.studentService = studentService;
        this.questionService = questionService;
        locale = Locale.ENGLISH;
    }

    public void startTest() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(messageSource.getMessage("enter.name",null,locale));
        Student student;
        try {
            student = studentService.getByName(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода");
        }

        while (questionService.hasNext()) {
            if (questionService.ask()) {
                student.incrementPoint();
            }
        }

        System.out.printf(messageSource.getMessage
                        ("game.over", null, locale),
                        student.getName(), student.getPoint());
    }
}
