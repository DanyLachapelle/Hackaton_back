package school.token.hackaton_groupe7.application.utils;

public interface IQueryHandler<I, O> {
    O handle(I input);
}
