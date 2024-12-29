import modelStructure.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FinancialGroupTest {
    private FinancialGroup group;
    private FinancialEntry entry1;
    private FinancialEntry entry2;

    @BeforeEach
    void setUp() {
        group = new FinancialGroup("Test Group", "USD");
        entry1 = new FinancialEntry(1000.0, "Entry 1", "USD",
                LocalDate.now(), TransactionType.INCOME);
        entry2 = new FinancialEntry(500.0, "Entry 2", "USD",
                LocalDate.now(), TransactionType.INCOME);
    }

    @Test
    public void calculateTotal_EmptyGroup_ShouldReturnZero() {
        assertEquals(0.0, group.calculateTotal());
    }

    @Test
    public void calculateTotal_WithEntries_ShouldReturnSum() {
        group.addComponent(entry1);
        group.addComponent(entry2);
        assertEquals(1500.0, group.calculateTotal());
    }

    @Test
    public void getComponents_ShouldReturnAllComponents() {
        group.addComponent(entry1);
        group.addComponent(entry2);
        assertEquals(2, group.getComponents().size());
        assertTrue(group.getComponents().contains(entry1));
        assertTrue(group.getComponents().contains(entry2));
    }
}
