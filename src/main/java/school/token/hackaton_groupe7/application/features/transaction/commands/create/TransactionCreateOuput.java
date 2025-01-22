package school.token.hackaton_groupe7.application.features.transaction.commands.create;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionCreateOuput {
    public int id;
    public int user_id;
    public int category_id;
    public Date date;
    public int amount;
    public String object;
}
