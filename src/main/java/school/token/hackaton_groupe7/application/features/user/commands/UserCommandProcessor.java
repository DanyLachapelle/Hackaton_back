package school.token.hackaton_groupe7.application.features.user.commands;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.user.commands.createUser.CreateUserCommand;
import school.token.hackaton_groupe7.application.features.user.commands.createUser.CreateUserOutput;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserCommand;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserOutput;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.application.utils.ICommandHandlerUpdate;

@Service
public class UserCommandProcessor {
    private final ICommandHandler<CreateUserCommand, CreateUserOutput> createUserHandler;
    private final ICommandHandler<Integer, Void> deleteHandler;
    private final ICommandHandlerUpdate<UpdateUserCommand, UpdateUserOutput> updateUserHandler;

    public UserCommandProcessor(
            ICommandHandler<CreateUserCommand, CreateUserOutput> createUserHandler,
            ICommandHandler<Integer, Void> deleteHandler,
            ICommandHandlerUpdate<UpdateUserCommand, UpdateUserOutput> updateUserHandler
    ) {
        this.createUserHandler = createUserHandler;
        this.deleteHandler = deleteHandler;
        this.updateUserHandler = updateUserHandler;
    }


    public CreateUserOutput createUser(CreateUserCommand input) {
        return createUserHandler.handle(input);
    }

    public Void delete(int id) {
        return deleteHandler.handle(id);
    }

    public UpdateUserOutput updateUser(Integer id,UpdateUserCommand updateUserCommand) {
        return updateUserHandler.handle(id,updateUserCommand);
    }
}
