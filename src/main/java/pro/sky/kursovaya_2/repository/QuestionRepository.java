package pro.sky.kursovaya_2.repository;

import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.*;

public interface QuestionRepository {

    public Question add(Question question);

    // метод для удаления вопроса
    public Question remove(Question question);

    // метод для получения всех вопросов
    public Collection<Question> getAll();

    public Question getRandomQuestion(int amount) throws QuestionValidateException;
}
