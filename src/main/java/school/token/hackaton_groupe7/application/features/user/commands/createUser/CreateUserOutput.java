package school.token.hackaton_groupe7.application.features.user.commands.createUser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class CreateUserOutput {
    private int id;
    private String username;
    private String password;
    private String mail;
}
