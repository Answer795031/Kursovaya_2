package pro.sky.kursovaya_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class QuestionValidateException extends HttpStatusCodeException {
    public QuestionValidateException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }
}
