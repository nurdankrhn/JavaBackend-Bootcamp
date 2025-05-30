package budgettracker.service;

import budgettracker.model.Transaction;
import budgettracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
}
