package school.token.hackaton_groupe7.application.features.categorieUser.commands.update;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

@Service
public class CategorieUserUpdateHandler implements ICommandEmptyOutputHandler<CategorieUserUpdateCommand> {
    private final ICategorieUserRepository directoryRepository;

    public CategorieUserUpdateHandler(ICategorieUserRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public void handle(CategorieUserUpdateCommand input) {
        DbCategorieUser dbCategorieUser = directoryRepository.findById((long) input.id).orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, (long) input.id));
        dbCategorieUser.budget = input.budget;
        directoryRepository.save(dbCategorieUser);
    }
}
