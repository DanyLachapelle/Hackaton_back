package school.token.hackaton_groupe7.application.features.dateUser.commands.create;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.DuplicatedEntityException;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.domain.DateUser;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@Service
public class DateUserCreateHandler implements ICommandHandler<DateUserCreateCommand, DateUserCreateOutput> {
    private final ModelMapper modelMapper;
    private final IDateUserRepository dateUseRepository;
    private final IUserRepository userRepository;

    public DateUserCreateHandler(ModelMapper modelMapper, IDateUserRepository dateUseRepository, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.dateUseRepository = dateUseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DateUserCreateOutput handle(DateUserCreateCommand input) {


        // Récupérer l'utilisateur en fonction de l'ID
        DbUser user = userRepository.findById(input.user_id)
                .orElseThrow(() -> new EntityNotFoundException(DbUser.class, input.user_id));

        var previousDareUser = dateUseRepository.findByUser_IdAndMonthAndYear(input.user_id, input.month, input.year);

        if (previousDareUser != null) {
            throw new DuplicatedEntityException(DbDateUser.class, input.user_id, "user_id");
        }

        DbDateUser dbDateUser = DbDateUser.builder()
                .user(user)
                .year(input.year)
                .month(input.month)
                .budget(input.budget)
                .build();

        DbDateUser savedDbDateUser = dateUseRepository.save(dbDateUser);
        return modelMapper.map(savedDbDateUser, DateUserCreateOutput.class);
    }
}