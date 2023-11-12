package pro.sky.kursovaya_2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.kursovaya_2.entity.Question;
import pro.sky.kursovaya_2.service.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    @ExceptionHandler
    public String handleException(RuntimeException e){
        return e.getMessage();
    }

    private final MathQuestionService service;

    public MathQuestionController(MathQuestionService service) {
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
        return service.remove(q);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
