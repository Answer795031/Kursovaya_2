package pro.sky.kursovaya_2.service;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;
import pro.sky.kursovaya_2.repository.JavaQuestionRepositoryImpl;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {

    JavaQuestionRepositoryImpl javaRepository;

    public JavaQuestionServiceImpl(JavaQuestionRepositoryImpl javaRepository) {
        this.javaRepository = javaRepository;
    }

    // метод для добавления вопроса
    public Question add(String question, String answer) {
        return javaRepository.add(question, answer);
    }

    public Question add(Question question) {
        return javaRepository.add(question);
    }

    // метод для удаления вопроса
    public Question remove(Question question) {
        return javaRepository.remove(question);
    }

    // метод для получения всех вопросов
    public Collection<Question> getAll() {
        return javaRepository.getAll();
    }

    // метод для выбора случайного вопроса из коллекции
    public Question getRandomQuestion(int amount) throws QuestionValidateException {
        return javaRepository.getRandomQuestion(amount);
    }
}
