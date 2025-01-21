package school.token.hackaton_groupe7.application.features.categorieUser.queries.getById;

import lombok.Data;

@Data
public class CategorieUserGetByIdOutput {
        private int id;
        private int idUser;
        private String name;
        private double budget;

}
