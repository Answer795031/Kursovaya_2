package pro.sky.kursovaya_2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.*;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Collection<Question> questions = new HashSet<>();

    // заполнение коллекции вопросами
    public MathQuestionRepository() {

        add(new Question("2 + 2", "4"));
        add(new Question("3 + 10", "13"));
        add(new Question("0 - 7", "-7"));
        add(new Question("9 * 8", "72"));
        add(new Question("5 / 2", "2.5"));
        add(new Question("7 + 2 - 4", "5"));
        add(new Question("2 * 3 * 5", "30"));
        add(new Question("101 * 0", "0"));
        add(new Question("58 / 10 + 24.5", "30.3"));
        add(new Question("1 + 1", "Хороший фильм"));

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
