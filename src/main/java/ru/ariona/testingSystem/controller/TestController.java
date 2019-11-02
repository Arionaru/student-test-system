package ru.ariona.testingSystem.controller;

import ru.ariona.testingSystem.domain.Student;
import ru.ariona.testingSystem.service.QuestionService;
import ru.ariona.testingSystem.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestController {
    StudentService studentService;
    QuestionService questionService;

    public TestController(StudentService studentService, QuestionService questionService) {
        this.studentService = studentService;
        this.questionService = questionService;
    }

    public void startTest() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя: ");
        Student student = null;
        try {
            student = studentService.getByName(reader.readLine());
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }

        while (true) {
            try {
                if (questionService.ask()) {
                    student.incrementPoint();
                }
            } catch (Exception e) {
                break;
            }

        }

        System.out.println(student.getName() + ", вы набрали " + student.getPoint() + " очков");


    }


}
