package visitor;

import modelStructure.*;
import java.util.HashMap;
import java.util.Map;

public class TotalCalculationVisitor implements FinancialVisitor {
    private final Map<String, Double> totalsByCurrency;

    public TotalCalculationVisitor() {
        this.totalsByCurrency = new HashMap<>();
    }

    @Override
    public void visitEntry(FinancialEntry entry) {
        String currency = entry.getCurrency();
        double amount = entry.getAmount();

        if (entry.getType() == TransactionType.EXPENSE) {
            amount = -amount;
        }
        totalsByCurrency.merge(currency, amount, Double::sum);
    }

    @Override
    public void visitGroup(FinancialGroup group) {
        for (FinancialComponent component : group.getComponents()) {
            component.accept(this);
        }
    }

    public Map<String, Double> getTotalsByCurrency() {
        return new HashMap<>(totalsByCurrency);
    }

    public void resetTotalByCurrency () {
        totalsByCurrency.clear();
    }
}