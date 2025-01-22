package school.token.hackaton_groupe7.application.features.month.queries;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.month.queries.getAll.MonthGetAllOutput;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;

@Service
public class MonthQueryProcessor {
    private final IEmptyParameterizedQueryHandler<school.token.hackaton_groupe7.application.features.month.queries.getAll.MonthGetAllOutput> monthGetAllOutputHandler;

    public MonthQueryProcessor(IEmptyParameterizedQueryHandler<MonthGetAllOutput> monthGetAllOutputHandler) {
        this.monthGetAllOutputHandler = monthGetAllOutputHandler;
    }

    public MonthGetAllOutput getAll() {
        return monthGetAllOutputHandler.handle();
    }
}