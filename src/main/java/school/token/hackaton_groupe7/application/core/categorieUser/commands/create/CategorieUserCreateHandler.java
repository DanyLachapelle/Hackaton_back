package school.token.hackaton_groupe7.application.core.categorieCategorieUser.commands.create;

import school.token.hackaton_groupe7.application.core.categorieUser.commands.create.CategorieUserCreateCommand;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.create.CategorieUserCreateOutput;
import school.token.hackaton_groupe7.application.shared.cqrscore.interfaces.IValidator;
import school.token.hackaton_groupe7.application.shared.cqrscore.handlers.commands.GenericCreateHandler;
import school.token.hackaton_groupe7.application.shared.cqrscore.interfaces.IEntityRepository;
import school.token.hackaton_groupe7.domain.CategorieUser;
import org.modelmapper.ModelMapper;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

public class CategorieCategorieUserCreateHandler extends GenericCreateHandler<CategorieUser, DbCategorieUser, CategorieUserCreateCommand, CategorieUserCreateOutput> {


    public CategorieUserCreateHandler(ModelMapper modelMapper, IEntityRepository<DbCategorieUser> repository, IValidator<CategorieUserCreateCommand> validator) {
        super(modelMapper, CategorieUser.class, DbCategorieUser.class, repository, CategorieUserCreateOutput.class);
        super.setValidator(validator);
    }

}
