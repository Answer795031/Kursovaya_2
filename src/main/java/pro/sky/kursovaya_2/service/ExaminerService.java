package pro.sky.kursovaya_2.service;

import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.exception.QuestionValidateException;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount) throws QuestionValidateException;
}
