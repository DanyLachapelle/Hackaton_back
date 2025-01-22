package school.token.hackaton_groupe7.application.features.dateUser.commands;


import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.dateUser.commands.create.DateUserCreateCommand;
import school.token.hackaton_groupe7.application.features.dateUser.commands.create.DateUserCreateHandler;
import school.token.hackaton_groupe7.application.features.dateUser.commands.create.DateUserCreateOutput;
import school.token.hackaton_groupe7.application.features.dateUser.commands.delete.DateUserDeleteHandler;
import school.token.hackaton_groupe7.application.features.dateUser.commands.update.DateUserUpdateCommand;
import school.token.hackaton_groupe7.application.features.dateUser.commands.update.DateUserUpdateHandler;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;

@Service
public class DateUserCommandProcessor {
    private final ICommandHandler<DateUserCreateCommand, DateUserCreateOutput> createHandler;
    private final ICommandEmptyOutputHandler<DateUserUpdateCommand> updateHandler;
    private final ICommandEmptyOutputHandler<Integer> deleteHandler;

    public DateUserCommandProcessor(DateUserCreateHandler createHandler, DateUserUpdateHandler updateHandler, DateUserDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.updateHandler = updateHandler;
        this.deleteHandler = deleteHandler;
    }

    public DateUserCreateOutput create(DateUserCreateCommand command) {
        return createHandler.handle(command);
    }

    public void update(DateUserUpdateCommand command) {
        updateHandler.handle(command);
    }

    public void delete(Integer id) {
        deleteHandler.handle(id);
    }
}
