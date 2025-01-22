package school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie;

import org.springframework.data.domain.Pageable;

public class TransactionGetByCategorieQuery {
    public Pageable pageable;
    public int idCat;

    public TransactionGetByCategorieQuery(Pageable pageable, int idCat) {
        this.pageable = pageable;
        this.idCat = idCat;
    }
}
