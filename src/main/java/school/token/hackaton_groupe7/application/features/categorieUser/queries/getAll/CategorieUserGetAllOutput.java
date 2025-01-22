package school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CategorieUserGetAllOutput {
    public List<CategorieUser> categorieUsers = new ArrayList<>();

    @Data
    public static class CategorieUser  {
        private int id;
        private int idUser;
        private String name;
        private double budget;
    }
}
