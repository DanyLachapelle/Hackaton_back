package school.token.hackaton_groupe7.application.features.dateUser.commands.update;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DateUserUpdateCommand {
    @JsonIgnore
    public int id;
    public int month ;
    public int year  ;
    public int idUser  ;
    public int budget ;
}
