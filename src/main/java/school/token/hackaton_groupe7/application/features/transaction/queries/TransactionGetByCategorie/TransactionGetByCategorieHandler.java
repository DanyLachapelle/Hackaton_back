package school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;

@Service
public class TransactionGetByCategorieHandler implements IQueryHandler<TransactionGetByCategorieQuery, TransactionGetByCategorieOutput> {
    private final ITransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionGetByCategorieHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionGetByCategorieOutput handle(TransactionGetByCategorieQuery query) {
        var output = new TransactionGetByCategorieOutput();

        Iterable<DbTransaction> dbTransactions = transactionRepository.findByUserAndMonthAndCategory(query.idUser, query.month, query.year, query.idCat);

        for (DbTransaction dbTransaction : dbTransactions) {
            TransactionGetByCategorieOutput.Transaction transaction = modelMapper.map(dbTransaction, TransactionGetByCategorieOutput.Transaction.class);
            output.transactions.add(transaction);
        }

        return output;
    }
}
