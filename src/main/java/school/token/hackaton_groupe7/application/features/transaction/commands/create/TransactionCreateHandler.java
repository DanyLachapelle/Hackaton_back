package school.token.hackaton_groupe7.application.features.transaction.commands.create;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.domain.Transaction;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@Service
@Qualifier("transactionDeleteHandler")
public class TransactionCreateHandler implements ICommandHandler<TransactionCreateCommand, TransactionCreateOuput> {
    private final ModelMapper modelMapper;
    private final ITransactionRepository transactionRepository;

    private final ICategorieUserRepository categorieUserRepository;
    private final IUserRepository userRepository;

    public TransactionCreateHandler(ModelMapper modelMapper, ITransactionRepository transactionRepository, ICategorieUserRepository categorieUserRepository, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
        this.categorieUserRepository = categorieUserRepository;
        this.userRepository = userRepository;
    }


    @Override
    public TransactionCreateOuput handle(TransactionCreateCommand input) {

        // Récupérer l'utilisateur en fonction de l'ID
        DbUser user = userRepository.findById(input.user_id)
                .orElseThrow(() -> new EntityNotFoundException(DbUser.class, input.user_id));

        // Récupérer la catégorie en fonction de l'ID
        DbCategorieUser category = categorieUserRepository.findById(input.category_id)
                .orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, input.category_id));

        DbTransaction dbTransaction = DbTransaction.builder()
                .user(user)
                .category(category)
                .date(input.date)
                .amount(input.amount)
                .object(input.object)
                .build();

        return modelMapper.map(transactionRepository.save(dbTransaction), TransactionCreateOuput.class);
    }
}
