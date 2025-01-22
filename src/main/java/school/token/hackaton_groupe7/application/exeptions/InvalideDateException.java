package school.token.hackaton_groupe7.application.exeptions;

import java.util.Date;

public class InvalideDateException extends RuntimeException {
    public InvalideDateException(Date startDate, Date endDate) {
        super("La date de début : " + startDate + " est plus récente que la date de fin : " + endDate);
    }
}
