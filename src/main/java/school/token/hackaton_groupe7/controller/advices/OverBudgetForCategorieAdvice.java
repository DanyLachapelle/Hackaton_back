package school.token.hackaton_groupe7.controller.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import school.token.hackaton_groupe7.application.exceptions.OverBudgetForCategorieException;

@RestControllerAdvice
public class OverBudgetForCategorieAdvice {
    @ExceptionHandler(OverBudgetForCategorieException.class)
    public ResponseStatusException handle(OverBudgetForCategorieException exception) {
        return new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
    }
}