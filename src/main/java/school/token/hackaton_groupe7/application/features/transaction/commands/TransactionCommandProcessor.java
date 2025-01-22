package school.token.hackaton_groupe7.application.features.transaction.commands;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.transaction.commands.create.TransactionCreateCommand;
import school.token.hackaton_groupe7.application.features.transaction.commands.create.TransactionCreateHandler;
import school.token.hackaton_groupe7.application.features.transaction.commands.create.TransactionCreateOuput;
import school.token.hackaton_groupe7.application.features.transaction.commands.delete.TransactionDeleteHandler;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;

@Service
public class TransactionCommandProcessor {
    private final ICommandHandler<TransactionCreateCommand, TransactionCreateOuput> createHandler;
    private final ICommandEmptyOutputHandler<Integer> deleteHandler;

    public TransactionCommandProcessor(TransactionCreateHandler createHandler,
                                       TransactionDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.deleteHandler = deleteHandler;
    }

    public TransactionCreateOuput create(TransactionCreateCommand command) {
        return createHandler.handle(command);
    }

    public void delete(int id) {
        deleteHandler.handle(id);
    }
}
