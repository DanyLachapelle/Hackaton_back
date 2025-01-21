package school.token.hackaton_groupe7.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.CategorieUserQueryProcessor;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getAll.CategorieUserGetAllOutput;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getAll.CategorieUserGetAllQuery;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getById.CategorieUserGetByIdOutput;
import school.token.hackaton_groupe7.application.core.categorieUser.queries.getById.CategorieUserGetByIdQuery;

import java.util.List;

@RestController
@Tag(name = "categorieUser")
@RequestMapping("categorieUser")
public class CategorieCategorieUserQueryController {

    private final CategorieUserQueryProcessor categorieUserQueryProcessor;

    public CategorieUserQueryController(CategorieUserQueryProcessor categorieUserQueryProcessor) {
        this.categorieUserQueryProcessor = categorieUserQueryProcessor;
    }

    @GetMapping(path = "{categorieUserId}")
    public CategorieUserGetByIdOutput getById(@PathVariable Long categorieUserId){
        CategorieUserGetByIdQuery query = new CategorieUserGetByIdQuery();
        query.id = categorieUserId;
        return categorieUserQueryProcessor.getById(query);
    }

    @GetMapping
    public ResponseEntity<List<CategorieUserGetAllOutput.CategorieUser>> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortDirection
    ){
        CategorieUserGetAllQuery query = new CategorieUserGetAllQuery();
        query.page = page;
        query.size = size;
        query.sortBy = sortBy;
        query.sortDirection = sortDirection;
        return new ResponseEntity<>(categorieUserQueryProcessor.getAll(query).entities, HttpStatus.OK);
    }
}
