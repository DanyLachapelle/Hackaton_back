package school.token.hackaton_groupe7.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStats {

    private String name;
    private double totalTransactions;

}
