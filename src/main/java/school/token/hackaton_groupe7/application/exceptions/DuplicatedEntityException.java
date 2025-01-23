package school.token.hackaton_groupe7.application.exceptions;

public class DuplicatedEntityException extends RuntimeException {
    public DuplicatedEntityException(Class entityClass, int id, String name) {
        super("L'entité de type : " + entityClass.getName() + " existe déjà avec : " + name + " : " + id);
    }
}
