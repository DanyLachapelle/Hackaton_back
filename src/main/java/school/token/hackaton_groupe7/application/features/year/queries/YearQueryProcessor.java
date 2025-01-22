package school.token.hackaton_groupe7.application.features.year.queries;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.year.queries.getAll.YearGetAllOutput;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;

@Service
public class YearQueryProcessor {
    private final IEmptyParameterizedQueryHandler<YearGetAllOutput> yearGetAllOutputHandler;

    public YearQueryProcessor(IEmptyParameterizedQueryHandler<YearGetAllOutput> yearGetAllOutputHandler) {
        this.yearGetAllOutputHandler = yearGetAllOutputHandler;
    }

    public YearGetAllOutput getAll() {
        return yearGetAllOutputHandler.handle();
    }
}