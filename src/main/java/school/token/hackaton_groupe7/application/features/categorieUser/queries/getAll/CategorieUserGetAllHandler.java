package school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserGetAllHandler implements IEmptyParameterizedQueryHandler<CategorieUserGetAllOutput> {
    private final ICategorieUserRepository directoryRepository;
    private final ModelMapper modelMapper;

    public CategorieUserGetAllHandler(ICategorieUserRepository directoryRepository, ModelMapper modelMapper) {
        this.directoryRepository = directoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategorieUserGetAllOutput handle() {
        var output = new CategorieUserGetAllOutput();
        var dbDirectories = directoryRepository.findAll();

        dbDirectories.forEach(dbCategorieUser -> output.categorieUsers.add(modelMapper.map(dbCategorieUser, CategorieUserGetAllOutput.CategorieUser.class)));

        return output;
    }
}