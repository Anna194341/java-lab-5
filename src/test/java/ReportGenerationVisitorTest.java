import modelStructure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.ReportGenerationVisitor;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

class ReportGenerationVisitorTest {
    private ReportGenerationVisitor visitor;
    private FinancialGroup rootGroup;

    @BeforeEach
    void setUp() {
        visitor = new ReportGenerationVisitor();

        rootGroup = new FinancialGroup("Root", "USD");
        FinancialGroup subGroup = new FinancialGroup("SubGroup", "USD");

        subGroup.addComponent(new FinancialEntry(1000.0, "Entry 1", "USD",
                LocalDate.now(), TransactionType.INCOME));
        rootGroup.addComponent(subGroup);
        rootGroup.addComponent(new FinancialEntry(500.0, "Entry 2", "USD",
                LocalDate.now(), TransactionType.EXPENSE));
    }

    @Test
    void getReport_ShouldGenerateFormattedReport() {
        rootGroup.accept(visitor);
        String report = visitor.getReport();

        assertTrue(report.contains("Root"));
        assertTrue(report.contains("SubGroup"));
        assertTrue(report.contains("Entry 1"));
        assertTrue(report.contains("Entry 2"));
        assertTrue(report.contains("1000.0"));
        assertTrue(report.contains("500.0"));
    }
}