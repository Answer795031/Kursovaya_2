package pro.sky.kursovaya_2.service;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;
import pro.sky.kursovaya_2.repository.MathQuestionRepositoryImpl;

import java.util.*;

@Service
public class MathQuestionServiceImpl implements MathQuestionService {

    MathQuestionRepositoryImpl mathRepository;

    public MathQuestionServiceImpl(MathQuestionRepositoryImpl mathRepository) {
        this.mathRepository = mathRepository;
    }

    // метод для добавления вопроса
    public Question add(String question, String answer) {
        return mathRepository.add(question, answer);
    }

    public Question add(Question question) {
        return mathRepository.add(question);
    }

    // метод для удаления вопроса
    public Question remove(Question question) {
        return mathRepository.remove(question);
    }

    // метод для получения всех вопросов
    public Collection<Question> getAll() {
        return mathRepository.getAll();
    }

    // метод для выбора случайного вопроса из коллекции
    public Question getRandomQuestion(int amount) throws QuestionValidateException {
        return mathRepository.getRandomQuestion(amount);
    }
}
