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
        return amount;
    }

    @Override
    public void addComponent(FinancialComponent component) {
        throw new UnsupportedOperationException("Operation not supported for FinancialEntry");
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        visitor.visitEntry(this);
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }
}