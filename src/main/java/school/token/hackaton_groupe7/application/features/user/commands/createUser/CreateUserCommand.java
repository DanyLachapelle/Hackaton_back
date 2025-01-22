package school.token.hackaton_groupe7.application.features.user.commands.createUser;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Requête pour créer un utilisateur")
@ToString
@Data
public class CreateUserCommand {

    private String username;


    private String password;

    private String mail;

    @Override
    public String toString() {
        return "CreateUserCommand{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
