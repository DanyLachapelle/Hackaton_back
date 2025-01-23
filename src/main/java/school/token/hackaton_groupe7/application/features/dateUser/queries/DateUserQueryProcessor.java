package school.token.hackaton_groupe7.application.features.dateUser.queries;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.dateUser.queries.GetbyIdUser.DateUserGetByIdUserOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getAll.DateUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getBudgetByUserAndMonthAndYear.DateUserGetBudgetByUserAndMonthAndYearHandler;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getBudgetByUserAndMonthAndYear.DateUserGetBudgetByUserAndMonthAndYearQuery;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getById.DateUserGetByIdOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getByUserMonthYear.DateUserGetByUserMonthYearHandler;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getByUserMonthYear.DateUserGetByUserMonthYearQuery;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

@Service
public class DateUserQueryProcessor {
    private final IQueryHandler<Pageable, DateUserGetAllOutput> getAllHandler;
    private final IQueryHandler<Integer, DateUserGetByIdOutput> getByIdHandler;
    private final IQueryHandler<Integer, DateUserGetByIdUserOutput> getByIdUserHandler;
    private final IQueryHandler<DateUserGetBudgetByUserAndMonthAndYearQuery, Double> getBudgetByUserAndMonthAndYearhandler;
    private final IQueryHandler<DateUserGetByUserMonthYearQuery, Integer> getByUserMonthYearhandler;

    public DateUserQueryProcessor(IQueryHandler<Pageable, DateUserGetAllOutput> getAllHandler, IQueryHandler<Integer, DateUserGetByIdOutput> getByIdHandler, IQueryHandler<Integer, DateUserGetByIdUserOutput> getByIdUserHandler, DateUserGetBudgetByUserAndMonthAndYearHandler getBudgetByUserAndMonthAndYearQuery, DateUserGetByUserMonthYearHandler getByUserMonthYearhandler) {
        this.getAllHandler = getAllHandler;
        this.getByIdHandler = getByIdHandler;
        this.getByIdUserHandler = getByIdUserHandler;
        this.getBudgetByUserAndMonthAndYearhandler = getBudgetByUserAndMonthAndYearQuery;
        this.getByUserMonthYearhandler = getByUserMonthYearhandler;
    }

    public DateUserGetAllOutput getAll(Pageable pageable) {
        return getAllHandler.handle(pageable);
    }


    public DateUserGetByIdOutput getById(Integer id) {
        return getByIdHandler.handle(id);
    }

    public DateUserGetByIdUserOutput getByIdUser(Integer id_user) {
        return getByIdUserHandler.handle(id_user);
    }

    public Double getBudgetByUserAndMonthAndYear(DateUserGetBudgetByUserAndMonthAndYearQuery query) {
        return getBudgetByUserAndMonthAndYearhandler.handle(query);
    }

    public Integer getByUserMonthYear(DateUserGetByUserMonthYearQuery query) {
        return getByUserMonthYearhandler.handle(query);
    }
}