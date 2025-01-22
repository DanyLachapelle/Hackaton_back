package school.token.hackaton_groupe7.application.features.dateUser.commands.update;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.domain.DateUser;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserUpdateHandler implements ICommandEmptyOutputHandler<DateUserUpdateCommand> {
    private final ModelMapper modelMapper;
    private final IDateUserRepository dateUserRepository;

    public DateUserUpdateHandler(ModelMapper modelMapper, IDateUserRepository dateUserRepository) {
        this.modelMapper = modelMapper;
        this.dateUserRepository = dateUserRepository;
    }

    @Override
    public void handle(DateUserUpdateCommand input) {
        DbDateUser dbDateUser = dateUserRepository.findById(input.id).orElseThrow(() -> new EntityNotFoundException(DbDateUser.class, input.id));

        DateUser dateUser = modelMapper.map(dbDateUser, DateUser.class);

        dateUser.setId(input.id);
        dateUser.setMonth(input.month);
        dateUser.setYear(input.year);
        dateUser.setIdUser(input.user_id);
        dateUser.setBudget(input.budget);

        dateUserRepository.save(modelMapper.map(dateUser, DbDateUser.class));
    }
}
