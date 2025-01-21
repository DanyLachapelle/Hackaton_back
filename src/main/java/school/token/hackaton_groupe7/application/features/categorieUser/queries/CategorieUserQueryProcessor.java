package school.token.hackaton_groupe7.application.features.categorieUser.queries;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getById.CategorieUserGetByIdOutput;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

@Service
public class CategorieUserQueryProcessor {
    private final IQueryHandler<Pageable, CategorieUserGetAllOutput> getAllHandler;
    private final IQueryHandler<Long, CategorieUserGetByIdOutput> getByIdHandler;

    public CategorieUserQueryProcessor(IQueryHandler<Pageable, CategorieUserGetAllOutput> getAllHandler, IQueryHandler<Long, CategorieUserGetByIdOutput> getByIdHandler) {
        this.getAllHandler = getAllHandler;
        this.getByIdHandler = getByIdHandler;
    }

    public CategorieUserGetAllOutput getAll(Pageable pageable) {
        return getAllHandler.handle(pageable);
    }


    public CategorieUserGetByIdOutput getById(Long id) {
        return getByIdHandler.handle(id);
    }
}