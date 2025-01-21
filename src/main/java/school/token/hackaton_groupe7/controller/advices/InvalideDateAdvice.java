package school.token.hackaton_groupe7.controller.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import school.token.hackaton_groupe7.application.exeptions.InvalideDateException;

@RestControllerAdvice
public class InvalideDateAdvice {
    @ExceptionHandler(InvalideDateException.class)
    public ResponseStatusException handle(InvalideDateException exception) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
