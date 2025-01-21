package school.token.hackaton_groupe7.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.CategorieUserQueryProcessor;
import school.token.hackaton_groupe7.application.features.categorieUser.queries.getAll.CategorieUserGetAllOutput;

import java.util.List;
@RestController
@RequestMapping("/directories")
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

    @GetMapping()
    public Iterable<CategorieUserGetAllOutput.CategorieUser> getAll(Pageable pageable) {
        return categorieUserQueryProcessor.getAll(pageable).categorieUsers;
    }

}