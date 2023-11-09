package pro.sky.kursovaya_2.service;

import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.Collection;

public interface JavaQuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion(int amount) throws QuestionValidateException;
}
