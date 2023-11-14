package pro.sky.kursovaya_2.exception;

import jdk.jfr.StackTrace;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionValidateException extends RuntimeException {
    public QuestionValidateException(String message){
        super(message);
    }
}
