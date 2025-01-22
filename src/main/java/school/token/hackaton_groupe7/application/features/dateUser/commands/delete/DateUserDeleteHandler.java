package school.token.hackaton_groupe7.application.features.dateUser.commands.delete;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.exceptions.EntityNotFoundException;
import school.token.hackaton_groupe7.application.utils.ICommandEmptyOutputHandler;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;
import school.token.hackaton_groupe7.infrastructure.repositories.IDateUserRepository;

@Service
public class DateUserDeleteHandler implements ICommandEmptyOutputHandler<Integer> {
    private final IDateUserRepository dateUserRepository;

    public DateUserDeleteHandler(IDateUserRepository dateUserRepository) {
        this.dateUserRepository = dateUserRepository;
    }

    @Override
    public void handle(Integer id) {
        if (dateUserRepository.existsById(id))
            dateUserRepository.deleteById(id);
        else
            throw new EntityNotFoundException(DbDateUser.class, id);
    }
}