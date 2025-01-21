package school.token.hackaton_groupe7.application.features.user.queries.getByIdUser;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserGetByIdHandler implements IQueryHandler<Integer, UserGetByIdOutput> {
    private final ModelMapper modelMapper;
    private final IUserRepository userRepository;

    public UserGetByIdHandler(ModelMapper modelMapper, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }



    @Override
    public UserGetByIdOutput handle(Integer id) {
        DbUser dbUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        System.out.println("Utilisateur trouvé dans la base de données : " + dbUser);
        return modelMapper.map(dbUser,UserGetByIdOutput.class);
    }
}
