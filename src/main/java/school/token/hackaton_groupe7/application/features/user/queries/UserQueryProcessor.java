package school.token.hackaton_groupe7.application.features.user.queries;


import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.user.queries.getAllUsers.UserGetAllCommand;
import school.token.hackaton_groupe7.application.features.user.queries.getAllUsers.UserGetAllOutput;
import school.token.hackaton_groupe7.application.features.user.queries.getByIdUser.UserGetByIdHandler;
import school.token.hackaton_groupe7.application.features.user.queries.getByIdUser.UserGetByIdOutput;
import school.token.hackaton_groupe7.application.utils.IQueryHandler;



@Service
public class UserQueryProcessor {
    private final IQueryHandler<UserGetAllCommand, UserGetAllOutput> getAllUsersHandler;
    private final IQueryHandler<Integer,UserGetByIdOutput> userGetByIdHandler;

    public UserQueryProcessor(IQueryHandler<UserGetAllCommand, UserGetAllOutput> getAllUsersHandler, UserGetByIdHandler userGetByIdHandler) {
        this.getAllUsersHandler = getAllUsersHandler;
        this.userGetByIdHandler = userGetByIdHandler;
    }

    public UserGetAllOutput getAllUsers(UserGetAllCommand input) {
        return getAllUsersHandler.handle(input);
    }

    public UserGetByIdOutput getById(int id) {
        return userGetByIdHandler.handle(id);
    }
}
