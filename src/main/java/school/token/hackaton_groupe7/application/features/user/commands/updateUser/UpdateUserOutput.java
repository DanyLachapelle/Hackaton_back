package school.token.hackaton_groupe7.application.features.user.commands.updateUser;

import lombok.Data;

@Data
public class UpdateUserOutput {
    private int id;
    private String username;
    private double totbalance;
    private double totbudget;
    private String password;
    private String mail;
}
