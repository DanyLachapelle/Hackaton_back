package school.token.hackaton_groupe7.application.shared.cqrscore.exceptions;

import lombok.Getter;

@Getter
public class IllegalArgumentException extends RuntimeException {

    private final String attribute;
    public IllegalArgumentException(String attribute, String message) {
        super(message);
        this.attribute = attribute;
    }

}
