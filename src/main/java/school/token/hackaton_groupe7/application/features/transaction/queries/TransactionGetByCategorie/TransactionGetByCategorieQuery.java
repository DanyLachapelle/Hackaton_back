package school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie;

import org.springframework.data.domain.Pageable;

public class TransactionGetByCategorieQuery {
    public Pageable pageable;
    public int idUser;
    public int idCat;
    public int month;
    public int year;

    public TransactionGetByCategorieQuery(Pageable pageable, int idCat, int month, int year, int idUser) {
        this.pageable = pageable;
        this.idCat = idCat;
        this.month = month;
        this.year = year;
        this.idUser = idUser;
    }
}
