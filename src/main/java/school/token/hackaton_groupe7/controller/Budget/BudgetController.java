package school.token.hackaton_groupe7.controller.Budget;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import school.token.hackaton_groupe7.domain.BudgetService;

@RestController
public class BudgetController {

    private BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/api/balance/{userId}/{month}/{year}")
    public double getBalance(@PathVariable int userId, @PathVariable int month, @PathVariable int year) {
        return budgetService.getUserBalance(userId, month, year);
    }

    @GetMapping("/api/balance/{userId}/{month}/{year}/{categoryId}")
    public double getBalance(@PathVariable int userId, @PathVariable int month, @PathVariable int year, @PathVariable int categoryId) {
        return budgetService.getUserBalanceByCat(userId, month, year,categoryId);
    }
}
