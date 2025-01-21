package school.token.hackaton_groupe7.application.features.categorieUser.commands.delete;

import org.springframework.stereotype.Service;

import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserDeleteHandler implements ICommandEmptyOutputHandler<Long> {
    private final ICategorieUserRepository directoryRepository;

    public CategorieUserDeleteHandler(ICategorieUserRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @Override
    public void handle(Long id) {
        if (directoryRepository.existsById(id))
            directoryRepository.deleteById(id);
        else
            throw new EntityNotFoundException(DbCategorieUser.class, id);
    }
}