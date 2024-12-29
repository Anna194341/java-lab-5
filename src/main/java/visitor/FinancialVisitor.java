package visitor;

import modelStructure.FinancialGroup;
import modelStructure.FinancialEntry;

public interface FinancialVisitor {
    void visitEntry(FinancialEntry entry);    // Відвідування запису
    void visitGroup(FinancialGroup group);    // Відвідування групи
}
