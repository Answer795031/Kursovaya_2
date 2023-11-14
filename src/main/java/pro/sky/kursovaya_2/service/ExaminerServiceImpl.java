package pro.sky.kursovaya_2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    // метод для получения случайных вопросов в количестве равном {amount}
    @Override
    public Collection<Question> getQuestions(int amount) throws QuestionValidateException {

        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < amount) {
            throw new QuestionValidateException("Ошибка! Превышен лимит доступных вопросов!");
        }

        Collection<Question> questions = new HashSet<>(amount);
        Random random = new Random();

        int javaRand = random.nextInt(amount);
        int mathRand = amount - javaRand;

        while (questions.size() < amount) {

            for (int i = 0; i < javaRand; i++) {
                Question question = javaQuestionService.getRandomQuestion(javaRand);
                if (questions.contains(question)) {
                    continue;
                }
                questions.add(question);
            }
            for (int i = 0; i < mathRand; i++) {
                Question question = mathQuestionService.getRandomQuestion(mathRand);
                if (questions.contains(question)) {
                    continue;
                }
                questions.add(question);
            }
        }
        return questions;
    }
}
