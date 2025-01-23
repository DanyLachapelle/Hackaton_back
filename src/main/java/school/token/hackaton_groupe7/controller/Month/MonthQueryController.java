package school.token.hackaton_groupe7.controller.Month;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.token.hackaton_groupe7.application.features.month.queries.MonthQueryProcessor;
import school.token.hackaton_groupe7.application.features.month.queries.getAll.MonthGetAllOutput;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/months")
@Tag(name = "MonthController")
public class MonthQueryController {
    private final MonthQueryProcessor monthQueryProcessor;

    public MonthQueryController(MonthQueryProcessor monthQueryProcessor) {
        this.monthQueryProcessor = monthQueryProcessor;
    }

    @GetMapping
    @ApiResponse(responseCode = "200")
    public List<MonthGetAllOutput.Month> getAll() {
        return monthQueryProcessor.getAll().month;
    }

}