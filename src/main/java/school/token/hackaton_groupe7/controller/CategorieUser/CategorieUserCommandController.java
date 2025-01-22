package school.token.hackaton_groupe7.controller.CategorieUser;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.CategorieUserCommandProcessor;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.create.CategorieUserCreateCommand;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.create.CategorieUserCreateOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.commands.update.CategorieUserUpdateCommand;


@RestController
@RequestMapping("/categorieUsers")
@Tag(name = "CategorieUserController")
public class CategorieUserCommandController {
    private final CategorieUserCommandProcessor categorieUserCommandProcessor;

    public CategorieUserCommandController(CategorieUserCommandProcessor categorieUserCommandProcessor) {
        this.categorieUserCommandProcessor = categorieUserCommandProcessor;
    }

    @PostMapping()
    @ApiResponse(responseCode = "201")
    public ResponseEntity<CategorieUserCreateOutput> create(@RequestBody CategorieUserCreateCommand command) {
        return new ResponseEntity<>(categorieUserCommandProcessor.create(command), HttpStatus.CREATED);
    }
    @PatchMapping("{id}")
    @ApiResponses({@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    public ResponseEntity<Void> update(@PathVariable() int id, @RequestBody CategorieUserUpdateCommand command) {
        command.id = id;
        categorieUserCommandProcessor.update(command);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}/delete")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Void> delete(@PathVariable() Integer id) {
        categorieUserCommandProcessor.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
