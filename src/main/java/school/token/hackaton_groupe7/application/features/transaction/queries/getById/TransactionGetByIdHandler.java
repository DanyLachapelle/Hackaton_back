package school.token.hackaton_groupe7.application.features.transaction.queries.getById;

import org.hibernate.action.internal.EntityActionVetoException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;

@Service
public class TransactionGetByIdHandler implements IQueryHandler<Integer, TransactionGetByIdOutput> {
    private final ITransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionGetByIdHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionGetByIdOutput handle(Integer input) {
        var output = new TransactionGetByIdOutput();

        DbTransaction dbTransaction = transactionRepository.findById(input)
                .orElseThrow(() -> new EntityNotFoundException(TransactionGetByIdOutput.class, input));

        output = modelMapper.map(dbTransaction, TransactionGetByIdOutput.class);
        return output;
    }
}
