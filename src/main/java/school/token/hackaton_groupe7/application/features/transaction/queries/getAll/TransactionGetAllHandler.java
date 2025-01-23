package school.token.hackaton_groupe7.application.features.transaction.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;

@Service
public class TransactionGetAllHandler implements IQueryHandler<TransactionGetAllQuery,TransactionGetAllOutput> {
    private final ITransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionGetAllHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionGetAllOutput handle(TransactionGetAllQuery query) {
        var output = new TransactionGetAllOutput();
        //Iterable<DbTransaction> dbTransactions = transactionRepository.findAll(query.pageable);
        Iterable<DbTransaction> dbTransactions = transactionRepository.findAllByUser_Id(query.user_id,query.pageable);

        for (DbTransaction dbTransaction : dbTransactions) {
            TransactionGetAllOutput.Transaction transaction = modelMapper.map(dbTransaction, TransactionGetAllOutput.Transaction.class);
            output.transactions.add(transaction);
        }

        return output;
    }
}
