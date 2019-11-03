package ru.ariona.testingsystem.dao;

import ru.ariona.testingsystem.domain.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class QuestionDaoImpl implements QuestionDao {
    private List<Question> questions;

    public QuestionDaoImpl()  {
        questions = new LinkedList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/questions.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("Файл с вопросами не найден");

        }
        String string;
        try {
            while ((string = reader.readLine()) != null) {
                questions.add(new Question(string));
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
    }

    @Override
    public Question getNext() {
        return ((LinkedList<Question>) questions).poll();
    }

    @Override
    public boolean hasNext() {
        return !questions.isEmpty();
    }
}
