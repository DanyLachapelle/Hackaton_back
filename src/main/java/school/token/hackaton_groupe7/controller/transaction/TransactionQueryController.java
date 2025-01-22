package school.token.hackaton_groupe7.controller.transaction;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate.TransactionGetAllBetweenDateOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.GetAllBetweenDate.TransactionGetAllBetweenDateQuery;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionGetByCategorie.TransactionGetByCategorieQuery;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionQueryProcessor;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllOutput;
import school.token.hackaton_groupe7.application.features.transaction.queries.getById.TransactionGetByIdOutput;
import school.token.hackaton_groupe7.domain.Transaction;
import school.token.hackaton_groupe7.infrastructure.transaction.DbTransaction;

import java.util.Date;

@RestController
@RequestMapping("/transactions")
public class TransactionQueryController {
    private final TransactionQueryProcessor processor;

    public TransactionQueryController(TransactionQueryProcessor processor) {
        this.processor = processor;
    }

    @GetMapping()
    public Iterable<TransactionGetAllOutput.Transaction> getAll(Pageable pageable) {
        return processor.getAll(pageable).transactions;
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public TransactionGetByIdOutput getById(@PathVariable Integer id) {
        return processor.getById(id);
    }

    @GetMapping("/category/{idCat}")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public TransactionGetByCategorieOutput getByIdCategory(@PathVariable Integer idCat, Pageable pageable) {
        TransactionGetByCategorieQuery query = new TransactionGetByCategorieQuery(pageable, idCat);
        return processor.getByIdCategorie(query);
    }

    @GetMapping("/dates")
    @ApiResponses({
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public Iterable<TransactionGetAllBetweenDateOutput.Transaction> getEntitiesBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            Pageable pageable) {
        TransactionGetAllBetweenDateQuery query = new TransactionGetAllBetweenDateQuery(pageable, startDate, endDate);
        return processor.getBetweenDates(query).transactions;
    }
}
