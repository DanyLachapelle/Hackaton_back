package school.token.hackaton_groupe7.controller.Year;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.token.hackaton_groupe7.application.features.year.queries.YearQueryProcessor;
import school.token.hackaton_groupe7.application.features.year.queries.getAll.YearGetAllOutput;

import java.util.List;

@RestController
@RequestMapping("/years")
@Tag(name = "YearController")
public class YearQueryController {
    private final YearQueryProcessor yearQueryProcessor;

    public YearQueryController(YearQueryProcessor yearQueryProcessor) {
        this.yearQueryProcessor = yearQueryProcessor;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    @ApiResponse(responseCode = "200")
    public List<YearGetAllOutput.Year> getAll() {
        return yearQueryProcessor.getAll().year;
    }

}