package modelStructure;

import visitor.FinancialVisitor;

import java.util.ArrayList;
import java.util.List;

public class FinancialGroup implements FinancialComponent {
    private final String name;
    private final String currency;
    private final List<FinancialComponent> components;

    public FinancialGroup(String name, String currency) {
        this.name = name;
        this.currency = currency;
        this.components = new ArrayList<>();
    }

    @Override
    public double calculateTotal() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void addComponent(FinancialComponent component) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getCurrency() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public List<FinancialComponent> getComponents() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}