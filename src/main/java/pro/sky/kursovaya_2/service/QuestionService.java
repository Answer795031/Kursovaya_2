package pro.sky.kursovaya_2.service;

import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion(int amount) throws QuestionValidateException;
}
