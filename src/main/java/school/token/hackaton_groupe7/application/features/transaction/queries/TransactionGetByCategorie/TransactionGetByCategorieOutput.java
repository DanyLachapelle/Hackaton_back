package school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionGetByCategorieOutput {

    public List<Transaction> transactions = new ArrayList<>();

    public static class Transaction {
        public int id;
        public int idCategory;
        public String nameCategory;
        public Date date;
        public int amount;
        public String object;
    }
}
