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
        public int idUser;
        public int idCategory;
        public String nameCategory;
        public Date date;
        public int amount;
        public String object;
    }
}
