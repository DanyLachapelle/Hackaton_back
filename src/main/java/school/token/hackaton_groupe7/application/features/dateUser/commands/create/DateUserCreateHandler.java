package school.token.hackaton_groupe7.application.features.dateUser.commands.create;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserCreateHandler implements ICommandHandler<DateUserCreateCommand, DateUserCreateOutput> {
    private final ModelMapper modelMapper;
    private final IDateUserRepository dateUseRepository;

    public DateUserCreateHandler(ModelMapper modelMapper, IDateUserRepository dateUseRepository) {
        this.modelMapper = modelMapper;
        this.dateUseRepository = dateUseRepository;
    }

    @Override
    public DateUserCreateOutput handle(DateUserCreateCommand input) {
        DbDateUser dateUser = modelMapper.map(input, DbDateUser.class);


        DbDateUser dbDateUser = modelMapper.map(dateUser, DbDateUser.class);
        DbDateUser savedDbDateUser = dateUseRepository.save(dbDateUser);
        return modelMapper.map(savedDbDateUser, DateUserCreateOutput.class);
    }
}


