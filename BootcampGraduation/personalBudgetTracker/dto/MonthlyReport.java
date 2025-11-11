package budgettracker.dto;

public class MonthlyReport {
    private Double totalIncome;
    private Double totalExpense;
    private Double totalSaving;
    private String highestSpendingCategory;

    public MonthlyReport(Double totalIncome, Double totalExpense, String highestSpendingCategory) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.totalSaving = totalIncome - totalExpense;
        this.highestSpendingCategory = highestSpendingCategory;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public Double getTotalSaving() {
        return totalSaving;
    }

    public String getHighestSpendingCategory() {
        return highestSpendingCategory;
    }
}
