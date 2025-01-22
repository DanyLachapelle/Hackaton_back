package school.token.hackaton_groupe7.application.features.month.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;
import school.token.hackaton_groupe7.infrastructure.repositories.IMonthRepository;

@Service
public class MonthGetAllHandler implements IEmptyParameterizedQueryHandler<MonthGetAllOutput> {
    private final IMonthRepository monthRepository;
    private final ModelMapper modelMapper;

    public MonthGetAllHandler(IMonthRepository monthRepository, ModelMapper modelMapper) {
        this.monthRepository = monthRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MonthGetAllOutput handle() {
        var output = new MonthGetAllOutput();
        var dbMonths = monthRepository.findAll();

        dbMonths.forEach(dbMonth -> output.month.add(modelMapper.map(dbMonth, MonthGetAllOutput.Month.class)));

        return output;
    }
}
