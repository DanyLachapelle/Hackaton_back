package school.token.hackaton_groupe7.api.advices;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;

@RestControllerAdvice
public class EntityNotFoundAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseStatusException handle(EntityNotFoundException exception) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
