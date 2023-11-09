package pro.sky.kursovaya_2.service;

import pro.sky.kursovaya_2.entity.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
