package school.token.hackaton_groupe7.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private double totbalance;
    private double totbudget;
    private String password;
    private String mail;
}



