package pro.sky.kursovaya_2.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.repository.JavaQuestionRepository;
import pro.sky.kursovaya_2.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    /**
     * Тест для ExaminerService выполнен в виде сравнения размеров ожидаемой коллекции
     * и полученной с помощью метода getQuestions(), ввиду рандомной выдачи вопросов.
     */
    @Test
    void getQuestions() {

        int amount = 5; // количество полученных вопросов
        Collection<Question> testQuestions = new HashSet<>();

        testQuestions.add(new Question("1", "1"));
        testQuestions.add(new Question("2", "2"));
        testQuestions.add(new Question("3", "3"));
        testQuestions.add(new Question("4", "4"));
        testQuestions.add(new Question("5", "5"));

        // ожидаемый результат
        int expectedCollectionSize = testQuestions.size();

        // фактический результат
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        int actualCollectionSize = actualQuestions.size();

        // сравнение результатов
        assertEquals(expectedCollectionSize, actualCollectionSize);
    }
}