package school.token.hackaton_groupe7.application.features.categorie.queries;

import school.token.hackaton_groupe7.application.features.categorie.queries.getAll.CategorieGetAllOutput;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;

public class CategorieQueryProcessor {
    private final IEmptyParameterizedQueryHandler<CategorieGetAllOutput> categorieGetAllOutputHandler;

    public CategorieQueryProcessor(IEmptyParameterizedQueryHandler<CategorieGetAllOutput> categorieGetAllOutputHandler) {
        this.categorieGetAllOutputHandler = categorieGetAllOutputHandler;
    }

    public CategorieGetAllOutput getAll() {
        return categorieGetAllOutputHandler.handle();
    }
}
