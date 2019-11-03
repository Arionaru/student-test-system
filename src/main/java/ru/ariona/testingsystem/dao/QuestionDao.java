package ru.ariona.testingsystem.dao;


import ru.ariona.testingsystem.domain.Question;


public interface QuestionDao {
    Question getNext();

    boolean hasNext();
}
