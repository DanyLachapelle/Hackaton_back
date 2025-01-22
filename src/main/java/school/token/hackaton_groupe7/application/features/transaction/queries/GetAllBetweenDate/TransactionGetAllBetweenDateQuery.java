package school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate;

import org.springframework.data.domain.Pageable;

import java.util.Date;

public class TransactionGetAllBetweenDateQuery {

    Pageable pageable;
    Date from;
    Date to;

    public TransactionGetAllBetweenDateQuery(Pageable pageable, Date from, Date to) {
        this.pageable = pageable;
        this.from = from;
        this.to = to;
    }
}
