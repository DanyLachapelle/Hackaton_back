package school.token.hackaton_groupe7.application.features.dateUser.queries.getByUserMonthYear;

public class DateUserGetByUserMonthYearQuery {
    public int idUser;
    public int month;
    public int year;

    public DateUserGetByUserMonthYearQuery(int idUser, int month, int year) {
        this.idUser = idUser;
        this.month = month;
        this.year = year;
    }
}
