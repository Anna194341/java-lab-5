import modelStructure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.CurrencyConversionVisitor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyConversionVisitorTest {
    private CurrencyConversionVisitor visitor;
    private Map<String, Double> exchangeRates;
    private LocalDate testDate;

    @BeforeEach
    void setUp() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 1.1);
        exchangeRates.put("GBP", 1.3);

        visitor = new CurrencyConversionVisitor(exchangeRates, "USD");
        testDate = LocalDate.now();
    }

    @Test
    void whenSameCurrency_shouldNotConvert() {
        FinancialEntry entry = new FinancialEntry(
                100.0,
                "USD Transaction",
                "USD",
                testDate,
                TransactionType.INCOME
        );
        visitor.visitEntry(entry);
        assertEquals(100.0, visitor.getConvertedTotal(), 0.001);
    }

    @Test
    void whenDifferentCurrency_shouldConvertCorrectly() {
        FinancialEntry entry = new FinancialEntry(
                100.0,
                "EUR Transaction",
                "EUR",
                testDate,
                TransactionType.INCOME
        );
        visitor.visitEntry(entry);
        assertEquals(110.0, visitor.getConvertedTotal(), 0.001); // 100 EUR = 110 USD
    }

    @Test
    void whenMultipleEntries_shouldSumCorrectly() {
        FinancialEntry usdEntry = new FinancialEntry(
                100.0, "USD Transaction", "USD", testDate, TransactionType.INCOME
        );
        FinancialEntry eurEntry = new FinancialEntry(
                100.0, "EUR Transaction", "EUR", testDate, TransactionType.INCOME
        );
        FinancialEntry gbpEntry = new FinancialEntry(
                100.0, "GBP Transaction", "GBP", testDate, TransactionType.INCOME
        );
        visitor.visitEntry(usdEntry);
        visitor.visitEntry(eurEntry);
        visitor.visitEntry(gbpEntry);
        assertEquals(340.0, visitor.getConvertedTotal(), 0.0);
    }

    @Test
    void whenReset_shouldClearTotal() {
        FinancialEntry entry = new FinancialEntry(
                100.0,
                "EUR Transaction",
                "EUR",
                testDate,
                TransactionType.INCOME
        );
        visitor.visitEntry(entry);
        visitor.resetConvertedTotal();
        assertEquals(0.0, visitor.getConvertedTotal(), 0.0);
    }
}