package school.token.hackaton_groupe7.application.features.user.queries.getAllUsers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;


@Service
public class UserGetAllHandler implements IQueryHandler<UserGetAllCommand,UserGetAllOutput> {

    private final ModelMapper modelMapper;
    private final IUserRepository userRepository;

    public UserGetAllHandler(ModelMapper modelMapper, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public UserGetAllOutput handle(UserGetAllCommand command) {

        // Exécution de la méthode principale
        UserGetAllOutput output = new UserGetAllOutput();
        Iterable<DbUser> dbUsers = userRepository.findAll(); // Vous pouvez ajuster en fonction des critères dans UserGetAllCommand
        for (DbUser dbUser : dbUsers) {

            UserGetAllOutput.User user = modelMapper.map(dbUser, UserGetAllOutput.User.class);
            output.users.add(user);
        }
        return output;
    }

}
