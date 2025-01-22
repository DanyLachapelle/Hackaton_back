package school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser;

import lombok.Data;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;

import java.util.ArrayList;
import java.util.List;

public class CategorieUserGetByUserOutput {
    public List<CategorieUser> categorieUsers = new ArrayList<>();

    @Data
    public static class CategorieUser  {
        private int id;
        private int idUser;
        private String name;
        private double budget;
        private String color;
    }
}
