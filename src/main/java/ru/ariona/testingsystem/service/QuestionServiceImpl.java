package ru.ariona.testingsystem.service;

import ru.ariona.testingsystem.dao.QuestionDao;
import ru.ariona.testingsystem.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean ask() {
        Question question = dao.getNext();
        question.print();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода");
        }

        return answer != null && answer.toLowerCase().equals(question.getAns());
    }

    @Override
    public boolean hasNext() {
        return dao.hasNext();
    }
}
