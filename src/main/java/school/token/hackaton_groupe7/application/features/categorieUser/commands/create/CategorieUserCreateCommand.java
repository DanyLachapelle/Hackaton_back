package school.token.hackaton_groupe7.application.features.categorieUser.commands.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

@Schema
@ToString
public class CategorieUserCreateCommand {
    private int idUser;
    private String name;
    private double budget;
}
