package school.token.hackaton_groupe7.application.features.transaction.queries.getAll;

import lombok.Data;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionGetAllOutput {

    public List<Transaction> transactions = new ArrayList<>();

    @Data
    public static class Transaction {

        public int id;
        public int user_id;
        public DbCategorieUser category;
        public int category_id;
        public Date date;
        public int amount;
        public String object;
    }
}
