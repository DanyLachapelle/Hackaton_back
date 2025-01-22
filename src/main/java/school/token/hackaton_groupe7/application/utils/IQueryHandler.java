package school.token.hackaton_groupe7.application.utils;

import org.springframework.stereotype.Service;

@Service
public interface IQueryHandler<I, O> {
    O handle(I input);
}
