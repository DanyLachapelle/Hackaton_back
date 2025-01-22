package school.token.hackaton_groupe7.controller.CategorieUser;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.CategorieUserQueryProcessor;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getById.CategorieUserGetByIdOutput;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;

@RestController
@RequestMapping("/categorieUser")
@Tag(name = "CategorieUserController")
public class CategorieUserQueryController {
    private final CategorieUserQueryProcessor categorieUserQueryProcessor;
    private final ICategorieUserRepository categorieUserRepository;

    public CategorieUserQueryController(CategorieUserQueryProcessor categorieUserQueryProcessor, ICategorieUserRepository categorieUserRepository) {
        this.categorieUserQueryProcessor = categorieUserQueryProcessor;
        this.categorieUserRepository = categorieUserRepository;
    }


    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/all")
    @ApiResponse(responseCode = "200")@ApiResponse(responseCode = "200")
    public Iterable<CategorieUserGetAllOutput.CategorieUser> getAll(Pageable pageable) {
        return categorieUserQueryProcessor.getAll(pageable).categorieUsers;
    }

    @GetMapping("/test-db")
    public String testDbConnection() {
        long count = categorieUserRepository.count();
        return "La base de données contient " + count + " utilisateurs.";
    }

    @GetMapping("{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<CategorieUserGetByIdOutput> getById(@PathVariable() int id) {
        CategorieUserGetByIdOutput categorieUser = categorieUserQueryProcessor.getById(id);
        if(categorieUser == null) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categorieUser, HttpStatus.OK);
    }


}