package school.token.hackaton_groupe7.controller.users;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.user.commands.UserCommandProcessor;
import school.token.hackaton_groupe7.application.features.user.commands.createUser.CreateUserCommand;
import school.token.hackaton_groupe7.application.features.user.commands.createUser.CreateUserOutput;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserCommand;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserOutput;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
@Validated
public class UserCommandController {

    private final UserCommandProcessor userCommandProcessor;
    private final IUserRepository userRepository;

    public UserCommandController(UserCommandProcessor userCommandProcessor, IUserRepository userRepository) {
        this.userCommandProcessor = userCommandProcessor;
        this.userRepository = userRepository;
    }



    @PostMapping("/api/users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<CreateUserOutput> createUser(@RequestBody CreateUserCommand createUserCommand) {
        System.out.println("Requête reçue pour créer un utilisateur : " + createUserCommand);
        if (createUserCommand.getUsername() == null || createUserCommand.getMail() == null) {
            System.out.println("Invalid request body: " + createUserCommand);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CreateUserOutput output = userCommandProcessor.createUser(createUserCommand);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }


@DeleteMapping("/{id}")
@ApiResponses({
        @ApiResponse(responseCode = "204", description = "User successfully deleted"),
        @ApiResponse(responseCode = "404", description = "User not found")
})
public ResponseEntity<Void> deleteUser(@PathVariable int id) {
    userCommandProcessor.delete(id);
    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
}

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserOutput> updateUser(@PathVariable Integer id, @RequestBody UpdateUserCommand updateUserCommand) {
        System.out.println("Requête reçue pour mettre à jour un utilisateur : " + updateUserCommand);
        UpdateUserOutput output = userCommandProcessor.updateUser(id, updateUserCommand);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
