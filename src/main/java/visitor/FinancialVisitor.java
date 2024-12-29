package visitor;

import modelStructure.FinancialGroup;
import modelStructure.FinancialEntry;

public interface FinancialVisitor {
    void visitEntry(FinancialEntry entry);
    void visitGroup(FinancialGroup group);
}
