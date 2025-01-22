package school.token.hackaton_groupe7.application.features.user.queries.getByIdUser;

import lombok.Data;

@Data
public class UserGetByIdOutput {
    private int id;
    private String username;
    private double totbalance;
    private double totbudget;
    private String password;
    private String mail;

    @Override
    public String toString() {
        return "UserGetByIdOutput{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
