package pro.sky.kursovaya_2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    @ExceptionHandler
    public String handleException(RuntimeException e){
        return e.getMessage();
    }

    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/add", params = {"question","answer"})
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping(path = "/remove", params = {"question","answer"})
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question q = new Question(question, answer);
        return service.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
