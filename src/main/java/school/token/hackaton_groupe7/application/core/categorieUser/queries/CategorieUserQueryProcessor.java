package school.token.hackaton_groupe7.application.core.categorieUser.queries;

import school.token.hackaton_groupe7.application.core.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getAll.CategorieUserGetAllQuery;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getById.CategorieUserGetByIdOutput;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getById.CategorieUserGetByIdQuery;
import school.token.hackaton_groupe7.application.shared.cqrscore.interfaces.IQueryHandler;

public class CategorieUserQueryProcessor {
    private final IQueryHandler<CategorieUserGetByIdQuery, CategorieUserGetByIdOutput> userGetByIdHandler;
    private final IQueryHandler<CategorieUserGetAllQuery, CategorieUserGetAllOutput> userGetAllHandler;

    public CategorieUserQueryProcessor(IQueryHandler<CategorieUserGetByIdQuery, CategorieUserGetByIdOutput> userGetByIdHandler, IQueryHandler<CategorieUserGetAllQuery, CategorieUserGetAllOutput> userGetAllHandler) {
        this.userGetByIdHandler = userGetByIdHandler;
        this.userGetAllHandler = userGetAllHandler;
    }

    public CategorieUserGetByIdOutput getById(CategorieUserGetByIdQuery query){
        return userGetByIdHandler.handle(query);
    }

    public CategorieUserGetAllOutput getAll(CategorieUserGetAllQuery query) {
        return userGetAllHandler.handle(query);
    }

}
