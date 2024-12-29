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
        report.append("    ".repeat(indentationLevel));

        report.append(String.format(
                "- %s: %.2f %s (%s) - %s%n",
                entry.getType(),
                entry.getAmount(),
                entry.getCurrency(),
                entry.getDate(),
                entry.getDescription()
        ));
    }

    @Override
    public void visitGroup(FinancialGroup group) {
        report.append("    ".repeat(indentationLevel));

        report.append(String.format("Group: %s (Base Currency: %s)%n",
                group.getName(),
                group.getCurrency()
        ));

        indentationLevel++;

        for (FinancialComponent component : group.getComponents()) {
            component.accept(this);
        }

        indentationLevel--;

        if (indentationLevel == 0) {
            report.append("\n");
        }
    }

    public String getReport() {
        return report.toString();
    }
}