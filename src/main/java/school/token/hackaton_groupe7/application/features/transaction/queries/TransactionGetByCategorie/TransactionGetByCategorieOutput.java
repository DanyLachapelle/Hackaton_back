package school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionGetByCategorieOutput {

    public List<Transaction> transactions = new ArrayList<>();

    public static class Transaction {
        public int id;
        public int idCategory;
        public String nameCategory;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        public Date date;
        public int amount;
        public String object;
    }
}
