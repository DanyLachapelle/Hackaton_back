package school.token.hackaton_groupe7.controller.users;



import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.user.queries.UserQueryProcessor;
import school.token.hackaton_groupe7.application.features.user.queries.getAllUsers.UserGetAllCommand;
import school.token.hackaton_groupe7.application.features.user.queries.getAllUsers.UserGetAllOutput;
import school.token.hackaton_groupe7.application.features.user.queries.getByIdUser.UserGetByIdOutput;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserQueryController {
    private final UserQueryProcessor userQueryProcessor;
    private final IUserRepository userRepository;
    public UserQueryController(UserQueryProcessor userQueryProcessor, IUserRepository userRepository) {
        this.userQueryProcessor = userQueryProcessor;
        this.userRepository = userRepository;
    }


    @GetMapping()
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "204", description = "No Content - No users found")
    })
    public ResponseEntity<Iterable<UserGetAllOutput.User>> getAll() {
        Iterable<UserGetAllOutput.User> users = userQueryProcessor.getAllUsers(new UserGetAllCommand()).users;
        if (!users.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/test-db")
    public String testDbConnection() {
        long count = userRepository.count();
        return "La base de données contient " + count + " utilisateurs.";
    }

    @GetMapping("/{id}")
    @ApiResponses({
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<UserGetByIdOutput> getById(@PathVariable() int id) {
        UserGetByIdOutput user = userQueryProcessor.getById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Afficher l'utilisateur récupéré dans la console
        System.out.println("Utilisateur récupéré : " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
