package visitor;

import modelStructure.FinancialEntry;
import modelStructure.FinancialGroup;
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
        String entryCurrency = entry.getCurrency();

        if (entryCurrency.equals(targetCurrency)) {
            convertedTotal += entry.getAmount();
            return;
        }

        Double sourceRate = exchangeRates.get(entryCurrency);
        Double targetRate = exchangeRates.get(targetCurrency);

        if (sourceRate == null || targetRate == null) {
            throw new IllegalStateException(
                    "Exchange rate not found for conversion from " +
                            entryCurrency + " to " + targetCurrency
            );
        }

        double convertedAmount = entry.getAmount() * (sourceRate / targetRate);
        convertedTotal += convertedAmount;
    }

    @Override
    public void visitGroup(FinancialGroup group) {
        // Для групи нічого не робимо, оскільки всі обчислення
        // виконуються при відвідуванні окремих записів
        // Група сама викличе accept() для всіх своїх компонентів
    }

    public double getConvertedTotal() {
        return convertedTotal;
    }

    public void resetConvertedTotal() {
        convertedTotal = 0.0;
    }
}