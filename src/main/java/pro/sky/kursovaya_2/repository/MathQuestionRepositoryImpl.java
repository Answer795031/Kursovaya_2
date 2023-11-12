package pro.sky.kursovaya_2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.*;

@Repository
public class MathQuestionRepositoryImpl implements MathQuestionRepository {

    private final Set<Question> mathQuestions = new HashSet<>();

    // заполнение коллекции вопросами
    public MathQuestionRepositoryImpl() {

        add("2 + 2", "4");
        add("3 + 10", "13");
        add("0 - 7", "-7");
        add("9 * 8", "72");
        add("5 / 2", "2.5");
        add("7 + 2 - 4", "5");
        add("2 * 3 * 5", "30");
        add("101 * 0", "0");
        add("58 / 10 + 24.5", "30.3");
        add("1 + 1", "Хороший фильм");

    }

    // метод для добавления вопроса
    public Question add(String question, String answer) {

        Question newQuestion = new Question(question, answer);

        this.mathQuestions.add(newQuestion);
        return newQuestion;
    }

    public Question add(Question question) {

        this.mathQuestions.add(question);
        return question;
    }

    // метод для удаления вопроса
    public Question remove(Question question) {

        this.mathQuestions.remove(question);
        return question;
    }

    // метод для получения всех вопросов
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(mathQuestions);
    }

    // метод для выбора случайного вопроса из коллекции
    public Question getRandomQuestion(int amount) throws QuestionValidateException {

        if (mathQuestions.size() < amount) {
            throw new QuestionValidateException("Ошибка! Максимум вопросов - " + mathQuestions.size() + "!");
        }

        List<Question> questionsList = new ArrayList<>(mathQuestions); // переносим все вопросы в список для возможности поиска
        Random random = new Random();

        int count = random.nextInt(amount);

        return questionsList.get(count);
    }
}
