package school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserGetAllHandler implements IQueryHandler<Pageable, CategorieUserGetAllOutput> {
    private final ModelMapper modelMapper;
    private final ICategorieUserRepository categorieUserRepository;

    public CategorieUserGetAllHandler(ICategorieUserRepository categorieUserRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.categorieUserRepository = categorieUserRepository;
    }

    @Override
    public CategorieUserGetAllOutput handle(Pageable pageable) {
        CategorieUserGetAllOutput output = new CategorieUserGetAllOutput();
        Iterable<DbCategorieUser> dbCategorieUsers = categorieUserRepository.findAll(pageable);

        for (DbCategorieUser dbCategorieUser : dbCategorieUsers) {
            CategorieUserGetAllOutput.CategorieUser categorieUser = modelMapper.map(dbCategorieUser, CategorieUserGetAllOutput.CategorieUser.class);
            output.categorieUsers.add(categorieUser);
        }

        return output;
    }
}
