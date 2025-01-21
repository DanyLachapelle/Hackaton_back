package school.token.hackaton_groupe7.application.features.user.commands.deleteUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import school.token.hackaton_groupe7.application.utils.ICommandHandler;
import school.token.hackaton_groupe7.infrastructure.user.IUserRepository;
@Service
public class UserDeleteHandler implements ICommandHandler<Integer,Void> {
    private static final Logger logger = LoggerFactory.getLogger(UserDeleteHandler.class);
    private final IUserRepository userRepository;

    public UserDeleteHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
public Void handle(Integer id) {
    if (userRepository.existsById(id)) {
        userRepository.deleteById(id);
        System.out.println("Utilisateur avec ID " + id + " supprimé.");
    } else {
        System.out.println("Utilisateur avec ID " + id + " non trouvé.");
    }
        return null;
    }
}
