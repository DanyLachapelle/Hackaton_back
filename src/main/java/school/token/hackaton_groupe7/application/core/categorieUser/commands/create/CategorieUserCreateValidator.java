package school.token.hackaton_groupe7.application.core.categorieUser.commands.create;


import school.token.hackaton_groupe7.application.shared.cqrscore.exceptions.EntityAlreadyExistsException;
import school.token.hackaton_groupe7.infrastructure.repositories.ICategorieUserRepository;


public class CategorieUserCreateValidator {
    private final ICategorieUserRepository userRepository;

    public CategorieUserCreateValidator(ICategorieUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(CategorieUserCreateCommand input) {
        if(userRepository.existsById(input.id))
            throw new EntityAlreadyExistsException("CategorieUser already exists with this id: " + input.id);
    }
}
