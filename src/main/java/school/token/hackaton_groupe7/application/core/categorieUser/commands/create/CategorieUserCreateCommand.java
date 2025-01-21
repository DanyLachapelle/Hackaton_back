package school.token.hackaton_groupe7.application.core.categorieUser.commands.create;

import school.token.hackaton_groupe7.application.shared.cqrscore.commands.EntityCommand;

public class CategorieUserCreateCommand extends EntityCommand {
    private int idUser;
    private String name;
    private double budget;
}
