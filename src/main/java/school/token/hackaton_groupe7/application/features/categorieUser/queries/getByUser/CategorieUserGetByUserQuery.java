package school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser;

import org.springframework.data.domain.Pageable;

public class CategorieUserGetByUserQuery {
    public int user_id;
    public Pageable pageable;

    public CategorieUserGetByUserQuery(int user_id, Pageable pageable) {
        this.user_id = user_id;
        this.pageable = pageable;
    }
}
