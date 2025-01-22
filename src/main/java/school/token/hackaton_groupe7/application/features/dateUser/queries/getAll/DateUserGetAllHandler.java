package school.token.hackaton_groupe7.application.features.dateUser.queries.getAll;


import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserGetAllHandler implements IQueryHandler<Pageable, DateUserGetAllOutput> {
    private final ModelMapper modelMapper;
    private final IDateUserRepository dateUserRepository;

    public DateUserGetAllHandler(IDateUserRepository dateUserRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.dateUserRepository = dateUserRepository;
    }

    @Override
    public DateUserGetAllOutput handle(Pageable pageable) {
        DateUserGetAllOutput output = new DateUserGetAllOutput();
        Iterable<DbDateUser> dbDateUsers = dateUserRepository.findAll(pageable);

        for (DbDateUser dbDateUser : dbDateUsers) {
            DateUserGetAllOutput.DateUser dateUser = modelMapper.map(dbDateUser, DateUserGetAllOutput.DateUser.class);
            output.dateUsers.add(dateUser);
        }

        return output;
    }
}

