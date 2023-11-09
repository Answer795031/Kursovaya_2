package pro.sky.kursovaya_2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @ExceptionHandler
    public String handleException(RuntimeException e){
        return e.getMessage();
    }

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping(path = "/get/{amount}") // метод для получения случайных вопросов в количестве равном {amount}
    public Collection<Question> getQuestions (@PathVariable int amount) {
        return service.getQuestions(amount);
    }
}
