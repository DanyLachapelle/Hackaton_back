package school.token.hackaton_groupe7.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.CategorieUserCommandProcessor;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.create.CategorieUserCreateCommand;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.create.CategorieUserCreateOutput;
import school.token.hackaton_groupe7.application.core.categorieUser.commands.delete.CategorieUserDeleteCommand;


@RestController
@Tag(name = "CategorieCategorieUser")
@RequestMapping("CategorieCategorieUser")
public class CategorieCategorieUserCommandController {
    private final CategorieUserCommandProcessor categorieUserCommandProcessor;

    public CategorieUserCommandController(CategorieUserCommandProcessor categorieUserCommandProcessor) {
        this.categorieUserCommandProcessor = categorieUserCommandProcessor;
    }

    @PostMapping
    public ResponseEntity<CategorieUserCreateOutput> create(@RequestBody CategorieUserCreateCommand command){
        return new ResponseEntity<>(categorieUserCommandProcessor.create(command), HttpStatus.CREATED);
    }

    /*@PatchMapping(path = "{categorieUserId}")
    public ResponseEntity<CategorieUserPatchRoleOutput> patchRole(
            @PathVariable Long categorieUserId,
            @RequestBody CategorieUserPatchRoleCommand command
    ) {
        command.id = categorieUserId;
        return new ResponseEntity<>(categorieUserCommandProcessor.patchRole(command), HttpStatus.OK);
    }*/


    @DeleteMapping(path = "{categorieUserId}")
    public ResponseEntity<Void> delete(@PathVariable Long categorieUserId){
        CategorieUserDeleteCommand command = new CategorieUserDeleteCommand();
        command.id = categorieUserId;
        categorieUserCommandProcessor.delete(command);
        return ResponseEntity.noContent().build();
    }
}
