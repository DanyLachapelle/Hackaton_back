package school.token.hackaton_groupe7.application.utils;

public interface ICommandHandler<I, O> {
    O handle(I input);
}
