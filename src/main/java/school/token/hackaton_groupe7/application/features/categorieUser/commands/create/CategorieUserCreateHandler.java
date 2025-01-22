package school.token.hackaton_groupe7.application.features.categorieUser.commands.create;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserCreateHandler implements ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> {
    private final ModelMapper modelMapper;
    private final ICategorieUserRepository categorieUseRepository;

    public CategorieUserCreateHandler(ModelMapper modelMapper, ICategorieUserRepository categorieUseRepository) {
        this.modelMapper = modelMapper;
        this.categorieUseRepository = categorieUseRepository;
    }

    @Override
    public CategorieUserCreateOutput handle(CategorieUserCreateCommand input) {
        DbCategorieUser categorieUser = modelMapper.map(input, DbCategorieUser.class);


        DbCategorieUser dbCategorieUser = modelMapper.map(categorieUser, DbCategorieUser.class);
        DbCategorieUser savedDbCategorieUser = categorieUseRepository.save(dbCategorieUser);
        return modelMapper.map(savedDbCategorieUser, CategorieUserCreateOutput.class);
    }
}


