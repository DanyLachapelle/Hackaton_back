package school.token.hackaton_groupe7.application.features.categorieUser.commands.create;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import school.token.hackaton_groupe7.application.exceptions.OverBudgetForCategorieException;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class CategorieUserCreateHandler implements ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> {
    private final ModelMapper modelMapper;
    private final ICategorieUserRepository categorieUseRepository;
    private final IDateUserRepository dateUserRepository;

    public CategorieUserCreateHandler(ModelMapper modelMapper, ICategorieUserRepository categorieUseRepository, IDateUserRepository dateUserRepository) {
        this.modelMapper = modelMapper;
        this.categorieUseRepository = categorieUseRepository;
        this.dateUserRepository = dateUserRepository;
    }

    @Override
    public CategorieUserCreateOutput handle(CategorieUserCreateCommand input) {
        DbCategorieUser categorieUser = modelMapper.map(input, DbCategorieUser.class);

        Iterable<DbCategorieUser> allPreviousDbCategorieUsers = categorieUseRepository.findAllByUser_IdAndYearAndMonth(input.idUser,input.year, input.month);
        double sumOfBudget = categorieUser.budget;

        for(DbCategorieUser previousDbCategorieUser : allPreviousDbCategorieUsers) {
            sumOfBudget += previousDbCategorieUser.budget;
        }

        double budget = dateUserRepository.findByUser_IdAndMonthAndYear(input.idUser, input.month, input.year).budget;

        if(budget < sumOfBudget) {
            throw new OverBudgetForCategorieException(budget,categorieUser.budget,(sumOfBudget-budget));
        }

        DbCategorieUser dbCategorieUser = modelMapper.map(categorieUser, DbCategorieUser.class);
        DbCategorieUser savedDbCategorieUser = categorieUseRepository.save(dbCategorieUser);
        return modelMapper.map(savedDbCategorieUser, CategorieUserCreateOutput.class);
    }
}


