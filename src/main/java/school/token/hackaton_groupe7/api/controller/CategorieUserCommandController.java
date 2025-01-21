package school.token.hackaton_groupe7.api.controller;

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
    private final CategorieUserCommandProcessor directoryCommandProcessor;

    public CategorieUserCommandController(CategorieUserCommandProcessor directoryCommandProcessor) {
        this.directoryCommandProcessor = directoryCommandProcessor;
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public CategorieUserCreateOutput create(@RequestBody CategorieUserCreateCommand command) {
        return directoryCommandProcessor.create(command);
    }

    @PutMapping("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Void> update(@PathVariable() Long id, @RequestBody CategorieUserUpdateCommand command) {
        command.id = Math.toIntExact(id);
        directoryCommandProcessor.update(command);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Void> delete(@PathVariable() Long id) {
        directoryCommandProcessor.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
