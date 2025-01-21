package school.token.hackaton_groupe7.application.shared.cqrscore.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
