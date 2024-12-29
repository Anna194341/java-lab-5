import modelStructure.*;
import org.junit.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FinancialGroupTest {
    private FinancialGroup group;
    private FinancialEntry entry1;
    private FinancialEntry entry2;

    void setUp() {
        group = new FinancialGroup("Test Group", "USD");
        entry1 = new FinancialEntry(1000.0, "Entry 1", "USD",
                LocalDate.now(), TransactionType.INCOME);
        entry2 = new FinancialEntry(500.0, "Entry 2", "USD",
                LocalDate.now(), TransactionType.INCOME);
    }

    @Test
    public void calculateTotal_WithEntries_ShouldReturnSum() {
        setUp();
        group.addComponent(entry1);
        group.addComponent(entry2);
        assertEquals(1500.0, group.calculateTotal(), 0.0);
    }

    @Test
    public void getComponents_ShouldReturnAllComponents() {
        setUp();
        group.addComponent(entry1);
        group.addComponent(entry2);
        assertEquals(2, group.getComponents().size());
        assertTrue(group.getComponents().contains(entry1));
        assertTrue(group.getComponents().contains(entry2));
    }

    @Test
    public void testGetCurrency() {
        setUp();
        assertEquals("USD", group.getCurrency());
    }

    @Test
    public void testGetName() {
        setUp();
        assertEquals("Test Group", group.getName());
    }
}
