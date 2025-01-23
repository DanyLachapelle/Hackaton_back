package school.token.hackaton_groupe7.application.features.categorieUser.commands.create;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import school.token.hackaton_groupe7.application.exceptions.DuplicatedEntityException;
import school.token.hackaton_groupe7.application.exeptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;

@Service
public class CategorieUserCreateHandler implements ICommandHandler<CategorieUserCreateCommand, CategorieUserCreateOutput> {
    private final ModelMapper modelMapper;
    private final ICategorieUserRepository categorieUseRepository;
    private final IUserRepository userRepository;

    public CategorieUserCreateHandler(ModelMapper modelMapper, ICategorieUserRepository categorieUseRepository, IUserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.categorieUseRepository = categorieUseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CategorieUserCreateOutput handle(CategorieUserCreateCommand input) {

        // Récupérer l'utilisateur en fonction de l'ID
        DbUser user = userRepository.findById(input.idUser)
                .orElseThrow(() -> new EntityNotFoundException(DbUser.class, input.idUser));

        DbCategorieUser dbCategorieUser = DbCategorieUser.builder()
                .user(user)
                .color(input.color)
                .name(input.name)
                .budget(input.budget)
                .build();

        DbCategorieUser savedDbCategorieUser = categorieUseRepository.save(dbCategorieUser);
        return modelMapper.map(savedDbCategorieUser, CategorieUserCreateOutput.class);
    }
}


