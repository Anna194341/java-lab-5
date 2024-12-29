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
        double total = 0.0;
        for (FinancialComponent component : components) {
            if (!component.getCurrency().equals(this.currency)) {
                throw new IllegalArgumentException("Currency mismatch in group: " + name);
            }
            total += component.calculateTotal();
        }
        return total;
    }

    @Override
    public void addComponent(FinancialComponent component) {
        components.add(component);
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        visitor.visitGroup(this);
        for (FinancialComponent component : components) {
            component.accept(visitor);
        }
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public List<FinancialComponent> getComponents() {
        return new ArrayList<>(components);
    }
}