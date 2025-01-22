package school.token.hackaton_groupe7.application.features.dateUser.queries.getAll;

import lombok.Data;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getAll.DateUserGetAllOutput;

import java.util.ArrayList;
import java.util.List;

public class DateUserGetAllOutput {
    public List<DateUserGetAllOutput.DateUser> dateUsers = new ArrayList<>();

    @Data
    public static class DateUser  {
        public int id;
        public int month ;
        public int year  ;
        public int idUser  ;
        public int budget ;
    }
}
