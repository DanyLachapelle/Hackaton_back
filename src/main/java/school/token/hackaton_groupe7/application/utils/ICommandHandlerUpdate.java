package school.token.hackaton_groupe7.application.utils;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserCommand;

@Service
public interface ICommandHandlerUpdate<I,O> {
    O handle(Integer input, UpdateUserCommand command);
}
