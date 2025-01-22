package school.token.hackaton_groupe7.application.features.categorie.queries.getAll;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.IEmptyParameterizedQueryHandler;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieRepository;

@Service
public class CategorieGetAllHandler implements IEmptyParameterizedQueryHandler<CategorieGetAllOutput> {
    private final ICategorieRepository categorieRepository;
    private final ModelMapper modelMapper;

    public CategorieGetAllHandler(ICategorieRepository categorieRepository, ModelMapper modelMapper) {
        this.categorieRepository = categorieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategorieGetAllOutput handle() {
        var output = new CategorieGetAllOutput();
        var dbCategories = categorieRepository.findAll();

        dbCategories.forEach(dbCategorie -> output.categorie.add(modelMapper.map(dbCategorie, CategorieGetAllOutput.Categorie.class)));

        return output;
    }
}
