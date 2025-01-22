package school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@Service
public class CategorieUserGetByUserHandler implements IQueryHandler<CategorieUserGetByUserQuery, CategorieUserGetByUserOutput> {
    private final ICategorieUserRepository categorieUserRepository;
    private final ModelMapper modelMapper;

    public CategorieUserGetByUserHandler(ICategorieUserRepository categorieUserRepository, ModelMapper modelMapper) {
        this.categorieUserRepository = categorieUserRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategorieUserGetByUserOutput handle(CategorieUserGetByUserQuery query) {
        var output = new CategorieUserGetByUserOutput();

        Iterable<DbCategorieUser> dbCategorieUsers = categorieUserRepository.findAllByUser_Id(query.user_id, query.pageable);

        for (DbCategorieUser dbCategorieUser : dbCategorieUsers) {
            CategorieUserGetByUserOutput.CategorieUser categorieUser = modelMapper.map(dbCategorieUser, CategorieUserGetByUserOutput.CategorieUser.class);
            output.categorieUsers.add(categorieUser);
        }

        return output;
    }
}
