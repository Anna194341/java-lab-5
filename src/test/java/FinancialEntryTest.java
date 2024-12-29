import modelStructure.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FinancialEntryTest {
    private FinancialEntry entry;

    void setUp() {
        entry = new FinancialEntry(1000.0, "Test Entry", "USD",
                LocalDate.now(), TransactionType.INCOME);
    }

    @Test
    public void calculateTotalShouldReturnAmount() {
        setUp();
        assertEquals(1000.0, entry.calculateTotal(), 0.0);
    }

    @Test
    public void gettersShouldReturnCorrectValues() {
        setUp();
        assertEquals(1000.0, entry.getAmount(), 0.0);
        assertEquals("Test Entry", entry.getDescription());
        assertEquals("USD", entry.getCurrency());
        assertEquals(TransactionType.INCOME, entry.getType());
        assertNotNull(entry.getDate());
    }
}