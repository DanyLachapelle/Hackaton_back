package school.token.hackaton_groupe7.application.core.categorieUser.queries.getAll;

import school.token.hackaton_groupe7.application.shared.cqrscore.outputs.EntityGetAllOutput;
import school.token.hackaton_groupe7.application.shared.cqrscore.outputs.EntityOutput;

public class CategorieUserGetAllOutput extends EntityGetAllOutput<CategorieUserGetAllOutput.CategorieUser> {

    public static class CategorieUser extends EntityOutput {
        private int idUser;
        private String name;
        private double budget;
    }
}
