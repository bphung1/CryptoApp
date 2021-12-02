package crypto.controller;

import crypto.entity.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TransactionController extends ControllerBase{
    @GetMapping("/{portfolioId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsForPortfolio(@PathVariable int portfolioId) {
        return null;
    }

    @PostMapping("/{portfolioId}/newtransaction")
    public ResponseEntity<Transaction> addTransaction(@PathVariable int portfolioId, @RequestBody Transaction transaction) {
        return null;
    }
}
