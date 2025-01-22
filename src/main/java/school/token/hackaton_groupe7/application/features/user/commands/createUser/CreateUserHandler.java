package school.token.hackaton_groupe7.application.features.user.commands.createUser;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.domain.User;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@Service
public class CreateUserHandler implements ICommandHandler<CreateUserCommand,CreateUserOutput> {

    private final ModelMapper modelMapper;
    private final IUserRepository userRepository;

    public CreateUserHandler(ModelMapper modelMapper, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

@Override
public CreateUserOutput handle(CreateUserCommand command) {
    System.out.println("Handling CreateUserCommand: " + command);

    User user = new User();
    user.setUsername(command.getUsername());
    user.setPassword(command.getPassword());
    user.setMail(command.getMail());

    System.out.println("User created: " + user);

    DbUser dbUser = modelMapper.map(user, DbUser.class);
    System.out.println("Mapped DbUser: " + dbUser);

    userRepository.save(dbUser);
    System.out.println("DbUser saved: " + dbUser);

    CreateUserOutput output = new CreateUserOutput();
    output.setId(dbUser.getId());
    output.setUsername(dbUser.getUsername());
    output.setPassword(dbUser.getPassword());
    output.setMail(dbUser.getMail());
    System.out.println("CreateUserOutput created: " + output);

    return output;
}

}
