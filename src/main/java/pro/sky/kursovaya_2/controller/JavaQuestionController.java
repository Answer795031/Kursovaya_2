package pro.sky.kursovaya_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovaya_2.service.QuestionService;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;


    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }



}
