package school.token.hackaton_groupe7.controller.Categorie;

import java.util.List;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.categorie.queries.CategorieQueryProcessor;
import school.token.hackaton_groupe7.application.features.categorie.queries.getAll.CategorieGetAllOutput;

@RestController
@RequestMapping("/categories")
@Tag(name = "CategorieController")
public class CategorieQueryController {
    private final CategorieQueryProcessor categorieQueryProcessor;

    public CategorieQueryController(CategorieQueryProcessor categorieQueryProcessor) {
        this.categorieQueryProcessor = categorieQueryProcessor;
    }

    @GetMapping
    @ApiResponse(responseCode = "200")
    public List<CategorieGetAllOutput.Categorie> getAll() {
        return categorieQueryProcessor.getAll().categorie;
    }

}
