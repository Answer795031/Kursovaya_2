package pro.sky.kursovaya_2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Collection<Question> questions = new HashSet<>();

    public JavaQuestionRepository() {

        add(new Question("В чем сила, брат?", "В правде, брат"));
        add(new Question("Кто проживает на дне океана?", "Титаник"));
        add(new Question("Красная или синяя?", "Красная"));
        add(new Question("В чем смысл жизни, вселенной и всего такого?", "42"));
        add(new Question("Два + два?", "Двадва"));
        add(new Question("Хто я?", "..."));
        add(new Question("Зачем меня создали?", "Чтобы передать масло"));
        add(new Question("Что такое безумие?", "Повторение одного и того же"));
        add(new Question("Загадка от Жака Фреско", "Сколько?"));
        add(new Question("Где Цири?", "Партейку в гвинт?"));
    }

    // метод для добавления вопроса
    @Override
    public Question add(Question newQuestion) {
        questions.add(newQuestion);
        return newQuestion;
    }

    // метод для удаления вопроса
    @Override
    public Question remove(Question removedQuestion) {
        questions.remove(removedQuestion);
        return removedQuestion;
    }

    // метод для получения всех вопросов
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    // метод для выбора случайного вопроса из коллекции
    @Override
    public Question getRandomQuestion(int amount) throws QuestionValidateException {

        if (questions.size() < amount) {
            throw new QuestionValidateException("Ошибка! Превышен лимит доступных вопросов!");
        }
        Random random = new Random();

        // переносим все вопросы в список для возможности поиска
        List<Question> questionsList = new ArrayList<>(questions);
        return questionsList.get(random.nextInt(amount));
    }
}
