package school.token.hackaton_groupe7.application.features.user.queries.getAllUsers;

import lombok.Data;
import school.token.hackaton_groupe7.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserGetAllOutput {
    public List<User> users=new ArrayList<>();
    @Data
    public static class User{
        private int id;
        private String username;
        private double totbalance;
        private double totbudget;
        private String password;
        private String mail;
    }
}
