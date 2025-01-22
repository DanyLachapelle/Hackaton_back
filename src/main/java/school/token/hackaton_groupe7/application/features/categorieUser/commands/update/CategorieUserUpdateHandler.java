package school.token.hackaton_groupe7.application.features.categorieUser.commands.update;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.domain.CategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

@Service
public class CategorieUserUpdateHandler implements ICommandEmptyOutputHandler<CategorieUserUpdateCommand> {
    private final ModelMapper modelMapper;
    private final ICategorieUserRepository categorieUserRepository;

    public CategorieUserUpdateHandler(ModelMapper modelMapper, ICategorieUserRepository categorieUserRepository) {
        this.modelMapper = modelMapper;
        this.categorieUserRepository = categorieUserRepository;
    }

    @Override
    public void handle(CategorieUserUpdateCommand input) {
        DbCategorieUser dbCategorieUser = categorieUserRepository.findById(input.id).orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, input.id));

        CategorieUser categorieUser = modelMapper.map(dbCategorieUser, CategorieUser.class);

        categorieUser.setId(input.id);
        categorieUser.setBudget(input.budget);
        categorieUser.setName(input.name);

        categorieUserRepository.save(modelMapper.map(categorieUser, DbCategorieUser.class));
    }
}
