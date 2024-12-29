import modelStructure.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FinancialEntryTest {
    private FinancialEntry entry;

    @Test
    public void calculateTotalShouldReturnAmount() {
        entry = new FinancialEntry(1000.0, "Test Entry", "USD",
                LocalDate.now(), TransactionType.INCOME);
        assertEquals(1000.0, entry.calculateTotal());
    }

    @Test
    public void addComponent_ShouldThrowException() {
        entry = new FinancialEntry(1000.0, "Test Entry", "USD",
                LocalDate.now(), TransactionType.INCOME);
        assertThrows(UnsupportedOperationException.class,
                () -> entry.addComponent(null));
    }

    @Test
    public void gettersShouldReturnCorrectValues() {
        entry = new FinancialEntry(1000.0, "Test Entry", "USD",
                LocalDate.now(), TransactionType.INCOME);
        assertEquals(1000.0, entry.getAmount());
        assertEquals("Test Entry", entry.getDescription());
        assertEquals("USD", entry.getCurrency());
        assertEquals(TransactionType.INCOME, entry.getType());
        assertNotNull(entry.getDate());
    }
}