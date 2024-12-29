package modelStructure;

import visitor.FinancialVisitor;

public interface FinancialComponent {
    double calculateTotal();
    void addComponent(FinancialComponent component);
    void accept(FinancialVisitor visitor);
    String getCurrency();
}