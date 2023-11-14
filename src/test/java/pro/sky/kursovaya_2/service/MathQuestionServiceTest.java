package pro.sky.kursovaya_2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.repository.JavaQuestionRepository;
import pro.sky.kursovaya_2.repository.MathQuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    private MathQuestionService mathQuestionService;

    @Test
    void add() {

        // данные для добавления
        String question = "test_question";
        String answer = "test_answer";

        // ожидаемый результат
        Question expectedQuestion = new Question(question, answer);
        when(mathQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);

        // фактический результат
        Question actualQuestion = mathQuestionService.add(question, answer);

        // сравнение результатов
        assertEquals(expectedQuestion, actualQuestion);
        verify(mathQuestionRepository).add(expectedQuestion);
    }

    @Test
    void remove() {

        // данные для добавления
        String question = "test_question";
        String answer = "test_answer";

        // ожидаемый результат
        Question expectedQuestion = new Question(question, answer);
        when(mathQuestionRepository.remove(eq(expectedQuestion))).thenReturn(expectedQuestion);

        // фактический результат
        Question actualQuestion = mathQuestionService.remove(question, answer);

        // сравнение результатов
        assertEquals(expectedQuestion, actualQuestion);
        verify(mathQuestionRepository).remove(expectedQuestion);
    }

    @Test
    void getAll() {

        // ожидаемый результат
        Collection<Question> expectedQuestions = mathQuestionRepository.getAll();

        // фактический результат
        Collection<Question> actualQuestions = mathQuestionService.getAll();

        // сравнение результатов
        assertEquals(expectedQuestions.toString(), actualQuestions.toString());
    }
}