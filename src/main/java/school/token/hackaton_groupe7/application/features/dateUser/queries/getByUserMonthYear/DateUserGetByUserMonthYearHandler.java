package school.token.hackaton_groupe7.application.features.dateUser.queries.getByUserMonthYear;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserGetByUserMonthYearHandler implements IQueryHandler<DateUserGetByUserMonthYearQuery, Integer> {
    private final IDateUserRepository repository;
    private final ModelMapper modelMapper;

    public DateUserGetByUserMonthYearHandler(IDateUserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Integer handle(DateUserGetByUserMonthYearQuery input) {

        var dbDateUser = repository.findByUser_IdAndMonthAndYear(input.idUser, input.month, input.year);

        if(dbDateUser == null) {
            throw new EntityNotFoundException(DbDateUser.class, input.idUser);
        }

        return dbDateUser.id;
    }
}
