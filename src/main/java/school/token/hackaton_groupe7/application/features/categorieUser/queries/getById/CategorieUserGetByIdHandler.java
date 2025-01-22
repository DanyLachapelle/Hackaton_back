package school.token.hackaton_groupe7.application.features.categorieUser.queries.getById;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserGetByIdHandler implements IQueryHandler<Integer, CategorieUserGetByIdOutput> {
    private final ModelMapper modelMapper;
    private final ICategorieUserRepository categorieUserRepository;

    public CategorieUserGetByIdHandler(ModelMapper modelMapper, ICategorieUserRepository categorieUserRepository) {
        this.modelMapper = modelMapper;
        this.categorieUserRepository = categorieUserRepository;
    }

    @Override
    public CategorieUserGetByIdOutput handle(Integer id) {
        DbCategorieUser dbCategorieUser = categorieUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(DbCategorieUser.class, id));
        return modelMapper.map(dbCategorieUser, CategorieUserGetByIdOutput.class);
    }
}