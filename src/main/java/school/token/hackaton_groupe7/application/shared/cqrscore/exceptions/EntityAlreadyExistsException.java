package school.token.hackaton_groupe7.application.shared.cqrscore.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
