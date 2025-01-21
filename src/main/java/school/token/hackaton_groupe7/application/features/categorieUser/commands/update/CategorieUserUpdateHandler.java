package school.token.hackaton_groupe7.application.features.categorieUser.commands.update;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

@Service
public class CategorieUserUpdateHandler implements ICommandEmptyOutputHandler<CategorieUserUpdateCommand> {
    private final ICategorieUserRepository categorieUserRepository;

    public CategorieUserUpdateHandler(ICategorieUserRepository categorieUserRepository) {
        this.categorieUserRepository = categorieUserRepository;
    }

    @Override
    public void handle(CategorieUserUpdateCommand input) {
        DbCategorieUser dbCategorieUser = categorieUserRepository.findById(input.id).orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, input.id));
        dbCategorieUser.budget = input.budget;
        categorieUserRepository.save(dbCategorieUser);
    }
}
