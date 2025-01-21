package school.token.hackaton_groupe7.application.core.categorieUser.queries.getById;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.shared.cqrscore.handlers.queries.GenericGetByIdHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserGetByIdHandler extends GenericGetByIdHandler<DbCategorieUser, CategorieUserGetByIdQuery, CategorieUserGetByIdOutput> {

    public CategorieUserGetByIdHandler(ICategorieUserRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CategorieUserGetByIdOutput.class);
    }

}
