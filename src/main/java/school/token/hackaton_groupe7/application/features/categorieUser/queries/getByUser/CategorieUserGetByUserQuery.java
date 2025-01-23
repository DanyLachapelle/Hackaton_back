package school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser;

import org.springframework.data.domain.Pageable;

public class CategorieUserGetByUserQuery {
    public int user_id;
    public Pageable pageable;
    public int month;
    public int year;

    public CategorieUserGetByUserQuery(int user_id, Pageable pageable, int month, int year) {
        this.user_id = user_id;
        this.pageable = pageable;
        this.month = month;
        this.year = year;
    }
}
