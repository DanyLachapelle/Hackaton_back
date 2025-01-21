package school.token.hackaton_groupe7.application.core.categorieUser.commands.delete;

import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import school.token.hackaton_groupe7.application.shared.cqrscore.handlers.commands.GenericDeleteHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserDeleteHandler  extends GenericDeleteHandler<DbCategorieUser, CategorieUserDeleteCommand> {
    public CategorieUserDeleteHandler(ModelMapper modelMapper, ICategorieUserRepository repository) {
        super(modelMapper, repository);
    }
}
