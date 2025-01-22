package school.token.hackaton_groupe7.application.features.categorieUser.commands.update;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategorieUserUpdateCommand {
    @JsonIgnore
    public int id;
    public double budget;
    public String name;
    public String color;
}
