package school.token.hackaton_groupe7.controller.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import school.token.hackaton_groupe7.application.exceptions.DuplicatedEntityException;

@RestControllerAdvice
public class DuplicatedEntityAdvice {
    @ExceptionHandler(DuplicatedEntityException.class)
    public ResponseStatusException handle(DuplicatedEntityException e) {
        return new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
    }
}
