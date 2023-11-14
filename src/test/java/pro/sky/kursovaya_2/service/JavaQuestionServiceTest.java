package pro.sky.kursovaya_2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.repository.JavaQuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    void add() {

        // данные для добавления
        String question = "test_question";
        String answer = "test_answer";

        // ожидаемый результат
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);

        // фактический результат
        Question actualQuestion = javaQuestionService.add(question, answer);

        // сравнение результатов
        assertEquals(expectedQuestion, actualQuestion);
        verify(javaQuestionRepository).add(expectedQuestion);
    }

    @Test
    void remove() {

        // данные для добавления
        String question = "test_question";
        String answer = "test_answer";

        // ожидаемый результат
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.remove(eq(expectedQuestion))).thenReturn(expectedQuestion);

        // фактический результат
        Question actualQuestion = javaQuestionService.remove(question, answer);

        // сравнение результатов
        assertEquals(expectedQuestion, actualQuestion);
        verify(javaQuestionRepository).remove(expectedQuestion);
    }

    @Test
    void getAll() {

        // ожидаемый результат
        Collection<Question> expectedQuestions = javaQuestionRepository.getAll();

        // фактический результат
        Collection<Question> actualQuestions = javaQuestionService.getAll();

        // сравнение результатов
        assertEquals(expectedQuestions.toString(), actualQuestions.toString());
    }
}