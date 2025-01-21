package school.token.hackaton_groupe7.application.features.user.commands.updateUser;

import lombok.Data;
import school.token.hackaton_groupe7.application.features.user.commands.createUser.CreateUserOutput;

@Data
public class UpdateUserCommand {
    private String username;
    private double totbalance;
    private double totbudget;
    private String password;
    private String mail;


}
