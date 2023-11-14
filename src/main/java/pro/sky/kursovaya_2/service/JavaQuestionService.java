package pro.sky.kursovaya_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;
import pro.sky.kursovaya_2.repository.QuestionRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // метод для добавления вопроса
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question newQuestion) {
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    // метод для удаления вопроса
    @Override
    public Question remove(String question, String answer) {
        Question removedQuestion = new Question(question, answer);
        questionRepository.remove(removedQuestion);
        return removedQuestion;
    }

    // метод для получения всех вопросов
    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    // метод для выбора случайного вопроса из коллекции
    @Override
    public Question getRandomQuestion(int amount) throws QuestionValidateException {
        return questionRepository.getRandomQuestion(amount);
    }
}
