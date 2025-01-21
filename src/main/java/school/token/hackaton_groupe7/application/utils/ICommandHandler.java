package school.token.hackaton_groupe7.application.utils;

import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserCommand;
import school.token.hackaton_groupe7.application.features.user.commands.updateUser.UpdateUserOutput;

@Service
public interface ICommandHandler<I, O> {
    O handle(I input);

}
