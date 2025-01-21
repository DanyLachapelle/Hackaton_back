package school.token.hackaton_groupe7.application.shared.cqrscore.exceptions;

public class PaginationInvalidException extends RuntimeException {
    public PaginationInvalidException() {
        super("Requested pagination is invalid");
    }
}
