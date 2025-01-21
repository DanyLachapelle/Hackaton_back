package school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.InvalideDateException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;

import java.util.function.Supplier;

@Service
public class TransactionGetAllBetweenDateHandler implements IQueryHandler<TransactionGetAllBetweenDateQuery, TransactionGetAllBetweenDateOutput> {
    private final ITransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionGetAllBetweenDateHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionGetAllBetweenDateOutput handle(TransactionGetAllBetweenDateQuery query) {
        var output = new TransactionGetAllBetweenDateOutput();

        if(query.from.after(query.to))
        {
            throw new InvalideDateException(query.from, query.to);
        }
        Iterable<DbTransaction> dbTransactions = transactionRepository.findAllByDateBetween(query.from, query.to, query.pageable);

        for (DbTransaction dbTransaction : dbTransactions) {
            TransactionGetAllBetweenDateOutput.Transaction transaction = modelMapper.map(dbTransaction, TransactionGetAllBetweenDateOutput.Transaction.class);
            output.transactions.add(transaction);
        }

        return output;
    }
}
