package school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieRepository;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@Service
public class TransactionGetByCategorieHandler implements IQueryHandler<TransactionGetByCategorieQuery, TransactionGetByCategorieOutput> {
    private final ITransactionRepository transactionRepository;
    private final ModelMapper modelMapper;
    private final IUserRepository userRepository;
    private final ICategorieUserRepository categorieUserRepository;

    public TransactionGetByCategorieHandler(ITransactionRepository transactionRepository, ModelMapper modelMapper, IUserRepository userRepository, ICategorieUserRepository categorieRepository) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.categorieUserRepository = categorieRepository;
    }

    @Override
    public TransactionGetByCategorieOutput handle(TransactionGetByCategorieQuery query) {

        // Récupérer l'utilisateur en fonction de l'ID
        DbUser user = userRepository.findById(query.idUser)
                .orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, query.idUser));

        // Récupérer la catégorie en fonction de l'ID
        DbCategorieUser category = categorieUserRepository.findById(query.idCat)
                .orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, query.idCat));

        var output = new TransactionGetByCategorieOutput();

        Iterable<DbTransaction> dbTransactions = transactionRepository.findByUserAndMonthAndCategory(query.idUser, query.month, query.year, query.idCat);

        for (DbTransaction dbTransaction : dbTransactions) {
            TransactionGetByCategorieOutput.Transaction transaction = modelMapper.map(dbTransaction, TransactionGetByCategorieOutput.Transaction.class);
            output.transactions.add(transaction);
        }

        return output;
    }
}
