package visitor;

import modelStructure.*;
import java.util.Map;

public class CurrencyConversionVisitor implements FinancialVisitor {
    private final Map<String, Double> exchangeRates;
    private final String targetCurrency;
    private double convertedTotal;

    public CurrencyConversionVisitor(Map<String, Double> exchangeRates, String targetCurrency) {
        this.exchangeRates = exchangeRates;
        this.targetCurrency = targetCurrency;
        this.convertedTotal = 0.0;
    }

    @Override
    public void visitEntry(FinancialEntry entry) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void visitGroup(FinancialGroup group) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public double getConvertedTotal() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}