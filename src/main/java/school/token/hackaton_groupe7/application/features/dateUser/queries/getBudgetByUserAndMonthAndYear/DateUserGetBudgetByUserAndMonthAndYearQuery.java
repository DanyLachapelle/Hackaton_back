package school.token.hackaton_groupe7.application.features.dateUser.queries.getBudgetByUserAndMonthAndYear;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DateUserGetBudgetByUserAndMonthAndYearQuery {
    public int user_id;
    public int month;
    public int year;
}
