package school.token.hackaton_groupe7.controller.transaction;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import school.token.hackaton_groupe7.application.features.transaction.queries.TransactionQueryProcessor;
import school.token.hackaton_groupe7.application.features.transaction.queries.getAll.TransactionGetAllOutput;

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
}
