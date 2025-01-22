package school.token.hackaton_groupe7.application.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Class entityClass, Integer id) {
        super("Entity " + entityClass.getSimpleName() + " with id " + id + " not found");
    }
}
