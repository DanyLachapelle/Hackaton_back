package school.token.hackaton_groupe7.application.utils;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.create.CategorieUserCreateCommand;

@Service
public interface ICommandHandlerCreateCategorieUser<I,O> {
    O handle(Integer input, CategorieUserCreateCommand command);
}
