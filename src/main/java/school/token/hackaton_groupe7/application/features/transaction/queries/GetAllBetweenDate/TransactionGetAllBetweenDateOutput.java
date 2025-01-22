package school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate;

import lombok.Data;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieOutput;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionGetAllBetweenDateOutput {
    public List<Transaction> transactions = new ArrayList<>();

    @Data
    public static class Transaction {
        public int id;
        public int idCategory;
        public Date date;
        public int amount;
        public String object;
    }
}
