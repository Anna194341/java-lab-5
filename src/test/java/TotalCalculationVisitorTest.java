
import modelStructure.*;
import visitor.TotalCalculationVisitor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalCalculationVisitorTest {

    @Test
    void testVisitEntryAndGroup() {
        FinancialEntry entry1 = new FinancialEntry(100.0, "Salary", "USD", LocalDate.now(), TransactionType.INCOME);
        FinancialEntry entry2 = new FinancialEntry(50.0, "Groceries", "USD", LocalDate.now(), TransactionType.EXPENSE);
        FinancialEntry entry3 = new FinancialEntry(200.0, "Freelance Work", "EUR", LocalDate.now(), TransactionType.INCOME);

        FinancialGroup group = new FinancialGroup("Monthly Transactions", "USD");
        group.addComponent(entry1);
        group.addComponent(entry2);

        FinancialGroup rootGroup = new FinancialGroup("Yearly Transactions", "USD");
        rootGroup.addComponent(group);
        rootGroup.addComponent(entry3);

        TotalCalculationVisitor visitor = new TotalCalculationVisitor();
        rootGroup.accept(visitor);

        Map<String, Double> totalsByCurrency = visitor.getTotalsByCurrency();

        assertEquals(200.0, totalsByCurrency.get("USD"), "Total in USD should be 200.0");
        assertEquals(400.0, totalsByCurrency.get("EUR"), "Total in EUR should be 400.0");
    }
}
