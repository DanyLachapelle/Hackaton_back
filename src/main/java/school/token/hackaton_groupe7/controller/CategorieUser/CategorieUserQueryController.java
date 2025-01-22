package school.token.hackaton_groupe7.controller.CategorieUser;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.CategorieUserQueryProcessor;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getById.CategorieUserGetByIdOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser.CategorieUserGetByUserHandler;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser.CategorieUserGetByUserOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getByUser.CategorieUserGetByUserQuery;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieQuery;
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

     /*
    @GetMapping
    @ApiResponse(responseCode = "200")
    public List<CategorieUserGetAllOutput.CategorieUser> getAll() {
        return categorieUserQueryProcessor.getAll().categorieUsers;
    }*/

    @GetMapping("/all")
    public Iterable<CategorieUserGetAllOutput.CategorieUser> getAll(Pageable pageable) {
        return categorieUserQueryProcessor.getAll(pageable).categorieUsers;
    }

    @GetMapping("/test-db")
    public String testDbConnection() {
        long count = categorieUserRepository.count();
        return "La base de données contient " + count + " utilisateurs.";
    }

    @GetMapping("/byId")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public CategorieUserGetByIdOutput getById(@RequestParam() int id) {
        return categorieUserQueryProcessor.getById(id);
    }

    @GetMapping("/byUser/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public CategorieUserGetByUserOutput getByIdCategory(@PathVariable Integer id,Pageable pageable) {
        CategorieUserGetByUserQuery query = new CategorieUserGetByUserQuery(id,pageable);
        return categorieUserQueryProcessor.getByUser(query);
    }


}