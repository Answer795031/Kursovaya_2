package pro.sky.kursovaya_2.service;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya_2.entity.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    public Question add(String question, String answer) {

        Question newQuestion = new Question(question, answer);

        questions.add(newQuestion);

        return newQuestion;
    }

    public Question add(Question question) {

        questions.add(question);

        return question;
    }

    public Question remove(Question question) {

        questions.remove(question);

        return question;
    }

    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    public Question getRandomQuestion() {

        List<Question> questionsList = new ArrayList<>(questions);

        Random random = new Random();

        int maxCount = questions.size();
        int count = random.nextInt(maxCount);

        return questionsList.get(count);
    }
}
