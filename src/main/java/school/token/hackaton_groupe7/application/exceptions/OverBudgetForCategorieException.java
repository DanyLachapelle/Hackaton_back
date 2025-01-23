package school.token.hackaton_groupe7.application.exceptions;

public class OverBudgetForCategorieException extends RuntimeException {
    public OverBudgetForCategorieException(double bigBudget, double addedBudget, double overBudget)
    {
        super("Le budget de " + addedBudget + " fait dépaser le budget total " + bigBudget + " de " + overBudget);
    }
}
