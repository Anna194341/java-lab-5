import modelStructure.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import visitor.TotalCalculationVisitor;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TotalCalculationVisitorTest {
    private TotalCalculationVisitor visitor;
    private FinancialGroup group;

    @BeforeEach
    void setUp() {
        visitor = new TotalCalculationVisitor();
        group = new FinancialGroup("Test Group", "USD");
        group.addComponent(new FinancialEntry(1000.0, "Entry 1", "USD",
                LocalDate.now(), TransactionType.INCOME));
        group.addComponent(new FinancialEntry(500.0, "Entry 2", "EUR",
                LocalDate.now(), TransactionType.INCOME));
    }

    @Test
    public void getTotalsByCurrency_ShouldCalculateCorrectTotals() {
        group.accept(visitor);
        Map<String, Double> totals = visitor.getTotalsByCurrency();

        assertEquals(Optional.of(1000.0), totals.get("USD"));
        assertEquals(Optional.of(500.0), totals.get("EUR"));
    }
}