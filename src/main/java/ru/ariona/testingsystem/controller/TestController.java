package ru.ariona.testingsystem.controller;

import ru.ariona.testingsystem.domain.Student;
import ru.ariona.testingsystem.service.QuestionService;
import ru.ariona.testingsystem.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestController {
    private StudentService studentService;
    private QuestionService questionService;

    public TestController(StudentService studentService, QuestionService questionService) {
        this.studentService = studentService;
        this.questionService = questionService;
    }

    public void startTest() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя: ");
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

        System.out.println(student.getName() + ", вы набрали " + student.getPoint() + " очков");
    }
}
