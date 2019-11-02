package ru.ariona.testingSystem.service;

import ru.ariona.testingSystem.dao.QuestionDao;
import ru.ariona.testingSystem.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuesionServiceImpl implements QuestionService {
    private QuestionDao dao;

    public QuesionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean ask() {
        Question question = dao.getNext();
        question.print();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = null;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }

        return answer != null && answer.toLowerCase().equals(question.getAns());

    }




}
