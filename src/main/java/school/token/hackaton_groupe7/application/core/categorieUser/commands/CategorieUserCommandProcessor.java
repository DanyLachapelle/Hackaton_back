package school.token.hackaton_groupe7.application.core.categorieUser.commands;

import school.token.hackaton_groupe7.application.core.categorieUser.commands.create.CategorieUserCreateCommand;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.create.CategorieUserCreateOutput;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.delete.CategorieUserDeleteCommand;
import school.token.hackaton_groupe7.application.shared.cqrscore.interfaces.ICommandHandler;
import school.token.hackaton_groupe7.application.shared.cqrscore.interfaces.ICommandWithoutResponseHandler;

public class CategorieUserCommandProcessor {
    private final ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> categorieUserCreateHandler;
    private final ICommandWithoutResponseHandler<CategorieUserDeleteCommand> categorieUserDeleteHandler;

    public CategorieUserCommandProcessor(ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> categorieUserCreateHandler, ICommandWithoutResponseHandler<CategorieUserDeleteCommand> categorieUserDeleteHandler) {
        this.categorieUserCreateHandler = categorieUserCreateHandler;
        this.categorieUserDeleteHandler = categorieUserDeleteHandler;
    }

    public CategorieUserCreateOutput create(CategorieUserCreateCommand command){
        return categorieUserCreateHandler.handle(command);
    }

    public void delete(CategorieUserDeleteCommand command) {
        categorieUserDeleteHandler.handle(command);
    }
}
