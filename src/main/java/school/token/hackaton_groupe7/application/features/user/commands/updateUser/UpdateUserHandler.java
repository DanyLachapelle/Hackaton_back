package school.token.hackaton_groupe7.application.features.user.commands.updateUser;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.application.utils.ICommandHandlerUpdate;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@Service
public class UpdateUserHandler implements ICommandHandlerUpdate<UpdateUserCommand, UpdateUserOutput> {
    private final ModelMapper modelMapper;
    private final IUserRepository userRepository;

    public UpdateUserHandler(ModelMapper modelMapper, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UpdateUserOutput handle(Integer id,UpdateUserCommand command) {
        System.out.println("Handling UpdateUserCommand: " + command);

        DbUser dbUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        dbUser.setUsername(command.getUsername());
        dbUser.setTotbalance(command.getTotbalance());
        dbUser.setTotbudget(command.getTotbudget());
        dbUser.setPassword(command.getPassword());
        dbUser.setMail(command.getMail());

        userRepository.save(dbUser);
        System.out.println("DbUser updated: " + dbUser);

        UpdateUserOutput output = new UpdateUserOutput();
        output.setId(dbUser.getId());
        output.setUsername(dbUser.getUsername());
        output.setTotbalance(dbUser.getTotbalance());
        output.setTotbudget(dbUser.getTotbudget());
        output.setPassword(dbUser.getPassword());
        output.setMail(dbUser.getMail());
        System.out.println("UpdateUserOutput created: " + output);

        return output;
    }
}
