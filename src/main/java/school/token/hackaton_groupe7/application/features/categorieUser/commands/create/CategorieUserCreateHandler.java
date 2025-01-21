package school.token.hackaton_groupe7.application.features.categorieUser.commands.create;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserCreateHandler implements ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> {
    private final ICategorieUserRepository categorieUseRepository;
    private final ModelMapper modelMapper;

    public CategorieUserCreateHandler(ICategorieUserRepository categorieUseRepository, ModelMapper modelMapper) {
        this.categorieUseRepository = categorieUseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategorieUserCreateOutput handle(CategorieUserCreateCommand input) {
        DbCategorieUser dbCategorieUser = modelMapper.map(input, DbCategorieUser.class);
        return modelMapper.map(categorieUseRepository.save(dbCategorieUser), CategorieUserCreateOutput.class);
    }
}


