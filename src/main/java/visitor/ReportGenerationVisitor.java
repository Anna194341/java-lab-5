package visitor;

import modelStructure.*;

public class ReportGenerationVisitor implements FinancialVisitor {
    private final StringBuilder report;
    private int indentationLevel;

    public ReportGenerationVisitor() {
        this.report = new StringBuilder();
        this.indentationLevel = 0;
    }

    @Override
    public void visitEntry(FinancialEntry entry) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void visitGroup(FinancialGroup group) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getReport() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}