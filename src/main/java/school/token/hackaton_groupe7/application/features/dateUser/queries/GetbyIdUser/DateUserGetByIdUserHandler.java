package school.token.hackaton_groupe7.application.features.dateUser.queries.GetbyIdUser;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserGetByIdUserHandler implements IQueryHandler<Integer, DateUserGetByIdUserOutput> {
    private final ModelMapper modelMapper;
    private final IDateUserRepository dateUserRepository;

    public DateUserGetByIdUserHandler(ModelMapper modelMapper, IDateUserRepository dateUserRepository) {
        this.modelMapper = modelMapper;
        this.dateUserRepository = dateUserRepository;
    }

    @Override
    public DateUserGetByIdUserOutput handle(Integer id_user) {
        DbDateUser dbDateUser = dateUserRepository.findById(id_user)
                .orElseThrow(() -> new EntityNotFoundException(DbDateUser.class, id_user));
        return modelMapper.map(dbDateUser, DateUserGetByIdUserOutput.class);
    }
}
