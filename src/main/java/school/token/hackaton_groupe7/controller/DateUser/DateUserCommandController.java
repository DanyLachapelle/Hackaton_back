package school.token.hackaton_groupe7.controller.DateUser;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.dateUser.commands.DateUserCommandProcessor;
import school.token.hackaton_groupe7.application.features.dateUser.commands.create.DateUserCreateCommand;
import school.token.hackaton_groupe7.application.features.dateUser.commands.create.DateUserCreateOutput;
import school.token.hackaton_groupe7.application.features.dateUser.commands.update.DateUserUpdateCommand;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/dateUsers")
@Tag(name = "DateUserController")
public class DateUserCommandController {
    private final DateUserCommandProcessor dateUserCommandProcessor;

    public DateUserCommandController(DateUserCommandProcessor dateUserCommandProcessor) {
        this.dateUserCommandProcessor = dateUserCommandProcessor;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping()
    @ApiResponse(responseCode = "201")
    public ResponseEntity<DateUserCreateOutput> create(@RequestBody DateUserCreateCommand command) {
        return new ResponseEntity<>(dateUserCommandProcessor.create(command), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PatchMapping("/update/{id}")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    public ResponseEntity<Void> update(@PathVariable() int id, @RequestBody DateUserUpdateCommand command) {
        command.id = id;
        dateUserCommandProcessor.update(command);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}/delete")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Void> delete(@PathVariable() Integer id) {
        dateUserCommandProcessor.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
