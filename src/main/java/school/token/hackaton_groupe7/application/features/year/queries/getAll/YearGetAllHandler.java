package school.token.hackaton_groupe7.application.features.year.queries.getAll;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;
import school.token.hackaton_groupe7.infrastructure.repositories.IYearRepository;

@Service
public class YearGetAllHandler implements IEmptyParameterizedQueryHandler<YearGetAllOutput> {
    private final IYearRepository yearRepository;
    private final ModelMapper modelMapper;

    public YearGetAllHandler(IYearRepository yearRepository, ModelMapper modelMapper) {
        this.yearRepository = yearRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public YearGetAllOutput handle() {
        var output = new YearGetAllOutput();
        var dbYears = yearRepository.findAll();

        dbYears.forEach(dbYear -> output.year.add(modelMapper.map(dbYear, YearGetAllOutput.Year.class)));

        return output;
    }
}