package school.token.hackaton_groupe7.application.features.transaction.queries.getAll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionGetAllOutput {

    public List<Transaction> transactions = new ArrayList<>();

    public static class Transaction {

        private int id;
        private int idCat;
        private Date date;
        private int amount;
        private String object;
    }
}
