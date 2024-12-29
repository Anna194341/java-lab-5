import modelStructure.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import visitor.CurrencyConversionVisitor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CurrencyConversionVisitorTest {
    private CurrencyConversionVisitor visitor;
    private FinancialGroup group;
    private Map<String, Double> exchangeRates;

    @BeforeEach
    void setUp() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("EUR", 1.2); // 1 EUR = 1.2 USD
        exchangeRates.put("USD", 1.0);

        visitor = new CurrencyConversionVisitor(exchangeRates, "USD");

        group = new FinancialGroup("Test Group", "USD");
        group.addComponent(new FinancialEntry(1000.0, "USD Entry", "USD",
                LocalDate.now(), TransactionType.INCOME));
        group.addComponent(new FinancialEntry(500.0, "EUR Entry", "EUR",
                LocalDate.now(), TransactionType.INCOME));
    }

    @Test
    public void getConvertedTotal_ShouldConvertAllCurrenciesToTarget() {
        group.accept(visitor);
        assertEquals(1600.0, visitor.getConvertedTotal()); // 1000 USD + (500 * 1.2) EUR
    }
}