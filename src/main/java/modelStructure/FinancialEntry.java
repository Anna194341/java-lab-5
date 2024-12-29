package modelStructure;

import visitor.FinancialVisitor;
import java.time.LocalDate;

public class FinancialEntry implements FinancialComponent {
    private final double amount;
    private final String description;
    private final String currency;
    private final LocalDate date;
    private final TransactionType type;

    public FinancialEntry(double amount, String description, String currency, LocalDate date, TransactionType type) {
        this.amount = amount;
        this.description = description;
        this.currency = currency;
        this.date = date;
        this.type = type;
    }

    @Override
    public double calculateTotal() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void addComponent(FinancialComponent component) {
        throw new UnsupportedOperationException("Operation not supported for FinancialEntry");
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getCurrency() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public double getAmount() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getDescription() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public LocalDate getDate() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public TransactionType getType() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}