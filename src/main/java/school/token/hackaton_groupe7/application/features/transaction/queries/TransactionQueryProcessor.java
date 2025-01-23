package school.token.hackaton_groupe7.application.features.transaction.queries;


import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate.TransactionGetAllBetweenDateHandler;
import school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate.TransactionGetAllBetweenDateOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate.TransactionGetAllBetweenDateQuery;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieHandler;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieQuery;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllHandler;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllQuery;
import school.token.hackaton_groupe7.application.features.transaction.queries.getById.TransactionGetByIdHandler;
import school.token.hackaton_groupe7.application.features.transaction.queries.getById.TransactionGetByIdOutput;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

@Service
public class TransactionQueryProcessor {
    private final IQueryHandler<TransactionGetAllQuery, TransactionGetAllOutput> getAllHandler;
    private final IQueryHandler<Integer, TransactionGetByIdOutput> getByIdHandler;
    private final IQueryHandler<TransactionGetByCategorieQuery, TransactionGetByCategorieOutput> getByIdCategorieHandler;
    private final IQueryHandler<TransactionGetAllBetweenDateQuery, TransactionGetAllBetweenDateOutput> getBetweenDateHandler;

    public TransactionQueryProcessor(TransactionGetAllHandler getAllHandler,
                                     TransactionGetByIdHandler getByIdHandler,
                                     TransactionGetByCategorieHandler getByIdCategorieHandler,
                                     TransactionGetAllBetweenDateHandler getBetweenDateHandler) {
        this.getAllHandler = getAllHandler;
        this.getByIdHandler = getByIdHandler;
        this.getByIdCategorieHandler = getByIdCategorieHandler;
        this.getBetweenDateHandler = getBetweenDateHandler;
    }

    public TransactionGetAllOutput getAll(TransactionGetAllQuery query) {
        return getAllHandler.handle(query);
    }

    public TransactionGetByIdOutput getById(Integer id) {
        return getByIdHandler.handle(id);
    }

    public TransactionGetByCategorieOutput getByIdCategorie(TransactionGetByCategorieQuery query) {
        return getByIdCategorieHandler.handle(query);
    }

    public TransactionGetAllBetweenDateOutput getBetweenDates(TransactionGetAllBetweenDateQuery query) {
        return getBetweenDateHandler.handle(query);
    }
}
