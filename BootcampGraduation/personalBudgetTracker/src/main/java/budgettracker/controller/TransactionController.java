package budgettracker.controller;

import budgettracker.model.Transaction;
import budgettracker.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Add a new transaction
    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    // Get all transactions for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.findByUserId(userId);
        return ResponseEntity.ok(transactions);
    }

    // Get monthly transactions for a user
    @GetMapping("/monthly")
    public ResponseEntity<List<Transaction>> getMonthlyTransactions(
            @RequestParam Long userId,
            @RequestParam int month,
            @RequestParam int year) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        List<Transaction> transactions = transactionService.findByUserIdAndDateBetween(userId, startDate, endDate);
        return ResponseEntity.ok(transactions);
    }
}
