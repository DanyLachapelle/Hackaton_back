package school.token.hackaton_groupe7.controller.transaction;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.token.hackaton_groupe7.application.features.transaction.commands.TransactionCommandProcessor;
import school.token.hackaton_groupe7.application.features.transaction.commands.create.TransactionCreateCommand;
import school.token.hackaton_groupe7.application.features.transaction.commands.create.TransactionCreateOuput;

@RestController
@RequestMapping("/transactions")
public class TransactionCommandController {
    private final TransactionCommandProcessor processor;

    public TransactionCommandController(TransactionCommandProcessor processor) {
        this.processor = processor;
    }

    @PostMapping()
    @ApiResponse(responseCode = "201")
    public ResponseEntity<TransactionCreateOuput> create(@RequestBody TransactionCreateCommand command) {
        return new ResponseEntity<>(processor.create(command), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ApiResponses({@ApiResponse(responseCode = "204"), @ApiResponse(responseCode = "404")})
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        processor.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
