package school.token.hackaton_groupe7.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.CategorieUserQueryProcessor;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getById.CategorieUserGetByIdOutput;

@RestController
@RequestMapping("/categorieUser")
@Tag(name = "CategorieUserController")
public class CategorieUserQueryController {
    private final CategorieUserQueryProcessor categorieUserQueryProcessor;

    public CategorieUserQueryController(CategorieUserQueryProcessor categorieUserQueryProcessor) {
        this.categorieUserQueryProcessor = categorieUserQueryProcessor;
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

    @GetMapping("/byId")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public CategorieUserGetByIdOutput getById(@PathVariable() int id) {
        return categorieUserQueryProcessor.getById(id);
    }


}