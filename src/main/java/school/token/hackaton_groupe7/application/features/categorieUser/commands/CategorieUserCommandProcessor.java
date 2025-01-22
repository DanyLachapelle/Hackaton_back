package school.token.hackaton_groupe7.application.features.categorieUser.commands;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.create.CategorieUserCreateCommand;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.create.CategorieUserCreateOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.delete.CategorieUserDeleteHandler;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.update.CategorieUserUpdateCommand;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.update.CategorieUserUpdateHandler;
import school.token.hackaton_groupe7.application.features.dateUser.commands.create.DateUserCreateHandler;
import school.token.hackaton_groupe7.application.features.dateUser.commands.update.DateUserUpdateHandler;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;


@Service
public class CategorieUserCommandProcessor {
    private final ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> createHandler;
    private final ICommandEmptyOutputHandler<CategorieUserUpdateCommand> updateHandler;
    private final ICommandEmptyOutputHandler<Integer> deleteHandler;

    public CategorieUserCommandProcessor(CategorieUserCreateHandler createHandler, CategorieUserUpdateHandler updateHandler, CategorieUserDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.updateHandler = updateHandler;
        this.deleteHandler = deleteHandler;
    }

    public CategorieUserCreateOutput create(CategorieUserCreateCommand command) {
        return createHandler.handle(command);
    }

    public void update(CategorieUserUpdateCommand command) {
        updateHandler.handle(command);
    }

    public void delete(Integer id) {
        deleteHandler.handle(id);
    }
}
