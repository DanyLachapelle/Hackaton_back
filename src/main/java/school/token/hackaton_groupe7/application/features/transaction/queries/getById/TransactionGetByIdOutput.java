package school.token.hackaton_groupe7.application.features.transaction.queries.getById;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

import java.util.Date;

@Data
public class TransactionGetByIdOutput {

    public int id;
    public int idCategory;
    public String nameCategory;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date date;
    public int amount;
    public String object;

}
