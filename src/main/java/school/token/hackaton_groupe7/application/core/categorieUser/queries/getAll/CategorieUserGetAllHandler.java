package school.token.hackaton_groupe7.application.core.categorieUser.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.shared.cqrscore.handlers.queries.GenericGetAllHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserGetAllHandler extends GenericGetAllHandler<DbCategorieUser, CategorieUserGetAllQuery, CategorieUserGetAllOutput.CategorieUser, CategorieUserGetAllOutput> {

    public CategorieUserGetAllHandler(ICategorieUserRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CategorieUserGetAllOutput.CategorieUser.class, CategorieUserGetAllOutput.class);
    }
}
