package school.token.hackaton_groupe7.application.features.categorie.queries.getAll;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class CategorieGetAllOutput {
    public List<CategorieGetAllOutput.Categorie> categorie = new ArrayList<>();

    @Data
    public static class Categorie {
        public int id;
        public String name;
        public String color;
    }
}
