package school.token.hackaton_groupe7.application.features.categorieUser.commands.delete;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
@Qualifier("categorieUserDeleteHandler")
public class CategorieUserDeleteHandler implements ICommandEmptyOutputHandler<Integer> {
    private final ICategorieUserRepository categorieUserRepository;

    public CategorieUserDeleteHandler(ICategorieUserRepository categorieUserRepository) {
        this.categorieUserRepository = categorieUserRepository;
    }

    @Override
    public void handle(Integer id) {
        if (categorieUserRepository.existsById(id))
            categorieUserRepository.deleteById(id);
        else
            throw new EntityNotFoundException(DbCategorieUser.class, id);
    }
}