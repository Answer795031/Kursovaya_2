package pro.sky.kursovaya_2.service;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    // метод для получения случайных вопросов в количестве равном {amount}
    public Collection<Question> getQuestions(int amount) {

        Set<Question> questions = new HashSet<>(amount);

        while (questions.size() < amount) {
            Question question = javaQuestionService.getRandomQuestion(amount);
            if (questions.contains(question)) {
                continue;
            }
            questions.add(question);
        }
        return questions;
    }
}
