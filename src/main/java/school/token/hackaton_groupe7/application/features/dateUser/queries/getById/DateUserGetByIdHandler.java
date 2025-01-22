package school.token.hackaton_groupe7.application.features.dateUser.queries.getById;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserGetByIdHandler implements IQueryHandler<Integer, DateUserGetByIdOutput> {
    private final ModelMapper modelMapper;
    private final IDateUserRepository dateUserRepository;

    public DateUserGetByIdHandler(ModelMapper modelMapper, IDateUserRepository dateUserRepository) {
        this.modelMapper = modelMapper;
        this.dateUserRepository = dateUserRepository;
    }

    @Override
    public DateUserGetByIdOutput handle(Integer id) {
        DbDateUser dbDateUser = dateUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DbDateUser.class, id));
        return modelMapper.map(dbDateUser, DateUserGetByIdOutput.class);
    }
}