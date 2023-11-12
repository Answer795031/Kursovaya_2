package pro.sky.kursovaya_2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.*;

@Repository
public class JavaQuestionRepositoryImpl implements JavaQuestionRepository {

    private final Set<Question> javaQuestions = new HashSet<>();

    public JavaQuestionRepositoryImpl() {

        add("В чем сила, брат?", "В правде, брат");
        add("Кто проживает на дне океана?", "Титаник");
        add("Красная или синяя?", "Красная");
        add("Что будешь ставить?", "Ставлю душу своей матери");
        add("Два + два?", "Двадва");
        add("Хто я?", "...");
        add("Зачем меня создали?", "Чтобы передать масло");
        add("Что такое безумие?", "Повторение одного и того же");
        add("Загадка от Жака Фреско", "Сколько?");
        add("Где Цири?", "Партейку в гвинт?");
    }

    public Question add(String question, String answer) {

        Question newQuestion = new Question(question, answer);

        this.javaQuestions.add(newQuestion);
        return newQuestion;
    }

    public Question add(Question question) {

        this.javaQuestions.add(question);
        return question;
    }

    // метод для удаления вопроса
    public Question remove(Question question) {

        this.javaQuestions.remove(question);
        return question;
    }

    // метод для получения всех вопросов
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(javaQuestions);
    }

    public Question getRandomQuestion(int amount) throws QuestionValidateException {

        if (javaQuestions.size() < amount) {
            throw new QuestionValidateException("Ошибка! Максимум вопросов - " + javaQuestions.size() + "!");
        }

        List<Question> questionsList = new ArrayList<>(javaQuestions); // переносим все вопросы в список для возможности поиска
        Random random = new Random();

        int count = random.nextInt(amount);

        return questionsList.get(count);
    }
}
