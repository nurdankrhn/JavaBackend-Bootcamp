package budgettracker.service;

import budgettracker.dto.MonthlyReport;
import budgettracker.model.Transaction;
import budgettracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    // Constructor Injection
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Save a transaction entity
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Find all transactions by user id
    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    // Find transactions by user id and date range
    public List<Transaction> findByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end) {
        return transactionRepository.findByUserIdAndDateBetween(userId, start, end);
    }

    public MonthlyReport getMonthlyReport(Long userId, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        List<Transaction> transactions = findByUserIdAndDateBetween(userId, startDate, endDate);

        double totalIncome = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        // Find category with highest expense
        Map<String, Double> expenseByCategory = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("expense"))
                .collect(Collectors.groupingBy(
                        t -> t.getCategory().getName(),
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        String highestSpendingCategory = expenseByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No expenses");

        return new MonthlyReport(totalIncome, totalExpense, highestSpendingCategory);
    }
}
