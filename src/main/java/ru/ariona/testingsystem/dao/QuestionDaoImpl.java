package ru.ariona.testingsystem.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import ru.ariona.testingsystem.domain.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@PropertySource("classpath:application.properties")
@Repository
public class QuestionDaoImpl implements QuestionDao {
    private List<Question> questions;

    public QuestionDaoImpl(@Value("${question.url}") String file)  {
        questions = new LinkedList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл с вопросами не найден");
        }
        String string;
        try {
            while ((string = reader.readLine()) != null) {
                questions.add(new Question(string));
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла");
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
