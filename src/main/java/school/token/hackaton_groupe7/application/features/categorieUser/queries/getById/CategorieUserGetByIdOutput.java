package school.token.hackaton_groupe7.application.features.categorieUser.queries.getById;

import lombok.Data;

@Data
public class CategorieUserGetByIdOutput {
        public int id;
        public int idUser;
        public String name;
        public double budget;
        public String color;

}
