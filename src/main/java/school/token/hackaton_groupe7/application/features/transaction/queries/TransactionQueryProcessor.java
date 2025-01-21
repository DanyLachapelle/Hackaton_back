package school.token.hackaton_groupe7.application.features.transaction.queries;


import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllHandler;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllOutput;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

@Service
public class TransactionQueryProcessor {
    private final IQueryHandler<Pageable, TransactionGetAllOutput> getAllHandler;

    public TransactionQueryProcessor(TransactionGetAllHandler getAllHandler) {
        this.getAllHandler = getAllHandler;
    }

    public TransactionGetAllOutput getAll(Pageable pageable) {
        return getAllHandler.handle(pageable);
    }
}
