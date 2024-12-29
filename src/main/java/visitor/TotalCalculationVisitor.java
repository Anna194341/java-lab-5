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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void visitGroup(FinancialGroup group) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public Map<String, Double> getTotalsByCurrency() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}