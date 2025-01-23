package school.token.hackaton_groupe7.application.features.dateUser.queries.getBudgetByUserAndMonthAndYear;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserGetBudgetByUserAndMonthAndYearHandler implements IQueryHandler<DateUserGetBudgetByUserAndMonthAndYearQuery, Double> {
    private final IDateUserRepository dateUserRepository;
    private final ModelMapper modelMapper;

    public DateUserGetBudgetByUserAndMonthAndYearHandler(IDateUserRepository dateUserRepository, ModelMapper modelMapper) {
        this.dateUserRepository = dateUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Double handle(DateUserGetBudgetByUserAndMonthAndYearQuery input) {
        var dbDateUser = dateUserRepository.findByUser_IdAndMonthAndYear(input.user_id, input.month, input.year);

        if (dbDateUser == null)
        {
            throw new EntityNotFoundException(DbDateUser.class, input.user_id);
        }

        double output = dbDateUser.budget;

        return output;
    }
}
