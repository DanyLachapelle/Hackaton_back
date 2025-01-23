package school.token.hackaton_groupe7.application.features.transaction.queries.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
@AllArgsConstructor
public class TransactionGetAllQuery {
    public int user_id;
    public Pageable pageable;
}
