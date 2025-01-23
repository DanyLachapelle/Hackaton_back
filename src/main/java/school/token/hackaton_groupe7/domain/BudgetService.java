package school.token.hackaton_groupe7.domain;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.features.transaction.queries.getById.TransactionGetByIdOutput;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;
import school.token.hackaton_groupe7.infrastructure.transaction.ITransactionRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

@Service
public class BudgetService {

    private final ITransactionRepository transactionRepository;
    private final IDateUserRepository dateUserRepository;
    private final ICategorieUserRepository categorieUserRepository;
    private final ModelMapper modelMapper;

    public BudgetService(ITransactionRepository transactionRepository, IDateUserRepository dateUserRepository, ICategorieUserRepository categorieUserRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.dateUserRepository = dateUserRepository;
        this.categorieUserRepository = categorieUserRepository;
        this.modelMapper = modelMapper;
    }

    public double getUserBalance(int userId, int month, int year) {
        // Récupérer les transactions de l'utilisateur pour le mois et l'année donnés
        List<DbTransaction> transactions = transactionRepository.findByUserAndMonth(userId, month, year);

        // Calculer la somme des montants des transactions
        double totalTransactions = transactions.stream()
                .mapToDouble(DbTransaction::getAmount)
                .sum();

        // Récupérer le budget de l'utilisateur pour le mois et l'année donnés
        DbDateUser dbDateUser = dateUserRepository.findByUser_IdAndMonthAndYear(userId, month, year);

        if(dbDateUser == null) {
            throw new EntityNotFoundException(TransactionGetByIdOutput.class, userId);
        }

        DateUser dateUser = modelMapper.map(dbDateUser, DateUser.class);
        double budget = dateUser != null ? dateUser.getBudget() : 0;

        // Calculer et retourner le solde
        return budget + totalTransactions;
    }

    public double getUserBalanceByCat(int userId, int month, int year, int categoryId) {
        // Récupérer les transactions de l'utilisateur pour le mois et l'année donnés
        List<DbTransaction> transactions = transactionRepository.findByUserAndMonthAndCategory(userId, month, year,categoryId);

        // Calculer la somme des montants des transactions
        double totalTransactions = transactions.stream()
                .mapToDouble(DbTransaction::getAmount)
                .sum();

        // retourner le solde
        return totalTransactions;
    }

    public Iterable<TransactionStats> getUserTransactionsStat(int userId, int month, int year) {

        List<TransactionStats> transactionStatsList = new ArrayList<>();

        List<DbTransaction> transactions = transactionRepository.findByUserAndMonth(userId, month, year);

        // Calculer la somme des montants des transactions pour avoir les dépenses totale
        double depenseTot = transactions.stream()
                .mapToDouble(DbTransaction::getAmount)
                .sum();

        // Création des stats par catégorie
        List<DbCategorieUser> categorieUsers = categorieUserRepository.findAllByUser_Id(userId);

        for(DbCategorieUser categorieUser : categorieUsers) {
            double percentage = (abs(getUserBalanceByCat(categorieUser.user.id, month, year, categorieUser.id)) / abs(depenseTot)) * 100;
//            TransactionStats transactionStats = new TransactionStats(categorieUser.name, percentage);
            TransactionStats transactionStats = new TransactionStats(categorieUser.name, getUserBalanceByCat(categorieUser.user.id, month, year, categorieUser.id));
            transactionStatsList.add(transactionStats);
        }

        return transactionStatsList;
    }
}
