package pro.sky.kursovaya_2.service;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {

    private final Set<Question> questions = new HashSet<>();

    // заполнение коллекции вопросами
    public JavaQuestionServiceImpl() {

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

    // метод для добавления вопроса
    public Question add(String question, String answer) {

        Question newQuestion = new Question(question, answer);

        this.questions.add(newQuestion);
        return newQuestion;
    }

    public Question add(Question question) {

        this.questions.add(question);
        return question;
    }

    // метод для удаления вопроса
    public Question remove(Question question) {

        this.questions.remove(question);
        return question;
    }

    // метод для получения всех вопросов
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    // метод для выбора случайного вопроса из коллекции
    public Question getRandomQuestion(int amount) throws QuestionValidateException {

        if (questions.size() < amount) {
            throw new QuestionValidateException("Ошибка! Максимум вопросов - " + questions.size() + "!");
        }

        List<Question> questionsList = new ArrayList<>(questions); // переносим все вопросы в список для возможности поиска
        Random random = new Random();

        int count = random.nextInt(amount);

        return questionsList.get(count);
    }
}
