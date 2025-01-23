package school.token.hackaton_groupe7.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateUser {
    private int id;
    private int month ;
    private int year  ;
    private int idUser  ;
    private double budget ;
}
