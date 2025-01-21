package school.token.hackaton_groupe7.application.features.transaction.commands.delete;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;

@Service
public class TransactionDeleteHandler implements ICommandEmptyOutputHandler<Integer> {
    private final ITransactionRepository transactionRepository;

    public TransactionDeleteHandler(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void handle(Integer id) {
        if(!transactionRepository.existsById(id)) {
            throw new EntityNotFoundException(DbTransaction.class,id);
        }
        transactionRepository.deleteById(id);
    }
}
