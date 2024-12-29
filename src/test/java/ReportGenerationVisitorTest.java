import visitor.*;

import modelStructure.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportGenerationVisitorTest {

    @Test
    public void testReportGenerationVisitorWithoutGroupHeader() {
        Locale.setDefault(Locale.US);

        FinancialEntry entry1 = new FinancialEntry(100.0, "Salary", "USD", LocalDate.of(2024, 12, 1), TransactionType.INCOME);
        FinancialEntry entry2 = new FinancialEntry(50.0, "Groceries", "USD", LocalDate.of(2024, 12, 15), TransactionType.EXPENSE);
        FinancialEntry entry3 = new FinancialEntry(200.0, "Freelance", "USD", LocalDate.of(2024, 12, 10), TransactionType.INCOME);

        FinancialGroup group = new FinancialGroup("Monthly Budget", "USD");
        group.addComponent(entry1);
        group.addComponent(entry2);
        group.addComponent(entry3);

        ReportGenerationVisitor visitor = new ReportGenerationVisitor();

        group.accept(visitor);

        String report = visitor.getReport();

        String filteredReport = report.lines()
                .filter(line -> line.startsWith("    - INCOME") || line.startsWith("    - EXPENSE"))
                .map(line -> line.trim()) // Remove leading spaces
                .reduce((line1, line2) -> line1 + "\n" + line2)
                .orElse("");

        String expectedReport =
                "- INCOME: 100.00 USD (2024-12-01) - Salary\n" +
                        "- EXPENSE: 50.00 USD (2024-12-15) - Groceries\n" +
                        "- INCOME: 200.00 USD (2024-12-10) - Freelance";

        assertEquals(expectedReport, filteredReport);
    }
}