package school.token.hackaton_groupe7.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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

    @PostMapping("/create")
    @ApiResponse(responseCode = "201")

    public CategorieUserCreateOutput create(@RequestBody CategorieUserCreateCommand command) {
        return categorieUserCommandProcessor.create(command);
    }

/*
    public ResponseEntity<CategorieUserCreateOutput> createUser(
            @RequestBody(
                    required = true,
                    content = @Content(examples = @ExampleObject(value = "{"idUser":"1","name":"lol","budget:"100}"}"))
            ) CategorieUserCreateCommand categorieUserCreateCommand) {
        // Afficher dans la console les informations du user reçu
        System.out.println("Requête reçue pour créer un utilisateur : " + categorieUserCreateCommand);
        // Appel au gestionnaire de commande pour créer l'utilisateur
         CategorieUserCreateOutput output = categorieUserCommandProcessor.create(categorieUserCreateCommand);

        // Retourner une réponse HTTP avec statut 201 (création réussie)
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }
*/
    @PutMapping("/update")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Void> update(@PathVariable() Integer id, @RequestBody CategorieUserUpdateCommand command) {
        command.id = Math.toIntExact(id);
        categorieUserCommandProcessor.update(command);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    @ApiResponses({
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Void> delete(@PathVariable() Integer id) {
        categorieUserCommandProcessor.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
