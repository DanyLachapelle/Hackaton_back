package school.token.hackaton_groupe7.application.features.dateUser.queries;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.dateUser.queries.GetbyIdUser.DateUserGetByIdUserOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getAll.DateUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.dateUser.queries.getById.DateUserGetByIdOutput;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;

@Service
public class DateUserQueryProcessor {
    private final IQueryHandler<Pageable, DateUserGetAllOutput> getAllHandler;
    private final IQueryHandler<Integer, DateUserGetByIdOutput> getByIdHandler;
    private final IQueryHandler<Integer, DateUserGetByIdUserOutput> getByIdUserHandler;


    public DateUserQueryProcessor(IQueryHandler<Pageable, DateUserGetAllOutput> getAllHandler, IQueryHandler<Integer, DateUserGetByIdOutput> getByIdHandler, IQueryHandler<Integer, DateUserGetByIdUserOutput> getByIdUserHandler) {
        this.getAllHandler = getAllHandler;
        this.getByIdHandler = getByIdHandler;
        this.getByIdUserHandler = getByIdUserHandler;
    }

    public DateUserGetAllOutput getAll(Pageable pageable) {
        return getAllHandler.handle(pageable);
    }


    public DateUserGetByIdOutput getById(Integer id) {
        return getByIdHandler.handle(id);
    }

    public DateUserGetByIdUserOutput getByIdUser(Integer id_user) {
        return getByIdUserHandler.handle(id_user);
    }

}