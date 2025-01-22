package school.token.hackaton_groupe7.application.features.categorieUser.queries;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getById.CategorieUserGetByIdOutput;
import org.springframework.data.domain.Pageable;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser.CategorieUserGetByUserHandler;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser.CategorieUserGetByUserOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser.CategorieUserGetByUserQuery;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;
import school.token.hackaton_groupe7.domain.User;

@Service
public class CategorieUserQueryProcessor {
    private final IQueryHandler<Pageable, CategorieUserGetAllOutput> getAllHandler;
    private final IQueryHandler<Integer, CategorieUserGetByIdOutput> getByIdHandler;
    private final IQueryHandler<CategorieUserGetByUserQuery, CategorieUserGetByUserOutput> getByUserHandler;

    public CategorieUserQueryProcessor(IQueryHandler<Pageable, CategorieUserGetAllOutput> getAllHandler,
                                       IQueryHandler<Integer, CategorieUserGetByIdOutput> getByIdHandler,
                                       CategorieUserGetByUserHandler getByUserHandler) {
        this.getAllHandler = getAllHandler;
        this.getByIdHandler = getByIdHandler;
        this.getByUserHandler = getByUserHandler;
    }

    public CategorieUserGetAllOutput getAll(Pageable pageable) {
        return getAllHandler.handle(pageable);
    }


    public CategorieUserGetByIdOutput getById(Integer id) {
        return getByIdHandler.handle(id);
    }

    public CategorieUserGetByUserOutput getByUser(CategorieUserGetByUserQuery query) {
        return getByUserHandler.handle(query);
    }
}