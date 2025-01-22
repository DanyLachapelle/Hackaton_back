package school.token.hackaton_groupe7.application.features.transaction.queries.getById;

import lombok.Data;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

import java.util.Date;

@Data
public class TransactionGetByIdOutput {

    public int id;
    public int category_id;
    public Date date;
    public int amount;
    public String object;

}
